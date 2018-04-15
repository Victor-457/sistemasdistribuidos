package faculdade.sistemasDistribuidos.trabalho1.rmi;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;

import faculdade.sistemasDistribuidos.trabalho1.jpa.Nota;
import faculdade.sistemasDistribuidos.trabalho1.jpa.NotaId;
import faculdade.sistemasDistribuidos.trabalho1.jpa.util.JPAUtil;
import faculdade.sistemasDistribuidos.trabalho1.jpa.util.Querys;
import javassist.NotFoundException;

public class RepositorioNotasRMI extends UnicastRemoteObject implements RepositorioNotasInterface
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected RepositorioNotasRMI() throws RemoteException{
		super();
	}
	public void cadastrar_nota(String matriculaAluno, String codigoDisciplina, BigDecimal nota) throws RemoteException, IllegalArgumentException{
		NotaId notaId = new NotaId(codigoDisciplina,matriculaAluno);
		if(Querys.existeNotaDisciplina(notaId)){//ja existe nota, apenas atualizo
			EntityManager em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			
			Nota notaExistente = em.find(Nota.class, notaId);
			notaExistente.setNota(nota);//atualizo nota, nao precisa do persist, pois esta no estado Managed
			em.getTransaction().commit();
			em.close();
		}else{//nao existe nota para a disciplina
			
			Nota notaAluno = new Nota(notaId);
			notaAluno.setNota(nota);
		
			EntityManager em = new JPAUtil().getEntityManager();
			
			em.getTransaction().begin();
			em.persist(notaAluno);
			em.getTransaction().commit();
			
			em.close();
		}

		
	}

	public BigDecimal consultar_nota(String matriculaAluno, String codigoDisciplina) throws RemoteException{
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		NotaId notaId = new NotaId(codigoDisciplina,matriculaAluno);
		Nota nota = em.find(Nota.class, notaId);
	
		
		em.getTransaction().commit();
		em.close();
		
		return nota.getNota();
	}

	public List<BigDecimal> consultar_notas(String matriculaAluno) throws RemoteException{
		if(Querys.existeNota(matriculaAluno)){
			return Querys.listaNotas(matriculaAluno);
		}
		return null;
	}

	public BigDecimal consular_cr(String matriculaAluno) throws RemoteException{
		List<BigDecimal> notas = consultar_notas(matriculaAluno);
		if(!notas.equals(null)){
			BigDecimal soma = notas.stream().reduce((x, y) -> x.add(y)).get();
			return soma.divide(new BigDecimal(notas.size()));
		}
		return null;
	}

}

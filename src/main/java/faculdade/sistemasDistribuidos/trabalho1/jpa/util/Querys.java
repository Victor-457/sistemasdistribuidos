package faculdade.sistemasDistribuidos.trabalho1.jpa.util;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import faculdade.sistemasDistribuidos.trabalho1.jpa.NotaId;

public class Querys {
	public static boolean existeNotaDisciplina(NotaId notaId){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		String jpql = "select count(n) from Nota n where n.codigoDisciplinaMatriculaAluno = :pNotaId";
	
		Query query =  em.createQuery(jpql);
		query.setParameter("pNotaId", notaId);
		long resultadoCount = (Long) query.getResultList().get(0);
		
		em.getTransaction().commit();
		em.close();
		
		return resultadoCount == 1? true: false;
	}
	
	public static boolean existeNota(String matriculaAluno){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		String jpql = "select count(n) from Nota n where n.codigoDisciplinaMatriculaAluno.matriculaAluno = :pMatriculaAluno";
	
		Query query =  em.createQuery(jpql);
		query.setParameter("pMatriculaAluno", matriculaAluno);
		long resultadoCount = (Long) query.getResultList().get(0);
		
		em.getTransaction().commit();
		em.close();
		
		return resultadoCount == 1? true: false;
	}
	
	public static List<BigDecimal> listaNotas(String matriculaAluno){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		String jpql = "select n.nota from Nota n where n.codigoDisciplinaMatriculaAluno.matriculaAluno = :pMatriculaAluno";
	
		Query query =  em.createQuery(jpql);
		query.setParameter("pMatriculaAluno", matriculaAluno);
		List<BigDecimal> notas= query.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return notas;
	}
}

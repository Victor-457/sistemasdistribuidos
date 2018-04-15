package faculdade.sistemasDistribuidos.trabalho1;

import javax.persistence.EntityManager;

import faculdade.sistemasDistribuidos.trabalho1.jpa.Nota;
import faculdade.sistemasDistribuidos.trabalho1.jpa.NotaId;
import faculdade.sistemasDistribuidos.trabalho1.jpa.util.JPAUtil;

public class BuscaTeste {
	
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		NotaId notaId = new NotaId("AA123","201578011-2");
		Nota nota = em.find(Nota.class, notaId);
		System.out.println(nota.getMatriculaAluno());
		em.getTransaction().commit();
	}

}

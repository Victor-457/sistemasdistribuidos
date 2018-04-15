package faculdade.sistemasDistribuidos.trabalho1;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import faculdade.sistemasDistribuidos.trabalho1.jpa.Nota;
import faculdade.sistemasDistribuidos.trabalho1.jpa.NotaId;
import faculdade.sistemasDistribuidos.trabalho1.jpa.util.JPAUtil;

public class PersistenciaTeste{
	public static void main(String[] args) {
		NotaId notaId = new NotaId("AA123","201578011-2");
		Nota nota = new Nota(notaId);
		nota.setNota(new BigDecimal(7.1));
	
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(nota);
		em.getTransaction().commit();
		
		
		em.close();
		
	}
}

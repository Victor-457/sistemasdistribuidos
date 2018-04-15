package faculdade.sistemasDistribuidos.trabalho1.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("notas");
	
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
}

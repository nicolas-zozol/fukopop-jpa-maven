package io.robusta.fora;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmFactory {

	private static EntityManagerFactory instance;

	private EmFactory() {
		// "fora" was the value of the name attribute of the
		// persistence.xml file.
		instance = Persistence.createEntityManagerFactory("funkopop");
	}

	public EntityManager getEntityManager() {
		return instance.createEntityManager();
	}

	public void close() {
		instance.close();
	}
	
	public static EntityManagerFactory getInstance(){
		if (instance == null){
			instance = Persistence.createEntityManagerFactory("funkopop");
		}
		return instance;
	}
	
	public static EntityManager createEntityManager(){
		return getInstance().createEntityManager();
	}
	
	public static void transaction(EmWorker worker){
		
		EntityManager em = createEntityManager();
		em.getTransaction().begin();
		
		worker.work(em);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
}

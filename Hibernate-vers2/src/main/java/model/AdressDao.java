package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Adress;

public class AdressDao {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("connect");

	public Adress saveAdressr(Adress adress) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		adress = em.merge(adress);
		tx.commit();
		
		return adress;
	}

}

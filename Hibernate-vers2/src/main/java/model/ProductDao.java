package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Product;

public class ProductDao {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("connect");

	public void saveProduct(Product product) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		
		if (product.getId() == null) {
			em.persist(product);
		} else {
			em.merge(product);
		}

		tx.commit();
	}

}

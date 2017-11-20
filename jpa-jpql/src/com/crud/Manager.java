package com.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Manager {
	public static void main(String[] args) {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");

		/* Create and populate Entity */
		User user = new User();
		user.setName("rahul");
		user.setEmail("rahul@gmail.com");
		user.setMobileNo(2233445566l);

		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();

		/* Persist entity */
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		User user2 = new User();
		user2.setName("pavan");
		user2.setEmail("pavan@gmail.com");
		user2.setMobileNo(6677445566l);

		

		/* Persist entity */
		em.getTransaction().begin();
		em.persist(user2);
		em.getTransaction().commit();
		
		
		//1)List<User> users = em.createQuery("SELECT u FROM User u").getResultList();
		//2)
		Query query  = em.createQuery("SELECT u FROM User u where u.name=:userName");
		query.setParameter("userName","rahul");
		
		List<User> users = query.getResultList();
		
		
		query  = em.createQuery("SELECT u.name,u.email FROM User u");
		
		
		List<String[]> userNames = query.getResultList();
		
		userNames.forEach(itm -> System.out.println(itm));
		System.out.println();
		
	}
}

package com.onetoone;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.onetoone.User;

public class Manager {
	public static void main(String[] args) {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");
		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();
		/* Create and populate Entity */
		User user = new User();
		user.setName("rahul");
		user.setEmail("rahul@gmail.com");
		user.setMobileNo(2233445566l);
		Address address = new Address();
		address.setAddress1("near big bazar");
		address.setCity("pune");
		//address.setUser(user);
		user.setAddress(address);
		User user1 = new User();
		user1.setName("rahul1");
		user1.setEmail("rahul1@gmail.com");
		user1.setMobileNo(7733445566l);
		
		
	
		em.getTransaction().begin();
		em.persist(user);
		em.persist(user1);
		em.getTransaction().commit();
		
		Query query  = em.createQuery("SELECT a FROM User u right join u.address a");
		
		
		List<Address> users = query.getResultList();
		
		//user = em.find(User.class, 1l);
		//System.out.println(user.getAddress());
		
	}
}

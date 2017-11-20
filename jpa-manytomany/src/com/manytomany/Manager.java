package com.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



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
		Address address1 = new Address();
		address1.setAddress1("near big bazar");
		address1.setCity("pune");
		List<Address> addresses  = new ArrayList<>();
		addresses.add(address);
		addresses.add(address1);
		user.setAddress(addresses);
	
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		
		
		
	}
}

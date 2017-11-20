package com.onetoone;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		user.setAddress(address);
		User user1 = new User();
		user1.setName("pankaj");
		user1.setEmail("pankaj@gmail.com");
		user1.setMobileNo(7733445566l);
		Address address1 = new Address();
		address1.setAddress1("baner");
		address1.setCity("mumbai");
		address1.setUser(user1);
		user1.setAddress(address1);
	
		em.getTransaction().begin();
		em.persist(user);
		em.persist(user1);
		em.getTransaction().commit();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> userRoot = query.from(User.class);
		query.select(userRoot).where(cb.equal(userRoot.get("address"),"pankaj"));
		//query.select(userRoot).where(cb.equal(userRoot.get("address").get("city"),"mumbai"));
		TypedQuery<User> typedQuery = em.createQuery(query);
		List<User> users = (List<User>) typedQuery.getResultList();
		System.out.println();

		
	}
}

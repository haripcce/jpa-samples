package com.onetomany;

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
		UserId userId = new UserId();
		userId.setName("rahul");
		userId.setEmail("rahul@gmail.com");
		/*User user = new User();
		
		user.setMobileNo(2233445566l);
		Address address1 = new Address();
		address1.setAddress1("111");
		City city = new City();
		city.setCityCode("123");
		city.setCityName("pune");
		address1.setCity(city);
		address1.setUser(user);
		
		user.setId(userId);
		List<Address> adds = new ArrayList<>();
		adds.add(address1);
		user.setAddress(adds);
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();*/
		
		
		User userTwo = em.find(User.class, userId);
		System.out.println(userTwo.getAddress());
	

		
	}
}

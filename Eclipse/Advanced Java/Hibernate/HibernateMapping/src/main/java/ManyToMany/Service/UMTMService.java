package com.Entity.ManyToMany_Mapping.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Entity.ManyToMany_Mapping.Entity.Students;

public class UMTMService {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("nilendra");

	//	========== Uni-directional Many To Many Mapping==================================================================================
	
	public void insertMTM(Students std1, Students std2, Students std3, Students std4) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(std1);
		em.persist(std2);
		em.persist(std3);
		em.persist(std4);
		em.getTransaction().commit();
	}
}

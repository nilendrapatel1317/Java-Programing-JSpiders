package com.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Entity.CRUD_Operation.Student;
import com.Entity.ManyToMany_Mapping.Entity.Students;
import com.Entity.ManyToMany_Mapping.Entity.Subjects;
import com.Entity.ManyToOne_Mapping.Product;
import com.Entity.ManyToOne_Mapping.Reviews;
import com.Entity.OneToMany_Mapping.Book;
import com.Entity.OneToMany_Mapping.Library;
import com.Entity.OneToOne_Mapping.Car;
import com.Entity.OneToOne_Mapping.Engine;
import com.Entity.OneToOne_Mapping.Passport;
import com.Entity.OneToOne_Mapping.Person;

import java.util.List;
import java.util.Scanner;

public class UMTOService {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("nilendra");
	
//	========== Uni-directional Many To One Mapping==================================================================================

	public void insertMTO(Product p1, Reviews r1, Reviews r2) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(r1);
		em.persist(r2);
		em.getTransaction().commit();

	}

	public Product fetchMTO(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Product.class, id);
	}

	public boolean deleteMTO(Product bank) {
		EntityManager em = emf.createEntityManager();
		if (bank != null) {
			em.getTransaction().begin();
			em.remove(bank);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
}

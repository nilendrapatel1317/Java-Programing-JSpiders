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

public class BOTOService {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("nilendra");
	
//	========== Bi-directional One To One Mapping==================================================================================

	public void insertBiOTO(Car c1) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c1);
		em.getTransaction().commit();
	}

	public void updateCarAndEngine(int i) {
		EntityManager em = emf.createEntityManager();
		Car c1 =em.find(Car.class, i);
		if(c1 != null) {
			c1.setPrice(800000);
			Engine e1 = c1.getEngine();
			if(e1!=null) {
				e1.setCc(4000);
				em.getTransaction().begin();
				em.persist(c1);
				em.getTransaction().commit();
			}
		}
		else {
			System.out.println("Car details not updated !!");
		}
		
	}

	public void updateEngineAndCar(int i) {
		EntityManager em = emf.createEntityManager();
		Engine e1 =em.find(Engine.class, i);
		if(e1 != null) {
			e1.setCc(35000);
			Car c1 = e1.getCar();
			if(c1!=null) {
				c1.setPrice(760000);
				em.getTransaction().begin();
				em.persist(c1);
				em.getTransaction().commit();
			}
		}
		else {
			System.out.println("Car details not updated !!");
		}
	}

	public void deleteBiOTO(int i) {
		EntityManager em = emf.createEntityManager();
		Car e1 =em.find(Car.class, i);
		if(e1 != null) {
			em.getTransaction().begin();
			em.remove(e1);
			em.getTransaction().commit();
			System.out.println("deleted");
		}
		else {
			System.out.println("\nFailed !!");
		}
		
	}

}

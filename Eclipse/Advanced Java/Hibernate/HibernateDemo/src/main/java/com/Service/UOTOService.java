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

public class UOTOService {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("nilendra");

//	========== Uni directional One To One mapping ================================================
	
	public void insertOTO(Person person) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
	}

	public Person fetchOTO(int id) {
		EntityManager em = emf.createEntityManager();
		Person person = em.find(Person.class, id);
		return person;

	}

	public void updateOTO(String name, String country, Person person) {
		EntityManager em = emf.createEntityManager();
		person.setName(name);
		person.getPassport().setCountry(country);
		em.getTransaction().begin();
		em.merge(person);
		em.getTransaction().commit();
	}

	public Person deleteOTO(int id) {
		EntityManager em = emf.createEntityManager();
		Person person = em.find(Person.class, id);
		if (person != null) {
			em.getTransaction().begin();
			em.remove(person);
			em.getTransaction().commit();
		}
		return person;
	}

	public Passport deletePassport(int id) {
		EntityManager em = emf.createEntityManager();
		Person person = em.find(Person.class, id);
		Passport passport = null;
		if (person != null) {
			passport = person.getPassport();

			if (passport != null) {
				person.setPassport(null);
				em.getTransaction().begin();
				em.merge(person);
				em.remove(passport);
				em.getTransaction().commit();
			}
		}
		return passport;
	}
}

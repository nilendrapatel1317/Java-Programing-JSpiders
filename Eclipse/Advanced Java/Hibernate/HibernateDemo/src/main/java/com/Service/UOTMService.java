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

public class UOTMService {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("nilendra");

//	========== Uni-directional One To Many Mapping==================================================================================

	public void oneToManyMapping(Library library) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(library);
		em.getTransaction().commit();

	}
	
	
	public void updateBook(int lib_id1, int book_id, int lib_id2) {
		EntityManager em = emf.createEntityManager();
		Library l1 = em.find(Library.class, lib_id1);
		Library l2 = em.find(Library.class, lib_id2);

		if (l1 != null) {
			Book updateBook = null;
			List<Book> books = l1.getBooks();

			for (Book book : books) {
				if (book.getId() == book_id) {
					updateBook = book;
					break;
				}
			}
			if (updateBook != null) {
				updateBook.setLibrary(l2);
				em.getTransaction().begin();
				em.merge(l2);
				em.getTransaction().commit();
			}
		}
	}

	public void fetchBooks(int lib_id) {
		EntityManager em = emf.createEntityManager();
		Library l1 = em.find(Library.class, lib_id);
		if (l1 != null) {
			List<Book> books = l1.getBooks();

			for (Book book : books) {
				System.out.println(book.toString());
			}

		}
	}

	public void updateBook1(int book_id) {
		EntityManager em = emf.createEntityManager();
		Book b1 = em.find(Book.class, book_id);

		if (b1 != null) {
			b1.setLibrary(null);
			em.getTransaction().begin();
			em.merge(b1);
			em.getTransaction().commit();
		}
	}
}

package com.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Entity.CRUD_Operation.Student;
import com.Entity.ManyToOne_Mapping.Product;
import com.Entity.ManyToOne_Mapping.Reviews;
import com.Entity.OneToMany_Mapping.Book;
import com.Entity.OneToMany_Mapping.Library;
import com.Entity.OneToOne_Mapping.Passport;
import com.Entity.OneToOne_Mapping.Person;

import java.util.List;
import java.util.Scanner;

public class Service {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("nilendra");

	// Create (Insert) Student
	public void insertStudent(Student student) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
	}

	// Read (Fetch by ID)
	public Student getStudentById(int id) {
		EntityManager em = emf.createEntityManager();
		Student student = em.find(Student.class, id);
		return student;
	}

	// Read (Fetch All)
	public List<Student> getAllStudents() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Student", Student.class);

//		query.setFirstResult(1); // given records from index 3 from list
//		query.setMaxResults(3); // total number of records from list
//		int firstRecordIndex = query.getFirstResult();
//		int totalRecords = query.getMaxResults();
		List<Student> students = query.getResultList();
		return students;
	}

	// Read (Fetch All Student based on condition)
	public List<Student> getStudentByCondition(String name, String email) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT s FROM Student s where s.name = ?1 AND s.email = :email", Student.class);
		query.setParameter(1, name);
		query.setParameter("email", email);
		List<Student> students = query.getResultList();
		return students;
	}

	// Update Student
	public boolean updateStudent(int id, Scanner scn) {
		EntityManager em = emf.createEntityManager();
		Student student = em.find(Student.class, id);

		if (student != null) {
			System.out.print("Enter new age : ");
			student.setAge(scn.nextInt());
			em.getTransaction().begin();
			em.merge(student);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}

	}

	// Delete Student
	public boolean deleteStudent(int id, Scanner scn) {
		EntityManager em = emf.createEntityManager();
		Student student = em.find(Student.class, id);
		if (student != null) {
			em.getTransaction().begin();
			em.remove(student);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}

	public void insertOTO(Person person) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
	}

	public void ontToManyMapping(Library library) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(library);
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

	public void updateBook(int lib_id1, int book_id , int lib_id2) {
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

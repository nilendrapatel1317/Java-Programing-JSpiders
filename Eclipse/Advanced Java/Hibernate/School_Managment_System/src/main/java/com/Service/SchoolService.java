package com.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Entity.CRUD_Operation.Principal;
import com.Entity.CRUD_Operation.School;
import com.Entity.CRUD_Operation.Teachers;

import java.util.List;
import java.util.Scanner;

public class SchoolService {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("nilendra");

//	=========================================================

	// Create (Insert)
	public void insertStudent(School s1) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(s1);
		em.getTransaction().commit();
	}

	public boolean updateRecord(int i) {
		EntityManager em = emf.createEntityManager();
		School s1 = em.find(School.class, i);
		if (s1 != null) {
			s1.setAddress("Bengaluru");

		}

		return false;
	}

	public List<School> fetchSchool() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM School");

		List<School> school = query.getResultList();
		return school;
	}

	public List<Teachers> fetchTeachers() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Teachers");

		List<Teachers> teachers = query.getResultList();
		return teachers;
	}

	public List<Principal> fetchPrincipal() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Principal");

		List<Principal> principal = query.getResultList();
		return principal;
	}

	public boolean deleteSchool(int id) {
		EntityManager em = emf.createEntityManager();
		School school = em.find(School.class, id);
		if (school != null) {
			em.getTransaction().begin();
			em.remove(school);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}

	}
	public boolean deletePrincipal(int id) {
		EntityManager em = emf.createEntityManager();
		Principal principal = em.find(Principal.class, id);
		if (principal != null) {
			em.getTransaction().begin();
			em.remove(principal);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
		
	}
	public boolean deleteTeacher(int id) {
		EntityManager em = emf.createEntityManager();
		Teachers teacher = em.find(Teachers.class, id);
		if (teacher != null) {
			em.getTransaction().begin();
			em.remove(teacher);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
		
	}

	public boolean updateSchool(int id) {
		EntityManager em = emf.createEntityManager();
		School school = em.find(School.class, id);

		if (school != null) {
			school.setAddress("Indore");
			em.getTransaction().begin();
			em.merge(school);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
		
	}
	public boolean updatePrincipal(int id) {
		EntityManager em = emf.createEntityManager();
		Principal principal = em.find(Principal.class, id);
		
		if (principal != null) {
			principal.setSalary(85000);;
			em.getTransaction().begin();
			em.merge(principal);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
		
	}
	public boolean updateTeacher(int id) {
		EntityManager em = emf.createEntityManager();
		Teachers teacher = em.find(Teachers.class, id);
		
		if (teacher != null) {
			teacher.setSalary(55000);;
			em.getTransaction().begin();
			em.merge(teacher);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
		
	}

//	// Read (Fetch by ID)
//	public Teachers getStudentById(int id) {
//		EntityManager em = emf.createEntityManager();
//		Teachers student = em.find(Teachers.class, id);
//		return student;
//	}
//
//	// Read (Fetch All)
//	public List<Teachers> getAllStudents() {
//		EntityManager em = emf.createEntityManager();
//		Query query = em.createQuery("FROM Student", Teachers.class);
//
//		query.setFirstResult(1); // given records from index 3 from list
//		query.setMaxResults(3); // total number of records from list
//		int firstRecordIndex = query.getFirstResult();
//		int totalRecords = query.getMaxResults();
//		List<Teachers> students = query.getResultList();
//		return students;
//	}
//
//	// Read (Fetch All Student based on condition)
//	public List<Teachers> getStudentByCondition(String name, String email) {
//		EntityManager em = emf.createEntityManager();
//		Query query = em.createQuery("SELECT s FROM Student s where s.name = ?1 AND s.email = :email", Teachers.class);
//		query.setParameter(1, name);
//		query.setParameter("email", email);
//		List<Teachers> students = query.getResultList();
//		return students;
//	}
//
//	// Update Student
//	public boolean updateStudent(int id, Scanner scn) {
//		EntityManager em = emf.createEntityManager();
//		Teachers student = em.find(Teachers.class, id);
//
//		if (student != null) {
//			System.out.print("Enter new age : ");
//			student.setAge(scn.nextInt());
//			em.getTransaction().begin();
//			em.merge(student);
//			em.getTransaction().commit();
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	// Delete Student
//	public boolean deleteStudent(int id, Scanner scn) {
//		EntityManager em = emf.createEntityManager();
//		Teachers student = em.find(Teachers.class, id);
//		if (student != null) {
//			em.getTransaction().begin();
//			em.remove(student);
//			em.getTransaction().commit();
//			return true;
//		} else {
//			return false;
//		}
//	}
}

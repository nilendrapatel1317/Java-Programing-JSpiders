package com.Entity.ManyToMany_Mapping.Service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Entity.ManyToMany_Mapping.Entity.Students;
import com.Entity.ManyToMany_Mapping.Entity.Subjects;

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

	public void deleteStdBiMTM(int stdId) {
		EntityManager em = emf.createEntityManager();
		Students student = em.find(Students.class, stdId);
		if(student!=null) {
			em.getTransaction().begin();
			em.remove(student);
			em.getTransaction().commit();
			System.out.println("Student Deleted !!");
		}
		else {
			System.out.println("Student not found");
		}
		
	}
	public void removeSubFromStd(int stdId , int subId) {
		EntityManager em = emf.createEntityManager();
		Students student = em.find(Students.class, stdId);
		Subjects subject = em.find(Subjects.class, subId);
		if(student!=null && subject != null) {
			em.getTransaction().begin();
			student.removeSubject(subject);
			em.getTransaction().commit();
			System.out.println("Opperation done");
		}
		else {
			System.out.println("Failed !!");
		}
		
	}

	public void deleteSubBiMTM(int subId) {
		EntityManager em = emf.createEntityManager();
		Subjects subject = em.find(Subjects.class, subId);
		if(subject!=null) {
			System.out.println(subject);
			em.getTransaction().begin();
			em.remove(subject);
			em.getTransaction().commit();
			System.out.println("Student Deleted !!");
		}
		else {
			System.out.println("Subject not found");
		}
		
	}

	public void fetchStudentMTM(int i) {
		EntityManager em = emf.createEntityManager();
		
		Students student = em.find(Students.class, i);
		if(student != null) {
			System.out.println(student);
		}
		else {
			System.out.println("Student Not Found !");
		}
		
	}

	public void fetchSubjectMTM(int i) {
		EntityManager em = emf.createEntityManager();
		
		Subjects subject = em.find(Subjects.class, i);
		Subjects subject1 = em.find(Subjects.class, i);
		Subjects subject2 = em.find(Subjects.class, i);
		if(subject != null) {
			System.out.println(subject);
			System.out.println(subject1);
			System.out.println(subject2);
		}
		else {
			System.out.println("Subject Not Found !");
		}
		
	}
	
	public List<Students> fetchAllStudentsMTM() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Students");

		List<Students> students = query.getResultList();
		return students;
	}

	public List<Subjects> fetchAllSubjectsMTM() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Subjects");
		
		List<Subjects> subjects = query.getResultList();
		return subjects;
	}

	public void updateStdMTM(int i) {
		EntityManager em = emf.createEntityManager();
		Students student = em.find(Students.class, i);
		if(student != null) {
			student.setAge(19);
			em.getTransaction().begin();
			em.merge(student);
			em.getTransaction().commit();
			System.out.println("Student Updated !");
		}
		
	}
	
	public void updateSubMTM(int i) {
		EntityManager em = emf.createEntityManager();
		Subjects subject = em.find(Subjects.class, i);
		if(subject != null) {
			subject.setPrice(500);
			em.getTransaction().begin();
			em.merge(subject);
			em.getTransaction().commit();
			System.out.println("Subject Updated !");
		}
		
	}
}

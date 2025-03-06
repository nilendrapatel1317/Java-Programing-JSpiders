import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class StudentService {
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
	
	//Read (Fetch All Student based on condition)  
	public List<Student> getStudentByCondition(String name,String email) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT s FROM Student s where s.name = ?1 AND s.email = :email", Student.class);
		query.setParameter(1, name);
		query.setParameter("email",email);
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
			em.persist(student);
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
		}else {
			return false;
		}
	}
}

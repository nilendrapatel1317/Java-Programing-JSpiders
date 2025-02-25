package in.np.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.np.model.Student;

public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        cfg.configure("/in/np/config/hibernate.cfg.xml");
        
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        
        Student student = new Student();
        student.setName("Nilendra Patel");
        student.setEmail("nilendra@gmail.com");
        student.setGender("male");
        student.setAge(21);
        
        
//        //============== CREATE Operation =======================
//        try {
//			
//        	session.save(student);
//        	transaction.commit();
//        	System.out.println("STUDENT DETAILS ADDED SUCCESSFULLY !!");
//        	
//		} catch (Exception e) {
//
//			transaction.rollback();
//			e.getStackTrace();
//			System.out.println("FAILED TO ADD STUDENT DETAILS !!");
//		}
        
        
        
        
        
      //============== Read Operation =======================
        try {
			
        	Student student2 = session.get(Student.class , 4);
        	if(student2 != null) {
        		System.out.println(student2.toString());
        	}
        	else {
        		System.out.println("STUDENT NOT FOUND !!");
        	}
        	
		} catch (Exception e) {

			e.getStackTrace();
		}
        
        
        
        
        
        
//      //============== Update Operation =======================
//     
//        try {
//			
//        	Student student2 = session.get(Student.class , 4);
//        	student2.setName("Archna Gupta");
//        	
//        	session.saveOrUpdate(student2);
//        	transaction.commit();
//        	System.out.println("STUDENT DETAILS UPDATED SUCCESSFULLY !!");
//        	
//        	
//		} catch (Exception e) {
//
//			transaction.rollback();
//			e.getStackTrace();
//			System.out.println("FAILED TO UPDATE STUDENT DETAILS !!");
//		}
        
        
        
        
        
      //============== Delete Operation =======================
        
//        try {
//			
//        	Student student = new Student();
//        	student.setId(2);
//        	
//        	session.delete(student);
//        	transaction.commit();
//        	System.out.println("STUDENT DETAILS DELETED SUCCESSFULLY !!");
//        	
//        	
//		} catch (Exception e) {
//
//			transaction.rollback();
//			e.getStackTrace();
//			System.out.println("FAILED TO DELETE STUDENT DETAILS !!");
//		}
    }
}

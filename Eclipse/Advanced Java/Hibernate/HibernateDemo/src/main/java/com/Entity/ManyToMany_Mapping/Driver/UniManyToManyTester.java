package com.Entity.ManyToMany_Mapping.Driver;

import java.util.ArrayList;
import java.util.List;

import com.Entity.ManyToMany_Mapping.Entity.Students;
import com.Entity.ManyToMany_Mapping.Entity.Subjects;
import com.Entity.ManyToMany_Mapping.Service.UMTMService;

public class UniManyToManyTester {
	public static void main(String[] args) {
		UMTMService service = new UMTMService();

//		insertManyToMany(service);

//		fetchStdMTM(service);
		
//		fetchAllStdMTM(service);
		
		fetchSubMTM(service);
		
//		fetchAllSubMTM(service);

//		updateStudentMTM(service);
		
//		updateSubjectMTM(service);

//		deleteStudent(service);

//		deleteSubject(service);

//		removeSubFromStd(service);
		
	}

	private static void fetchAllStdMTM(UMTMService service) {
		System.out.println("\n======== All Students Details: ========");
		for (Students s : service.fetchAllStudentsMTM()) {
			System.out.println(s);
		}
		System.out.println();
		
	}

	private static void fetchAllSubMTM(UMTMService service) {
		System.out.println("\n======== All Subjects Details: ========");
		for (Subjects s : service.fetchAllSubjectsMTM()) {
			System.out.println(s);
		}
		System.out.println();
		
	}

	private static void updateSubjectMTM(UMTMService service) {
		service.updateSubMTM(113);
		
	}

	private static void updateStudentMTM(UMTMService service) {
		service.updateStdMTM(1);
		
	}

	private static void fetchStdMTM(UMTMService service) {
		service.fetchStudentMTM(1);
	}

	private static void fetchSubMTM(UMTMService service) {
		service.fetchSubjectMTM(202);
	}

	private static void removeSubFromStd(UMTMService service) {
		service.removeSubFromStd(1, 115);

	}

	private static void deleteSubject(UMTMService service) {
		service.deleteSubBiMTM(113);
	}

	private static void deleteStudent(UMTMService service) {
		service.deleteStdBiMTM(4);
	}

	private static void insertManyToMany(UMTMService service) {
		// Insert Operation
		Subjects sub1 = new Subjects();
		sub1.setName("Java");
		sub1.setPrice(450);

		Subjects sub2 = new Subjects();
		sub2.setName("Hibernate");
		sub2.setPrice(300);

		Subjects sub3 = new Subjects();
		sub3.setName("Spring");
		sub3.setPrice(660);

		Students std1 = new Students();
		std1.setName("Nilendra");
		std1.setAge(22);
		std1.addSubject(sub1);
		std1.addSubject(sub2);

		Students std2 = new Students();
		std2.setName("Archna");
		std2.setAge(20);
		std1.addSubject(sub1);
		std1.addSubject(sub3);

		Students std3 = new Students();
		std3.setName("Sunita");
		std3.setAge(22);
		std1.addSubject(sub2);
		std1.addSubject(sub3);

		Students std4 = new Students();
		std4.setName("Rahul");
		std4.setAge(21);
		std1.addSubject(sub1);
		std1.addSubject(sub2);
		std1.addSubject(sub3);

		sub1.addStudents(std1);
		sub1.addStudents(std2);
		sub1.addStudents(std4);

		sub2.addStudents(std1);
		sub2.addStudents(std3);
		sub2.addStudents(std4);

		sub3.addStudents(std2);
		sub3.addStudents(std3);
		sub3.addStudents(std4);

		service.insertMTM(std1, std2, std3, std4);
		System.out.println("Data Inserted !!");
	}

}

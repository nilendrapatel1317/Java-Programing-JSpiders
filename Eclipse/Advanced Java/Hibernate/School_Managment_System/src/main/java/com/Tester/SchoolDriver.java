package com.Tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Entity.CRUD_Operation.Principal;
import com.Entity.CRUD_Operation.School;
import com.Entity.CRUD_Operation.Teachers;
import com.Service.SchoolService;

public class SchoolDriver {
	public static void main(String[] args) {
		SchoolService service = new SchoolService();
		Scanner scn = new Scanner(System.in);

		int option = 1000;
		while (option != 0) {
			System.out.println("\n========= CRUD Operations =========");
			System.out.println("0. Exit Program**");
			System.out.println("1. Insert Record");
			System.out.println("2. Fetch All School Record");
			System.out.println("3. Fetch All Principal Record");
			System.out.println("4. Fetch All Teacher Record");
			System.out.println("5. Delete School Record");
			System.out.println("6. Delete Principal Record");
			System.out.println("7. Delete Teacher Record");
			System.out.println("8. Update School Record");
			System.out.println("9. Update Principal Record");
			System.out.println("10.Update Teacher Record");
			System.out.println();
			System.out.print("Enter Your Option : ");
			option = scn.nextInt();
			switch (option) {
			case 0:
				System.out.println("\n***Thanks For Using CRUD Operation Program***");
				break;
			case 1:
				insertRecord(service);
				break;
			case 2:
				fetchSchoolRecord(service);
				break;
			case 3:
				fetchPrincipalRecord(service);
				break;
			case 4:
				fetchTeachersRecord(service);
				break;
			case 5:
				deleteSchoolRecord(service);
				break;
			case 6:
				deletePrincipalRecord(service);
				break;
			case 7:
				deleteTeacherRecord(service);
				break;
			case 8:
				updateSchoolRecord(service);
				break;
			case 9:
				updatePrincipalRecord(service);
				break;
			case 10:
				updateTeacherRecord(service);
				break;

			default:
				System.out.println("Invalid Option");
				break;
			}
		}

	}
	
	private static void updateSchoolRecord(SchoolService service ) {
		boolean deleteStatus = service.updateSchool(1);
		if(deleteStatus) System.out.println("\nOperation Successful !");
		else System.out.println("Operation Failed !");
	}

	private static void updatePrincipalRecord(SchoolService service) {
		boolean deleteStatus = service.updatePrincipal(1001);
		if(deleteStatus) System.out.println("\nOperation Successful !");
		else System.out.println("Operation Failed !");		
	}

	private static void updateTeacherRecord(SchoolService service) {
		boolean deleteStatus = service.updateTeacher(109);
		if(deleteStatus) System.out.println("\nOperation Successful !");
		else System.out.println("Operation Failed !");
	}

	private static void deleteSchoolRecord(SchoolService service) {
		boolean deleteStatus = service.deleteSchool(3);
		if(deleteStatus) System.out.println("\nOperation Successful !");
		else System.out.println("Operation Failed !");
	}
	private static void deletePrincipalRecord(SchoolService service) {
		boolean deleteStatus = service.deletePrincipal(3);
		if(deleteStatus) System.out.println("\nOperation Successful !");
		else System.out.println("Operation Failed !");
	}
	private static void deleteTeacherRecord(SchoolService service) {
		boolean deleteStatus = service.deleteTeacher(3);
		if(deleteStatus) System.out.println("\nOperation Successful !");
		else System.out.println("Operation Failed !");
	}

	private static void fetchSchoolRecord(SchoolService service) {
		System.out.println("\n======== All School Details: ========");
		for (School s : service.fetchSchool()) {
			System.out.println(s);
		}
		System.out.println();
	}
	private static void fetchTeachersRecord(SchoolService service) {
		System.out.println("\n======== All Teacher's Details: ========");
		for (Teachers t : service.fetchTeachers()) {
			System.out.println(t);
		}
		System.out.println();
	}
	private static void fetchPrincipalRecord(SchoolService service) {
		System.out.println("\n======== All Principal's Details: ========");
		
		System.out.println(service.fetchPrincipal());
	}

	

	private static void insertRecord(SchoolService service) {
		School s1 = new School();
		s1.setName("DPS");
		s1.setAddress("Bengaluru");

		Principal p1 = new Principal();
		p1.setName("Allu Arjun");
		p1.setSalary(65500);
		p1.setSchool(s1);
		
		s1.setPrincipal(p1);

		Teachers t1 = new Teachers();
		t1.setName("Anushka");
		t1.setSalary(45000);
		t1.setSchool(s1);

		Teachers t2 = new Teachers();
		t2.setName("Yuvraj");
		t2.setSalary(35000);
		t2.setSchool(s1);

		Teachers t3 = new Teachers();
		t3.setName("Nandini");
		t3.setSalary(39000);
		t3.setSchool(s1);

		List<Teachers> list = new ArrayList<Teachers>();
		list.add(t1);
		list.add(t2);
		list.add(t3);

		s1.setTeachers(list);

		service.insertStudent(s1);
		System.out.println("\nData Saved");

	}

}

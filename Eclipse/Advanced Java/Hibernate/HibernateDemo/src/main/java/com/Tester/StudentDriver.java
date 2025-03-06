package com.Tester;
import java.util.List;
import java.util.Scanner;

import com.Entity.CRUD_Operation.Student;
import com.Service.Service;

public class StudentDriver {
	public static void main(String[] args) {
		Service service = new Service();
		Scanner scn = new Scanner(System.in);

		int option = 1000;
		while (option != 0) {
			System.out.println(
					"\n========= CRUD Operations =========\n0. Exit Program**\n1. Insert Record\n2. Update Record\n3. Delete Record\n4. Fetch Record by ID\n5. Fetch All Record\n6. Fetch Record By Conditon");
			System.out.println();
			System.out.print("Enter Your Option : ");
			option = scn.nextInt();
			switch (option) {
			case 0:
				System.out.println("\n***Thanks For Using CRUD Operation Program***");
				break;
			case 1:
				insertRecord(service, scn);
				break;
			case 2:
				updateRecord(service, scn);
				break;
			case 3:
				deleteRecord(service, scn);
				break;
			case 4:
				fetchRecordById(service, scn);
				break;
			case 5:
				fetchAllRecord(service);
				break;
			case 6:
				fetchRecordByCondition(service, scn);
				break;

			default:
				System.out.println("Invalid Option");
				break;
			}
		}

	}

	private static void insertRecord(Service service, Scanner scn) {
		scn.nextLine();
		Student student = new Student();
		System.out.print("Enter Student Name : ");
		student.setName(scn.nextLine());
		System.out.print("Enter Student Email : ");
		student.setEmail(scn.nextLine());
		System.out.print("Enter Student Gender : ");
		student.setGender(scn.nextLine());
		System.out.print("Enter Student Age : ");
		student.setAge(scn.nextInt());
		service.insertStudent(student);
		System.out.println("\nStudent Added !!");
		System.out.println(student);
		System.out.println();
	}

	private static void fetchRecordById(Service service, Scanner scn) {
		scn.nextLine();
		System.out.print("Enter Student ID : ");
		int id = scn.nextInt();
		Student fetchedStudent = service.getStudentById(id);
		if (fetchedStudent != null) {
			System.out.println("\nStudent Found !!");
			System.out.println(fetchedStudent);
		} else {
			System.out.println("\nStudent Not Found with ID : " + id);
		}
		System.out.println();
	}

	private static void updateRecord(Service service, Scanner scn) {
		scn.nextLine();
		System.out.print("Enter Student ID : ");
		int id = scn.nextInt();
		boolean updateStatus = service.updateStudent(id, scn);
		if (updateStatus) {
			System.out.println("\nSuccessfully Student Updated !!");
		} else {
			System.out.println("\nStudent Not Found with ID : " + id);
		}
		System.out.println();
	}

	private static void deleteRecord(Service service, Scanner scn) {
		scn.nextLine();
		System.out.print("Enter Student ID : ");
		int id = scn.nextInt();
		boolean deleteStatus = service.deleteStudent(id, scn);
		if (deleteStatus) {

			System.out.println("\nSuccessfully Student Deleted !!");
		} else {
			System.out.println("\nSTUDENT NOT FOUND WITH ID : " + id);
		}
		System.out.println();
	}

	private static void fetchRecordByCondition(Service service, Scanner scn) {
		scn.nextLine();
		System.out.print("Enter Student Name : ");
		String name = scn.nextLine();
		System.out.print("Enter Student Email : ");
		String email = scn.nextLine();
		
		List<Student> students = service.getStudentByCondition(name , email);
		if (!students.isEmpty()) {
			for (Student s : students) {
				System.out.println("\nStudent Found !!");
				System.out.println(s);
			}
		} else {
			System.out.println("\nStudent Not Found !!");
		}
		System.out.println();
	}

	private static void fetchAllRecord(Service service) {
		System.out.println("======== All Students: ========");
		for (Student s : service.getAllStudents()) {
			System.out.println(s);
		}
		System.out.println();
	}
}

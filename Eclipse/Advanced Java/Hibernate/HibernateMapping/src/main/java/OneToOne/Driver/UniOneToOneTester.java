package com.Tester;

import com.Entity.OneToOne_Mapping.Passport;
import com.Entity.OneToOne_Mapping.Person;
import com.Service.UOTOService;

public class UniOneToOneTester {
	public static void main(String[] args) {
		UOTOService service = new UOTOService();

//		insertOneToOne(service);

		fetchOnetoOne(service);

//		updateOneToOne(service);

//		deletePersonOneToOne(service);

//		deletePassportOneToOne(service);
	}

	private static void insertOneToOne(UOTOService service) {
		// Insert Operation
		Passport passport = new Passport();
		passport.setCountry("Bengaluru");

		Person person = new Person();
		person.setName("Rocky");
		person.setPassport(passport);

		service.insertOTO(person);
	}

	private static void fetchOnetoOne(UOTOService service) {
		// Fetch Operation
		Person person2 = service.fetchOTO(14);
		System.out.println("\n"+person2);
	}

	private static void updateOneToOne(UOTOService service) {
		// Update Operation
		// Update person name and engine type
		Person person2 = service.fetchOTO(4);
		System.out.println(person2);
		service.updateOTO("Archna", "Mumbai", person2);
		System.out.println("Updated !");
		System.out.println(person2.toString());
	}

	private static void deletePassportOneToOne(UOTOService service) {
		// Delete Only Passport
		Passport passport = service.deletePassport(14);
		if (passport != null) {
			System.out.println(
					"\nPassport is Deleted with\nID : " + passport.getId() + "\nCountry: " + passport.getCountry());
		} else {
			System.out.println("\nPassport Not Found !!");
		}
	}

	private static void deletePersonOneToOne(UOTOService service) {
		// Delete Operation
		Person person = service.deleteOTO(13);
		if (person != null) {
			System.out.println("\nPerson is Deleted with\nID : " + person.getId() + "\nName: " + person.getName());
		} else {
			System.out.println("\nPerson Not Found !!");
		}
		System.out.println();
	}
}

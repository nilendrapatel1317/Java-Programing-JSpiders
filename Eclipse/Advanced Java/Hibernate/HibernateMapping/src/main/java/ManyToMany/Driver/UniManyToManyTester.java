package com.Entity.ManyToMany_Mapping.Driver;

import java.util.ArrayList;
import java.util.List;

import com.Entity.ManyToMany_Mapping.Entity.Students;
import com.Entity.ManyToMany_Mapping.Entity.Subjects;
import com.Entity.ManyToMany_Mapping.Service.UMTMService;



public class UniManyToManyTester {
	public static void main(String[] args) {
		UMTMService service = new UMTMService();

		insertManyToMany(service);
		
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
		
		List<Subjects> subList1 = new ArrayList<Subjects>();
		subList1.add(sub1);
		subList1.add(sub2);

		List<Subjects> subList2 = new ArrayList<Subjects>();
		subList2.add(sub2);
		subList2.add(sub3);

		List<Subjects> subList3 = new ArrayList<Subjects>();
		subList3.add(sub1);
		subList3.add(sub3);

		List<Subjects> subList4 = new ArrayList<Subjects>();
		subList4.add(sub1);
		subList4.add(sub2);
		subList4.add(sub3);
		
		Students std1 = new Students();
		std1.setName("Nilendra");
		std1.setAge(22);
		std1.setSubjects(subList4);
		
		Students std2 = new Students();
		std2.setName("Archna");
		std2.setAge(20);
		std2.setSubjects(subList1);
		
		Students std3 = new Students();
		std3.setName("Sunita");
		std3.setAge(22);
		std3.setSubjects(subList2);
		
		Students std4 = new Students();
		std4.setName("Rahul");
		std4.setAge(21);
		std4.setSubjects(subList3);
		
		List<Students> stdList1 = new ArrayList<Students>();
		stdList1.add(std2);
		sub1.setStudents(stdList1);
		sub2.setStudents(stdList1);
		
		List<Students> stdList2 = new ArrayList<Students>();
		stdList2.add(std3);
		sub2.setStudents(stdList2);
		sub3.setStudents(stdList2);

		List<Students> stdList3 = new ArrayList<Students>();
		stdList3.add(std4);
		sub1.setStudents(stdList3);
		sub3.setStudents(stdList3);

		List<Students> stdList4 = new ArrayList<Students>();
		stdList4.add(std1);
		sub1.setStudents(stdList4);
		sub1.setStudents(stdList4);
		sub3.setStudents(stdList4);
		
	
		service.insertMTM(std1,std2,std3,std4);
	}

}

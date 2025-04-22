package com.Tester;

import java.util.ArrayList;
import java.util.List;

import com.Entity.ManyToOne_Mapping.Reviews;
import com.Entity.ManyToOne_Mapping.Product;
import com.Service.UMTOService;
import com.Service.UMTOService;

public class UniManyToOneTester {
	public static void main(String[] args) {
		UMTOService service = new UMTOService();
//		insertManyToOne(service);
		
		
		
		
		
	}

	private static void insertManyToOne(UMTOService service) {
		Product p1 = new Product();
		p1.setName("Laptop");
		p1.setPrice(15790);
		
		
		Reviews r1 = new Reviews();
		r1.setTag("positive");
		r1.setMessage("It is very cool !");
		r1.setProduct(p1);
		
		Reviews r2 = new Reviews();
		r2.setTag("negative");
		r2.setMessage("Very good graphic !");
		r2.setProduct(p1);
		
		

		service.insertMTO(p1,r1,r2);
		System.out.println(p1.toString());
		System.out.println(r1.toString());
		System.out.println(r2.toString());
	}
}

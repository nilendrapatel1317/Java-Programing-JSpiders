package com.Tester;

import com.Entity.OneToOne_Mapping.Car;
import com.Entity.OneToOne_Mapping.Engine;
import com.Service.BOTOService;
import com.Service.BOTOService;

public class BiOneToOneTester {
	public static void main(String[] args) {
		BOTOService service = new BOTOService();
		
		insertBiOTO(service);
		
		//Update Engine by Car
//		service.updateCarAndEngine(1);
		
		//Update Car By Engine
//		service.updateEngineAndCar(2);
		
		//Delete Engine (it will throw an error )
//		service.deleteBiOTO(3);
	}

	private static void insertBiOTO(BOTOService service) {
		Engine e1 = new Engine();
		e1.setCc(2000);
		e1.setType("DIESEL");
		
		Car c1 = new Car();
		c1.setName("Fortuner");
		c1.setPrice(500000);
		c1.setEngine(e1);
		
		e1.setCar(c1);
		service.insertBiOTO(c1);
		System.out.println("saved");
	}
}

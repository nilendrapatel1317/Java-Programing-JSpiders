package com.Inheriatnce.Multilevel_Inheritance.Program1;

class Grandpa {
	public void grandpa() {
		System.out.println("GrandPa Class Method");
	}
}

class Parent extends Grandpa {
	public void parent1() {
		System.out.println("Parent Class Method");
	}
}

class Child extends Parent {
	public void child1() {
		System.out.println("Child Class Method");
	}
}



public class Test {
	public static void main(String[] args) {
		Grandpa g1 = new Grandpa();
		g1.grandpa();
		
		Parent p1 = new Parent();
		p1.grandpa();
		p1.parent1();
		
		Child c1 = new Child();
		c1.grandpa();
		c1.parent1();
		c1.child1();
	}
}

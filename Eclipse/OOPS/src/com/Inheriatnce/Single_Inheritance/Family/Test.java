package com.Inheriatnce.Single_Inheritance.Family;


class Parent {
	public void parent1() {
		System.out.println("Parent Class Method");
	}
}

class Child extends Parent {
	public void child1() {
		System.out.println("Child Class method");
	}
}

public class Test {
	public static void main(String[] args) {
		Child c1 = new Child();
		c1.child1();
		c1.parent1();
	}
}

package com.Inheriatnce.Method_Hiding.p1;

class A{
	static void m1() {
		System.out.println("M1-A");
	}
}
class B extends A{
	//Method Hiding
	static void m1() {
		System.out.println("M1-B");
	}
}
class C extends B{
	//No statements
}

public class Test {
	public static void main(String[] args) {
		B b = new B();
		b.m1();
		
		C c = new C();
		c.m1();
	}
}

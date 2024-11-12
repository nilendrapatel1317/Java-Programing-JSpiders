package com.Inheriatnce.Method_Overriding.p1;

class A{
	void m1() {
		System.out.println("M1-A");
	}
}
class B extends A{
	// overriding parent class method
	void m1() {
		System.out.println("M1-B");
	}
}

public class Test {
	public static void main(String[] args) {
		A a1 = new B();
		a1.m1();
	}

}

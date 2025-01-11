package com.Inheriatnce.Method_Overriding.p3;

class A{
	void m1() {
		System.out.println("M1-A");
	}
	void m2() {
		System.out.println("M2-A");
	}
}

class B extends A{
	void m1() {
		System.out.println("M1-B");
	}
}

class C extends A{
	void m2() {
		System.out.println("M2-C");
	}
}

public class Test {
	public static void main(String[] args) {
		A a1 = new B();
		a1.m1();
		a1.m2();
		A a2 = new C();
		a2.m1();
		a2.m2();
	}
}

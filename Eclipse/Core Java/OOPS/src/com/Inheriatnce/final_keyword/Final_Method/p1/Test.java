package com.Inheriatnce.final_keyword.Final_Method.p1;

class A{
	void m1() {
		System.out.println("M1-A");
	}
}

class B extends A{
	@Override
	final void m1() {
		System.out.println("M1-B");
	}
}

class C extends B{
//	@Override
//	void m1() {
//		System.out.println("M1-C");
//	}
}


public class Test {
	public static void main(String[] args) {
		C c = new C();
		c.m1();
	}
}

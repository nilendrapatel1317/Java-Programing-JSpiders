package com.Inheriatnce.Super_Keyword.p3;

class A{
	static int i = 10;
	static void m1() {
		System.out.println("M1-A");
	}
}

class B extends A{
	int j = 30;
	void m2() {
		System.out.println("M1-B");
	}
	
	static void m3() {
		System.out.println("Static M3");
	}
}

public class Test {
	public static void main(String[] args) {
		B b = new B();
		b.m2();
		
	}
}

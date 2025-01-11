package com.Inheriatnce.Method_Overriding.p6;

class A{
	static void m1() {
		System.out.println("Static M1 A");
	}
}

class B extends A{
	static void m1() {
		System.out.println("Non Static M1 B");
	}
}

public class Test {
	public static void main(String[] args) {
		B.m1();
	}
}

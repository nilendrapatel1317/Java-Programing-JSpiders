package com.Inheriatnce.Super_Keyword.p2;

class A{
	int i = 10;
}

class B extends A{
	int i = 20;
	public void m2() {
		System.out.println(i + " B class i");
		System.out.println(super.i + " A class i");
	}
}

public class Test {
	public static void main(String[] args) {
		B b = new B();
		b.i = 30;
		b.m2();
	}
}

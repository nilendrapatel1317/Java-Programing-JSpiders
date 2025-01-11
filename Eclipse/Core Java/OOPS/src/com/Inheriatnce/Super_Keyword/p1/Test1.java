package com.Inheriatnce.Super_Keyword.p1;

class A{
	int i = 10;
}

class B extends A{
	int i = 20;
	public void m2() {
		System.out.println(super.i);
		System.out.println(i);
	}
}

class C extends B{
	int i = 30;
	public void m3() {
		System.out.println(i);
		m2();
		System.out.println(super.i);
	}
}

public class Test1 {
	public static void main(String[] args) {
		C cObjC = new C();
		cObjC.m3();
	}
}

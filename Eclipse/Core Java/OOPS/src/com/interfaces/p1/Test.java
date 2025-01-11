package com.interfaces.p1;

interface I1{
	int i = 10;
	void m1();
}

public class Test {
	public static void main(String[] args) {
		System.out.println(I1.i);
//		I1.i = 20; //Can not modify because it is a final variable
	}
}

package com.Inheriatnce.final_keyword.Final_Variable.p2;

public class Test {
	final int a; // Blank Final Field
	
	public Test(int a) {
		this.a = a;
	}
	
	public static void main(String[] args) {
		Test t1 = new Test(10);
		System.out.println(t1.a);
		
//		t1.a = 30; //Final variable can not modify
		
		
		
	}
}

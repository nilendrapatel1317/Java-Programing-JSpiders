package com.Inheriatnce.final_keyword.Final_Variable.p1;

public class Test {
	final int a = 10;
	final static int b = 20;
	
	public static void main(String[] args) {
		Test a1 = new Test();
//		a1.a = 20; // CTE due to final keyword
		System.out.println("a="+a1.a);
		
		
//		b=30; //CTE bcz we can't update value of b if it declared as a final
		System.out.println("b="+b);
		
	}
}

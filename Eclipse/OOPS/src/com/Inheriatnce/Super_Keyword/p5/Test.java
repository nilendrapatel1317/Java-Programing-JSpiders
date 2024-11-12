//  package com.Inheriatnce.Super_Keyword.p5;

class A{
	{
		System.out.println("Non Static Block A");
	}
	static {
		System.out.println("Static Block A");
	}
	A(){
		System.out.println("A - Cons");
	}
}

class B extends A{
	{
		System.out.println("Non Static Block B");
	}
	static {
		new A();
		System.out.println("Static Block B");
	}
	B(){
		System.out.println("B - Cons");
	}
}

public class Test {
	static {
		System.out.println("Static Block Test");
	}
	
	public static void main(String[] args) {
		System.out.println("Main Start");
		new B();
		System.out.println("Main End");
	}

}

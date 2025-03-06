package com.interfaces.p2;

interface I{
	void m1();
}
abstract class A implements I{
	abstract void m2();
}

class B extends A{

	@Override
	public void m1() {
		System.out.println("M1-B");
		
	}

	@Override
	void m2() {
		System.out.println("M2-B");		
	}
	
}

public class Test {
	public static void main(String[] args) {
		I i = new B();
		i.m1(); //M1-B
//		i.m2(); //CTE
		
		A a = new B();
		a.m1(); //M1-B
		a.m2(); //M1-B
	}
}

package com.Inheriatnce.Hierarchical_Inheritance.HP1;

class A {
	int a = 10;
	public void a1() {
		System.out.println("A class method");
	}
}

class B extends A {
	int b=20;
	public void b1() {
		System.out.println("B class method");
	}
}

class C extends A {
	int c =30;
	public void c1() {
		System.out.println("C class method");
	}
}

class D extends A{
	int d =40;
	public void d1() {
		System.out.println("D class method");
	}
}


public class Test {
	public static void main(String[] args) {
		System.out.println("Hierarchical Inheritance");
		
		A objA = new A();
		System.out.println(objA.a);
		objA.a1();
		
		System.out.println("============================");
		
		B objB = new B();
		System.out.println(objB.a);
		System.out.println(objB.b);
		objB.a1();
		objB.b1();

		System.out.println("============================");
		
		C objC = new C();
		System.out.println(objC.a);
		System.out.println(objC.c);
		objC.a1();
		objC.c1();

		System.out.println("============================");
		
		D objD = new D();
		System.out.println(objD.a);
		System.out.println(objD.d);
		objD.a1();
		objD.d1();
	}
}

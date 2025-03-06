package com.Inheriatnce.Super_Keyword.p4;

class A{
	{
		System.out.println("Non Static Block A");
	}
	static{
		System.out.println("Static Block A");
	}
}
class B extends A{
	{
		System.out.println("Non Static Block B");
	}
	static{
		new A();
		System.out.println("Static Block B");
	}
}

public class Test {
	public static void main(String[] args) {
		new B();
	}
}

package com.interfaces.p3;

interface I1{
	void m1();
}
interface I2 extends I1{
	void m2();
}

class A implements I2{

	@Override
	public void m1() {
		System.out.println("M1-A");
		
	}

	@Override
	public void m2() {
		System.out.println("M2-A");		
	}
		
}

public class Test {

}

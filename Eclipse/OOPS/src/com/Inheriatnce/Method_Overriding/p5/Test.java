package com.Inheriatnce.Method_Overriding.p5;

class Bank{
	int rateOfInt() {
		return 0;
	}
}

class SBI extends Bank{
	@Override 
	int rateOfInt() {
		return 5;
	}
}

class HDFC extends Bank{
	@Override 
	int rateOfInt() {
		return 3;
	}
}

class ICICI extends Bank{
	@Override 
	int rateOfInt() {
		return 7;
	}
}



public class Test {
	public static void main(String[] args) {
		SBI sbi = new SBI();
		System.out.println(sbi.rateOfInt());
		
		HDFC hdfc = new HDFC();
		System.out.println(hdfc.rateOfInt());
		
		ICICI icici = new ICICI();
		System.out.println(icici.rateOfInt());
	}
}

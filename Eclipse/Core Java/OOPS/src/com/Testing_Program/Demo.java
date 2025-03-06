package com.Testing_Program;


public class Demo {

	public static void main(String[] args) {
		String s = "d67ds5dfd7d7f76df"; //67 + 5 + 7 + 76
		System.out.println(addNum(s));;
	}
	
	public static int addNum(String s) {
		char[] a = s.toCharArray(); // [d, 6, 7, d, s, 5, d, f, d, 7, d, 7, f, 7, 6, d, f]
		int sum = 1;
		int i = 0;
		
		String s1 = "";
		while(i<a.length) {
			s1 = "";
			while(a[i] >='0' && a[i]<='9') {
				s1+=a[i];
				i++;
			}
			
			if(s1.length() > 0) {
				sum+= Integer.parseInt(s1);
			}
		}
		return sum;
	}
}
	
	
	
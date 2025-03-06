package com.string;


public class Reverse_String1 {
	public static void main(String[] args) {
		String s1 = "Java is Easy";
		System.out.println(reverse(s1));
		System.out.println(reverse1(s1));
	}
	
	
	public static String reverse(String s) {
		String s1 = "";
		for (int i = s.length()-1 ; i >=0; i--) {
			s1+=s.charAt(i);
		}
		return s1;
	}
	
	public static String reverse1(String s) {
		char[] a = s.toCharArray();
		int startIndex = 0;
		int endIndex = a.length-1;
		
		while( startIndex < endIndex) {
			char temp = a[startIndex];
			a[startIndex] = a[endIndex];
			a[endIndex] = temp;
			
			startIndex++;
			endIndex--;
		}
		return new String(a);
	}
	
}

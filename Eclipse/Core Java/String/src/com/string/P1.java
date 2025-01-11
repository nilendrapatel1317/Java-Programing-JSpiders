package com.string;

public class P1 {
	public static void main(String[] args) {
		String s = "javaaa";
		
		System.out.println(duplicateString1(s));
		System.out.println(duplicateString2(s));
		
//		String string = "Nilendra";
//		System.out.println(string);
//		string = string.concat(" Patel");
//		System.out.println(string);

	}
	
	public static String duplicateString1(String s) {
		String s1="";
		for (char c : s.toCharArray()) {
			if(!s1.contains(c+"")) {
				s1+=c+"";
			}
		}
		return s1;
	}
	public static String duplicateString2(String s) {
		String s1="";
		for (char c1 : s.toCharArray()) {
			boolean isDuplicate = false;
			
			for (char c2 : s1.toCharArray()) {
				if(c1 == c2) {
					isDuplicate=true;
					break;
				}
			}
			if(!isDuplicate) {
				s1+=c1;
			}
		}
		return s1;
	}
}





















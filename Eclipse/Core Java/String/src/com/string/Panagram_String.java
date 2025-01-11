package com.string;

public class Panagram_String {

	public static void main(String[] args) {
		String s = "A quick brown fox jumps over the lazy dog";
		System.out.println(isPanagram1(s));
		System.out.println(isPanagram2(s));

	}
	
	public static boolean isPanagram1(String s) {
		s=s.toLowerCase();
		
		if(s.length() < 26) return false;
		
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if(s.indexOf(ch) == -1) return false;
		}
		return true;
	}
	
	public static boolean isPanagram2(String s) {
		s=s.toLowerCase();
		
		String alphStr = "abcdefghijklmnopqrstuvwxyz";
		
		for (char ch : alphStr.toCharArray()) {
			if(!s.contains(s.valueOf(ch))) return false;
		}
		return true;
	}

}

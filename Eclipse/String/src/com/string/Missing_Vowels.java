package com.string;

import java.util.Arrays;

public class Missing_Vowels {

	public static void main(String[] args) {
		String s = "Nilendra".toLowerCase();

		String vowel = "aeiou";
		
		for (char c : s.toCharArray()) {
			
			for (char ch : vowel.toCharArray()) {
				if(c == ch) vowel=vowel.replace(ch+"", "");
				
			}
		}
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			
//			for (char ch : vowel.toCharArray()) {
//				if(c == ch) {
//					vowel=vowel.replace(c+"", "");
//				}
//			}
//		}
//		System.out.println(Arrays.toString(vowel.toCharArray()));
		System.out.println(Arrays.toString(vowel.split("")));
		
	}

}

package com.string;

public class Reverse_Word {

	public static void main(String[] args) {

		String s = "My name is Nilendra Patel";
		System.out.println("Input:  " + s);
		System.out.println("Output: " + reverseString(s));

	}

	public static String reverseString(String s) {
//		s = s.toLowerCase();
		int i = 0;
		int j = 0;
		String s2 = "";

		while (j < s.length()) {

			while (j < s.length() && s.charAt(j) != ' ')
				j++;

			int k = j - 1;

			String temp = "";

			while (k >= i) {
				temp += s.charAt(k);
				k--;
			}
			s2 += temp;
			if (j < s.length()) s2 += " ";
			j++;
			i = j;
		}

		return s2;

	}
}

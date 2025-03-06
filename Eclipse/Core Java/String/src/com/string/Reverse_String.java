package com.string;

public class Reverse_String {

	public static void main(String[] args) {
		String s = "My name is Nilendra Patel";
		System.out.println("Input:  " + s);
		System.out.println("Output: " + reverseString(s));
		System.out.println("Output: " + revString(s));

	}

	public static String reverseString(String s) {
		s = s.toLowerCase();
		int i = 0;
		int j = 0;
		String s2 = "";

		while (j < s.length()) {

			while (j < s.length() && s.charAt(i) != ' ')
				j++;

			int k = j - 1;

			String temp = "";

			while (k >= i) {
				temp += s.charAt(k);
				k--;
			}
			s2 += temp;
			if (j < s.length())
				s2 += " ";
			j++;
			i = j;
		}

		return s2;

	}

	public static String revString(String s) {
		s = s.toLowerCase();
		int i = s.length() - 1;
		int j = i;
		String str = "";
		while (i >= 0) {
			while (i >= 0 && s.charAt(i) != ' ')
				i--;
			int k = i + 1;
			String temp = "";
			while (k <= j) {
				temp += s.charAt(j); //Output: "letap ardnelin si eman ym" 
				j--;
//				temp += s.charAt(k); //Output: "patel nilendra is name my" 
//				k++;
			}
			str += temp;
			if(i>=0) str += " ";
			i--;
			j = i;
		}

		return str;
	}
}

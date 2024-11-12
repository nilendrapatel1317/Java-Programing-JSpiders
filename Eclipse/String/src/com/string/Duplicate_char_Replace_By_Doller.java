package com.string;

import java.util.Stack;

public class Duplicate_char_Replace_By_Doller {

	public static void main(String[] args) {
		String s1 = "Banana";
		s1 = s1.toLowerCase();

		Stack<Character> st = new Stack<>();

		String s2 = "";

		for (char c : s1.toCharArray()) {

			if (st.isEmpty()) {
				st.push(c);
				s2 += c + "";
			} else if (st.indexOf(c) == -1) {
				st.push(c);
				s2 += c + "";
			} else {
				s2 += "$";
			}
		}

		System.out.println(s2);

	}
}

package com.string;

import java.util.ArrayList;
import java.util.List;

public class Swipe_char_2 {
	public static void main(String[] args) {
		swipeChar("My name is Nilendra");
//		output : "ay nMse im Nilendra"
	}

	private static void swipeChar(String string) {
		List<String> list = new ArrayList<String>();
		for (char ch : string.toCharArray()) {
			list.add(ch + "");
		}
		for (int i = 0; i < list.size(); i++) {
			if (string.charAt(i) == ' ') {
				list.set(i - 2, string.charAt(i + 2) + "");
				list.set(i + 2, string.charAt(i - 2) + "");
			}
		}
//		StringBuilder sb = new StringBuilder();
		String sb = new String();
		for (String ch : list) {
//			sb.append(ch);
			sb += ch + "";
		}
		System.out.println("Output: " + sb.toString());
	}
}

package com.string;

import java.util.ArrayList;
import java.util.List;

public class Swipe_char {
	public static void main(String[] args) {
		swipe("hello");  // Test for odd length string
		System.out.println();
		swipe("myselfd#$rfdbsd@"); // Test for even length string
	}

	private static void swipe(String string) {
		List<String> list = new ArrayList<>();
		
		for (char ch : string.toCharArray()) {
			list.add(ch+"");
		}
		
		int mid = string.length() / 2;
		String lastChar = list.get(list.size() - 1); // Last character
		
		if (string.length() % 2 == 0) { // For even length strings
			
			String midChar1 = list.get(mid - 1);
			String midChar2 = list.get(mid);
			String s1 = midChar1 + ""+midChar2;
			
			list.set(mid - 1, lastChar);
			list.remove(mid);
			
			list.set(list.size() - 1, s1);
		}
		else { // For odd length strings
			
			String midChar = list.get(mid);
			list.set(mid, lastChar);
			list.set(list.size() - 1, midChar);
		}
		
		StringBuilder sb = new StringBuilder();
		for (String ch : list) {
			sb.append(ch);
		}
		System.out.println("Output: " + sb.toString());
	}
}

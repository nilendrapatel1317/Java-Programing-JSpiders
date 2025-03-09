package com.string;

import java.util.ArrayList;
import java.util.List;

public class Swip_Left_Right {
	public static void main(String[] args) {
		String s = "##GeeksForGeeks@@";
		solution(s, 3);
	}

	private static void solution(String string, int i) {
		
		List<String> list = new ArrayList<String>();
		for (char ch : string.toCharArray()) {
			list.add(ch+"");
		}
		
		String remaining = "";
		for (int j = i; j < string.length()-i; j++) {
			remaining += string.charAt(j);
		}
	
		String lsp = "";
		String rsp = "";
		for (int j = 0; j < i; j++) {
			lsp +=list.get(j);
			rsp = list.get(list.size() - 1 - j) + rsp;
		}
		
		System.out.println("Left : " + remaining+lsp); // Left : eeksForGeek##G
		System.out.println("Right: " + rsp+remaining); // Right: s@@eeksForGeek
	}
	
}

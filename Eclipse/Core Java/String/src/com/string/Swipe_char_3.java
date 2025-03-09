package com.string;

import java.util.ArrayList;
import java.util.List;

public class Swipe_char_3 {
	public static void main(String[] args) {
		solution("You are student"); // Output : "YoY ara studens"
	}

	private static void solution(String string) {
		String[] strings = string.split(" ");
		String result = "";
		for (int i = 0; i < strings.length; i++) {
			result += swipe(strings[i]);
			if (i < strings.length - 1)
				result += " ";
		}
		System.out.println(result);
	}

	private static String swipe(String word) {
		String result = "";
		char[] strArr = word.toCharArray();
		
		for (int i = 0; i < strArr.length; i++) {
			if(i==strArr.length-1) {
				result += strArr[0]+"";				
			}
			else {
				result += strArr[i]+"";								
			}
			
		}
		return result;
	}
}

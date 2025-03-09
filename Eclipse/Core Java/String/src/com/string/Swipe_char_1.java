package com.string;

import java.util.ArrayList;
import java.util.List;

public class Swipe_char_1 {
	public static void main(String[] args) {
		solution("Hello World"); //Output : "elloH orldW"
	}

	private static void solution(String string) {
		String[] strings = string.split(" ");
		String result = "";
		for (int i = 0; i < strings.length; i++) {
			result += swipe(strings[i]);
			if (i < strings.length-1) result += " ";
		}
		System.out.println(result);
	}
	private static String swipe(String word) {
		List<String> list = new ArrayList<String>();

		for (char ch : word.toCharArray()) {
			list.add(ch + "");
		}

		String firstString = list.get(0);
		for (int i = 0; i < list.size(); i++) {

			if (i == list.size() - 1) {
				list.set(i, firstString);
			} else {
				list.set(i, list.get(i + 1));
			}
		}
		String resultString = new String();
		for (String string : list) {
			resultString += string;
		}
		return resultString;
	}
}

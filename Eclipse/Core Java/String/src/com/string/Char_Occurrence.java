package com.string;

import java.util.*;

public class Char_Occurrence {
	public static void main(String[] args) {
		String s = "aabbcbbaaddcb";
		String s1 = "";
		int max = 0;

		for (char pointerChar : s.toCharArray()) {

			if (s1.indexOf(pointerChar) == -1) {
				int count = 0;

				for (char currentChar : s.toCharArray()) {
					if (currentChar == pointerChar) {
						count++;
					}
					System.out.println(pointerChar + "=" + count);
					s1 += pointerChar;
				}
			}
		}
	}
}
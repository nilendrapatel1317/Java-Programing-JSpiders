package com.string;

import java.util.*;

public class Char_Occurrence {
	public static void main(String[] args) {
		String s = "Sudhakarua";
		String s1 = "";

		for (char pointerChar : s.toCharArray()) {

			if (s1.indexOf(pointerChar) == -1) {
				int count = 0;

				for (char currentChar : s.toCharArray()) {
					if (currentChar == pointerChar) count++;
				}
				if(count > 1) System.out.println(pointerChar + "=" + count);
				s1 += pointerChar;
			}
		}

	}
}

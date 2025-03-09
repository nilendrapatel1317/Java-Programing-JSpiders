package com.string;

public class String_Problem_1 {
	public static void main(String[] args) {
		String s1 = "Nilendra";
		String s2 = "Nandini";
		solution(s1, s2);
	}

	private static void solution(String s1, String s2) {
		int charCount1 = count_I_char(s1);
		int charCount2 = count_I_char(s2);

		if (charCount1 > charCount2) {
			String result = replace_i(s2);
			System.out.println(result);
		}
	}

	private static String replace_i(String string) {
		String result = "";
		for (char ch : string.toCharArray()) {
			if (ch == 'i') {
				result += 'z';
			} else if (ch == 'I') {
				result += 'Z';
			} else {
				result += ch;
			}
		}
		return result;
	}

	private static int count_I_char(String string) {

		int count = 0;
		for (char ch : string.toCharArray()) {
			if (ch == 'i' || ch == 'I')
				count++;
		}

		return count;
	}
}

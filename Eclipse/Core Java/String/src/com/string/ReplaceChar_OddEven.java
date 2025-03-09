package com.string;

public class ReplaceChar_OddEven {
	public static void main(String[] args) {
		String s = "Ram is studying in Jspiders";
		System.out.println(replaceChar(s));
	}

	private static String replaceChar(String s) {
		String[] strArr = s.split(" ");

		String resultString = "";
		
		for (int i = 0; i < strArr.length; i++) {
			resultString += rearrangeLetters(strArr[i]);
			if(i<strArr.length-1)resultString += " ";			
		}
		return resultString;
	}

	private static String rearrangeLetters(String s) {
		char firstChar = s.charAt(0);
		int midIndex = 0;

		String wordString = "";
		char[] strArr = s.toCharArray();

		if (s.length() % 2 != 0) {
			midIndex = (s.length() + 1) / 2;
			for (int i = 0; i < strArr.length; i++) {
				if (i + 1 == midIndex) {
					wordString += firstChar;
				} else {
					wordString += strArr[i];

				}
			}
		} else {
			midIndex = ((s.length() / 2) + 1);
			for (int i = 0; i < strArr.length; i++) {
				if (i + 1 == midIndex) {
					wordString += firstChar;
				} else {
					wordString += strArr[i];

				}
			}

		}

		return wordString;
	}

}


class ReplaceChar_OddEven_2 {
	public static void main(String[] args) {
		String s = "Ram is studying in Jspiders";
//					RRm ii studsing ii JspiJers
		System.out.println(replaceChar(s));
	}

	private static String replaceChar(String s) {
		String[] strArr = s.split(" ");

		String resultString = "";

		for (int i = 0; i < strArr.length; i++) {
			resultString += reArrangeLetters(strArr[i]);
			if (i < strArr.length - 1)
				resultString += " ";
		}
		return resultString;
	}

	private static String reArrangeLetters(String s) {
		String wordString = "";
		char[] strArr = s.toCharArray();

		for (int i = 0; i < strArr.length; i++) {
			wordString += i + 1 == (s.length() % 2 != 0 ? (s.length() + 1) / 2 : (s.length() / 2) + 1) ? s.charAt(0)
					: strArr[i];
		}
		return wordString;
	}

}


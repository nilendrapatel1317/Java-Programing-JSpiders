package DS_Question;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter String : ");
		String string = scn.nextLine();
		System.out.println("Original String : " + string);
		System.out.println("Reversed String : " + reverseString(string));
	}

	public static String reverseString(String string) {
		char[] charArr = string.toCharArray();
		String result = "";
		for (char c : charArr) {
			result = c + "" + result;
		}
		return result;
	}
}

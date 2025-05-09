package com.string;

import java.util.Stack;

public class Balanced_String3 {

	public static void main(String[] args) {
		System.out.println(isBalanced1("[5+{4*(2+3)}]"));
		System.out.println(isBalanced2("[5+{4*(2+3)}]"));

	}

	public static boolean isBalanced1(String s) {
		Stack<Character> stack = new Stack<Character>();

		char[] a = s.toCharArray();
		for (int i = 0; i < a.length; i++) {

			// for open brackets
			if (a[i] == '[' || a[i] == '{' || a[i] == '(') {
				stack.push(a[i]);
			}

			// for close brackets
			else if (a[i] == ']' || a[i] == '}' || a[i] == ')') {
				if (stack.isEmpty())
					return false;
				char removedChar = stack.pop();
				if (!checkBracketPair(removedChar, a[i]))
					return false;
			}

		}
		return stack.isEmpty();
	}

	public static boolean isBalanced2(String s) {
		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {
			// for open brackets
			if (ch == '[' || ch == '{' || ch == '(')
				stack.push(ch);

			// for close brackets
			else if (ch == ']' || ch == '}' || ch == ')') {
				if (stack.isEmpty() || !checkBracketPair(stack.pop(), ch))
					return false;
			}
		}
		return stack.isEmpty();
	}

	public static boolean checkBracketPair(char openBracket, char closeBracket) {
		if (openBracket == '[' && closeBracket == ']' || 
			openBracket == '{' && closeBracket == '}' || 
			openBracket == '(' && closeBracket == ')')
			return true;

		return false;
	}

}

package DS_Question;

import java.util.Stack;

public class StringRevStack {
	public static void main(String[] args) {
		String string = "Nilendra";
		reverse(string);
	}

	private static void reverse(String string) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder revString = new StringBuilder();
//		String revString = "";

		for (char ch : string.toCharArray()) {
			stack.push(ch);
		}

		while (!stack.isEmpty()) {
			revString.append(stack.pop());
//			revString += stack.pop();

		}
		System.out.println("Original String : " + string);
		System.out.println("Reversed String : " + revString);
	}
}

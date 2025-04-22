package DS_Question;

import java.util.Arrays;
import java.util.Stack;

public class RemoveArrayDuplicate {
	public static void main(String[] args) {
		int[] a = { 10, 20, 10, 30, 10, 20, 40, 10 };
		System.out.println(Arrays.toString(remove(a)));;
		
	}

	private static Integer[] remove(int[] a) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int n : a) {
			if (stack.indexOf(n) == -1)
				stack.push(n);
		}

		return stack.toArray(new Integer[0]);
	}
}

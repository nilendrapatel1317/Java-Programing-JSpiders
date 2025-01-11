package two_Dimenstional;

import java.util.Stack;

public class RemoveDuplicate {
	public static void main(String[] args) {
		int[] a = {10,20,30,10,40,20,10,30,50,10};
		System.out.println("Before removing duplicae values : ");
		for (int n : a) {
			System.out.print(n+" ");
		}
		System.out.println();
		System.out.println();
		System.out.println("After removing duplicae values : ");
		int[] result = removeDuplicate(a);
		
		for (int n : result) {
			System.out.print(n+" ");
		}
		System.out.println();
	}
	
	public static int[] removeDuplicate(int[] a) {
		
		Stack<Integer> stack = new Stack<>();
		for (int n : a) {
			if(stack.indexOf(n)==-1) {
				stack.push(n);
			}
		}
		int[] b = new int[stack.size()];
		for (int i = 0; i < b.length; i++) {
			b[i]=stack.get(i);
		}
 		
		
		return b;
	}
}

package comparator;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String[] a1 = {"aaaaa","aaaaaaaa","aaaa" , "aaaaaaa", "aaa","aaaaaa"};
		Arrays.sort(a1,new LengthCompare<>());
		
		for (String s : a1) {
			System.out.println(s);
		}
		
		
	}
}

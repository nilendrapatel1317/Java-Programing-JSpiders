package com.string;

public class CamelCase {

	public static void main(String[] args) {
		String s = "my name is nilendra patel.";
		System.out.println("Input:  " + s);
		System.out.println("Output: " + camelCase(s));

	}

	public static String camelCase(String s) {
		char[] ch = s.toCharArray();
		
		for (int i = 0; i < s.length(); i++) {
			
			if(ch[i] >= 'a' && ch[i] <= 'z') {
			
				if(i==0 || ch[i-1] == ' ') {
					ch[i] = (char)(ch[i] - 32);
				}
			}
		}
		
		
		return new String(ch);
	}

}

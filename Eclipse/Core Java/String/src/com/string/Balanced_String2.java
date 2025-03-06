package com.string;


public class Balanced_String2 {

	public static void main(String[] args) {
		System.out.println(isBalanced("[5+{4*(2+3)}]"));

	}
	
	public static boolean isBalanced(String str) {
		String s ="";
		for (int i = 0; i < s.length(); i++) {
			char c= str.charAt(i);
			
			if(c=='[' || c==']' || c=='{' || c=='}' || c=='(' || c==')') {
				s += c;
				System.out.println(i +" : "+s);
			}
			while(s.contains("[]") || s.contains("{}") || s.contains("()")) {
				System.out.println("Now Remove Close bracket");
				s=s.replace("[]", "");
				System.out.println("find [] : "+s);
				s=s.replace("{}", "");
				System.out.println("find {} : "+s);
				s=s.replace("()", "");
				System.out.println("find () : "+s);
				System.out.println();
				
				System.out.println("Final : "+s);
				System.out.println("===============");
				System.out.println();
			}
		}
		return s.length()==0;
	}

}

package com.string;


public class Print_Occurrence_Count {

	public static void main(String[] args) {
		String s1 = "Hello World";
		s1 = s1.toLowerCase();		
//		for (int i = 0; i < s1.length(); i++) {
//			char c = s1.charAt(i);
//			
//			String s2= s1.replace(c+"", "");
//			
//			int len = s1.length()-s2.length();
//			
//			if(len > 1 && c >= 'a' && c<='z') {
//				for (int j = 1; j <= len; j++) {
//					Character ch = (char)('0'+j);
//					s1=s1.replaceFirst(c+"", ch+"");
//					
//				}
//			}
//		}
		for (char c : s1.toCharArray()) {
			
			String s2= s1.replace(c+"", "");
			
			int len = s1.length()-s2.length();
			
			if(len > 1 && c >= 'a' && c<='z') {
				for (int i = 1; i <= len; i++) {
					Character ch = (char)('0'+i);
					s1=s1.replaceFirst(c+"", ch+"");
					
				}
			}
		}
		System.out.println(s1);
		
		
		
		
		

	}

}

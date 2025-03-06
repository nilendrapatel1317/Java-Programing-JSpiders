package com.string;

public class String_Occurrence {

	public static void main(String[] args) {
		String s1 = "Jaaajjjvvaa";
		s1=s1.toLowerCase();
		int firstMax = 0;
		char firstMaxChar = 0 ;
		int secondMax = 0;
		char secondMaxChar = 0 ;
		while(s1.length() > 0) {
			
			char ch = s1.charAt(0);
			
			String s2 = s1.replace(ch+"","");
			
			int count = s1.length() - s2.length();
			if(count > firstMax) {
				secondMax=firstMax;
				secondMaxChar=firstMaxChar;
				
				firstMax=count;
				firstMaxChar=ch;
			}
			else if (count > secondMax && count < firstMax) {
                secondMax = count;
                secondMaxChar = ch;
            }
			
			s1=s2;
		}
		System.out.println(secondMaxChar+ "=" +secondMax);
		
	}

}

package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Digit_Sum_Regex {

	public static void main(String[] args) {
		String s = "a24bd3b12m3b43";
		System.out.println(digitSum(s));

	}
	
	public static int digitSum(String s) {
		int sum = 0;
		String  exp = "[0-9]+";
		Pattern p = Pattern.compile(exp);
		Matcher m = p.matcher(s);
		
		while(m.find()) {
			sum += Integer.parseInt(m.group());
		}
		
		
		return sum;
	}

}

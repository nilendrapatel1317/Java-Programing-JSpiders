package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {
	public static void main(String[] args) {
//		String exp = "(?=.* 0[1-9])(?=.* [12][0-9])(?=.*3[01]).{2}";
		
		String exp = "(?=.*[01]).{2}";
		String s = "s12d4ds11sd52d41s32d01da7a31";
		Pattern p = Pattern.compile(exp);
		Matcher m = p.matcher(s);
		
		while(m.find()) {
			System.out.println(m.group());
		}
	}
}

package com.regex;
import java.util.regex.*;

public class RegexExample1 {

	public static void main(String[] args) {
		String exp = "g++";
		String s = "ggsggasgsdsgag";
		Pattern p = Pattern.compile(exp);
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group());
		}
	}
}

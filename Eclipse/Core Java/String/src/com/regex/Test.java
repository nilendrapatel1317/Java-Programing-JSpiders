package com.regex;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Test {
//	public static void main(String[] args) {
//		match("\\d+[\\+-x\\*]\\d+", "5+4+3*1-4-32");
//		System.out.println();
//		match("([A-Z]\\w+)", "sdfdsfdsf");
//		System.out.println();
//		match("th(e|is|at)", "String is the famous because this is very useful for that develper");
//		System.out.println();
//		match("([a-z])\\1", "abbaccssaabdd");
//		System.out.println();
//		
//	}
//	
//	public static void match(String exp , String s ) {
//		Pattern p= Pattern.compile(exp);
//		Matcher m=p.matcher(s);
//		
//		while(m.find()) {
//			System.out.println(m.group());
//		}
//	}
//}
////Java program to demonstrate difference 
////between Possessive and Greedy Quantifiers

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Test
{
	public static void main(String[] args)
	{
		// Create a pattern with Greedy quantifier
		Pattern pg = Pattern.compile("g+g");

		// Create same pattern with possessive quantifier
		Pattern pp = Pattern.compile("g++g");		 

		System.out.println("Using Greedy Quantifier");
		Matcher mg = pg.matcher("ggg"); 
		while (mg.find())
			System.out.println("Pattern found from " + mg.start() +
							" to " + (mg.end()-1)); 

		System.out.println("\nUsing Possessive Quantifier");
		Matcher mp = pp.matcher("ggg"); 
		while (mp.find())
			System.out.println("Pattern found from " + mp.start() +
							" to " + (mp.end()-1)); 

	}
}

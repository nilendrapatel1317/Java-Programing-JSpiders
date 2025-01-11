package com.regex;

import java.util.Arrays;

public class Replace_Split_method {

	public static void main(String[] args) {
		String s = "a1b2c3d4";
		System.out.println(s.replace("[0-9]", ""));    //replace(String s) does not support regex.
		System.out.println(s.replaceAll("[0-9]", "")); //replaceAll(String regex) does support regex.
		
		System.out.println(Arrays.toString(s.split("[0-9]"))); //split(Sting regex) does support regex.
	}

}

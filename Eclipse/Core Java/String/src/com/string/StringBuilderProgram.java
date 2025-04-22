package com.string;

public class StringBuilderProgram {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		System.out.println(sb);
		sb.insert(0, 'g');
		sb.insert(1, 'f');
		sb.insert(2, 'm');
		
		System.out.println(sb);
		System.out.println(sb.reverse());
		System.out.println(sb.toString());
	}
}

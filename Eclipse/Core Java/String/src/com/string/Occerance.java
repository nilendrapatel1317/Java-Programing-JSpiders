package com.string;

import java.util.HashMap;
import java.util.Map;

public class Occerance {
	public static void main(String[] args) {
		occer("My Name is Ram");
	}

	private static void occer(String s) {
		
		char[] chArr = s.toUpperCase().toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0 ; i < chArr.length ; i++) {
			if(chArr[i] != ' ') {
				map.put(chArr[i], map.getOrDefault(chArr[i], 0)+1);
			}
		}
		System.out.println(map);
	}
}

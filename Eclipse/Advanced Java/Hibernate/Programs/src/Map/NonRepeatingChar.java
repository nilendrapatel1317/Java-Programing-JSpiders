// Find the first non-repeating character in a string.
package Map;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingChar {
	public static void main(String[] args) {
		String str = "abcdabfadbz";
		normalWay(str);
		
		byUsingMap(str);
	}

	private static void byUsingMap(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() < 2) {
				System.out.println(entry.getKey() + " -> " + entry.getValue());
				break;
			}
		}
	}

	private static void normalWay(String str) {
		int i = 0;
		char nonRepChar = 0;
		
		while(str.length() != 0) {
			char ch = str.charAt(0);
			String s1 = str.replace(ch+"", "");
			int length = str.length()-s1.length();
			if(2 > length) {
				i=length;
				nonRepChar = ch;
				break;
			}
			str=s1;
		}
		
		System.out.println(nonRepChar + " -> " + i);
	}
}


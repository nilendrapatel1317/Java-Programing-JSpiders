// Write a program to count the frequency of characters in a string using Map.
package Map;

import java.util.HashMap;
import java.util.Map;

public class OccurenceOfChara {
	public static void main(String[] args) {
		String string = "ababccdbcabcddca";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char ch : string.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry);
		}
	}
}

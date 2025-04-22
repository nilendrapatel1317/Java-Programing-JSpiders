// Count the frequency of words in a sentence.
// Find the longest substring without repeating characters using Map

package Map;

import java.util.HashMap;
import java.util.Map;

public class OccWords {
	public static void main(String[] args) {
		String string = "Madam is madam and she is very very cute madam ".toLowerCase();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : string.split(" ")) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		System.out.println("Q1. Count the frequency of words in a sentence.");
		System.out.println();
		System.out.println(map);
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Q2. Find the longest substring without repeating characters using Map");
		System.out.println();
		int max = 0;
		String s1 = "";
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() > max) {
				max = entry.getValue();
				s1 = entry.getKey();
			}
		}
		System.out.println("Longest unique substring length: " + s1.length());
	}
}

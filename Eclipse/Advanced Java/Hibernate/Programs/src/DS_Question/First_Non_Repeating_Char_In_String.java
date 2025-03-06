package DS_Question;

import java.util.LinkedHashMap;
import java.util.Map;

public class First_Non_Repeating_Char_In_String {
	public static void main(String[] args) {
		String s = "aabbccdeef";
		Map<Character, Integer> freq = new LinkedHashMap<>();

		for (char ch : s.toCharArray()) {
			freq.put(ch, freq.getOrDefault(ch, 0) + 1);
			System.out.println(freq);
		}

		for (char ch : freq.keySet()) {
			if (freq.get(ch) == 1) {
				System.out.println("\nFirst non-repeating char: " + ch); // Output: d
				break;
			}
		}
	}
}

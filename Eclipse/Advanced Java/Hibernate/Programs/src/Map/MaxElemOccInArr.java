// Find the most repeated element in an array.

package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MaxElemOccInArr {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 4, 2, 3, 1, 4, 5, 6, 2, 1, 4, 2, 4, 1, 3, 1, 4, 2, 3, 2, 4, 2, };
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int maxValue = 0;
		int key = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maxValue) {
				maxValue = entry.getValue();
				key = entry.getKey();
			}
		}
		
		System.out.println("Most repeated element : " + key + " -> " + maxValue);
	}
}

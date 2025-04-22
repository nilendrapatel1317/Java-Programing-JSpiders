// Find duplicate elements in an array using Map.
package Map;

import java.util.HashMap;
import java.util.Map;

public class DuplicateElemInArray {
	public static void main(String[] args) {
		int[] arr = {1,2,3,1,4,2,5,6,3,2,1,4,2,6};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		
		System.out.println("Duplicates Elements are : ");
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > 1) System.out.println(entry.getKey());
		}
	}
}

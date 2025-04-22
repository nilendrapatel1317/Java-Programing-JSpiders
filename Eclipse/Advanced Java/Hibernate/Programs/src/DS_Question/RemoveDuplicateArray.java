package DS_Question;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 1, 7, 2, 4, 2 };
		int n = arr.length;
		removeDups(arr, n);
	}

	private static void removeDups(int[] arr, int n) {
		Map<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < n; ++i) {
			if (map.get(arr[i]) == null)
				System.out.print(arr[i] + " ");
			map.put(arr[i], true);
		}
	}
}

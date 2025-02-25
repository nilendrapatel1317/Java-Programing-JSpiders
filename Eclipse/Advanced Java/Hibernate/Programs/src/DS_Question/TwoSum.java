package DS_Question;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1, 2};
        int targetSum = 3;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int remaining = targetSum - arr[i];

            if (map.containsKey(remaining)) {
                System.out.println("Indices: " + map.get(remaining) + ", " + i);
            }

            map.put(arr[i], i);
        }
    }
}

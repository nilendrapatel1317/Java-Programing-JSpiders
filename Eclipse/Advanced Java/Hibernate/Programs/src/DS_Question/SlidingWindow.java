package DS_Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindow {
	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] output = maxSlidingWindow(nums, k);

		System.out.println(Arrays.toString(output)); // Output: [3, 3, 5, 5, 6, 7]
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0]; // Edge case: empty array
		}

		int n = nums.length;
		int[] result = new int[n - k + 1]; // Output array
		Deque<Integer> deque = new LinkedList<>(); // Stores indices

		for (int i = 0; i < n; i++) {
			// Remove elements that are out of this window
			if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
				deque.pollFirst();
			}

			// Remove elements from the back that are smaller than the current element
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}

			// Add current index to the deque
			deque.offerLast(i);

			// Store the max value in result once we have a valid window
			if (i >= k - 1) {
				result[i - k + 1] = nums[deque.peekFirst()];
			}
		}

		return result;
	}

}

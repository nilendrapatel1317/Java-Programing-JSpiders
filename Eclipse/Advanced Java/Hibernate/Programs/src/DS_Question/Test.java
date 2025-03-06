package DS_Question;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		int[] arr = { 51, 71, 17, 42 ,47,34,52};
		System.out.println(solve(7, arr));
	}

	static long solve(int n, int[] nums) {
		// Write your code here
		Map<Integer, Integer> digitSumCount = new HashMap<>();
		long result = 0;
		
		for (int num : nums) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;  
                num /= 10;        
            }
            int sumOfDigits = sum;

            // If this sumOfDigits was seen before, add its frequency to the count
            result += digitSumCount.getOrDefault(sumOfDigits, 0);
            
            // Update the frequency of sumOfDigits
            digitSumCount.put(sumOfDigits, digitSumCount.getOrDefault(sumOfDigits, 0) + 1);
        }
		return result;
	}
}

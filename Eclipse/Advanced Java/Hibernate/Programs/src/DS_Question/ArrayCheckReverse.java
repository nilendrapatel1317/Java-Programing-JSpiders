package DS_Question;

import java.util.Arrays;

public class ArrayCheckReverse {
	public static void checkAndReverse(int[] arr) {
        int n = arr.length;
        
        // Calculate sum of first and second halves
        int firstHalfSum = 0, secondHalfSum = 0;
        for (int i = 0; i < n / 2; i++) {
            firstHalfSum += arr[i];
        }
        for (int i = n / 2; i < n; i++) {
            secondHalfSum += arr[i];
        }

        // If first half sum is less, reverse the array
        if (firstHalfSum < secondHalfSum) {
            reverseArray(arr);
        }

        // Print the resulting array
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 10, 20, 30};
        checkAndReverse(arr1); // Output: [30, 20, 10, 3, 2, 1]
        int[] arr2 = {5,5,5,5,5,5};
        checkAndReverse(arr2); // Output: [30, 20, 10, 3, 2, 1]
        int[] arr3 = {9,7,3};
        checkAndReverse(arr3); // Output: [30, 20, 10, 3, 2, 1]
    }
}

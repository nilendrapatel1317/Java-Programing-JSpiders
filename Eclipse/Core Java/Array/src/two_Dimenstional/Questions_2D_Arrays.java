package two_Dimenstional;

import java.util.Arrays;

public class Questions_2D_Arrays {
	public static void main(String[] args) {
		int[][] a = { { 82, 5, 29 }, { 349, 42, 32 }, { 45, 134, 81 } };
//		display(a);
		p7(a);
	}

	public static void display(int[][] a) {
		for (int[] temp : a) {
			for (int n : temp) {
				System.out.print(n + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

//	### 1. Element-Wise Calculations in 2D Arrays

//	1. Sum of each element's digits in the 2D array
//	   - Input: `[[8, 29], [399, 9], [45, 34]]`
//	   - Output: `[[8, 11], [21, 9], [9, 7]]`
	public static void p1(int[][] a) {
		int len = a.length;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 1; j++) {
				int elem = a[i][j];
				int sum = 0;
				while (elem != 0) {
					int digit = elem % 10;
					sum += digit;
					elem /= 10;
				}
				a[i][j] = sum;
			}
		}
		display(a);

	}

//	
//	2. Product of each element's digits in the 2D array
//	   - Input: `[[12, 34], [56, 78]]`
//	   - Output: `[[2, 12], [30, 56]]`
	public static void p2(int[][] a) {
		int len = a.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 1; j++) {
				int elem = a[i][j];
				int prod = prod(elem);
				a[i][j] = prod;
			}
		}
		display(a);
	}

	public static int prod(int elem) {
		int prod = 1;
		while (elem != 0) {
			int digit = elem % 10;
			prod *= digit;
			elem /= 10;
		}

		return prod;
	}
//	
//	3. Sum of digits in each element until a single digit
//	   - Input: `[[99, 34], [57, 123]]`
//	   - Output: `[[9, 7], [3, 6]]`

	public static void p3(int[][] a) {
		int len = a.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 1; j++) {
				int elem = a[i][j];
				int sum = add(elem);
				if (sum > 9)
					sum = add(sum);
				a[i][j] = sum;
			}
		}
		display(a);
	}

	public static int add(int elem) {
		int sum = 0;
		while (elem != 0) {
			int digit = elem % 10;
			sum += digit;
			elem /= 10;
		}

		return sum;
	}

//	
//	4. Replace each element with the largest digit in that element
//	   - Input: `[[123, 45], [67, 89]]`
//	   - Output: `[[3, 5], [7, 9]]`
	public static void p4(int[][] a) {
		int len = a.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				int elem = a[i][j];
				int max = 0;
				while (elem != 0) {
					int digit = elem % 10;
					if (digit > max)
						max = digit;
					elem /= 10;
				}
				a[i][j] = max;
			}
		}
		display(a);
	}

//	
//	5. Replace each element with the smallest digit in that element
//	   - Input: `[[19, 32], [45, 78]]`
//	   - Output: `[[1, 2], [4, 7]]`
	public static void p5(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				int elem = a[i][j];

				int min = 0;
				int max = 0;
				while (elem != 0) {
					int digit = elem % 10;
					if (digit > max) {
						min = max;
						max = digit;
					} else if (digit < min && digit > min) {
						min = digit;
					}
					elem /= 10;
				}
				a[i][j] = min;
			}
		}
		display(a);
	}
//	
//	6. Sum of row-wise sums of elements' digits
//	   - Input: `[[25, 36], [47, 58]]`
//	   - Output: `[11, 15]`
	private static void p6(int[][] a) {
		int len= a.length;
		
	}
//	
//	====================================================================================
//	
//	### 2. Row and Column-Based Operations

//	7. Row-wise sum of elements
//	   - Input: `[[1, 2, 3], [4, 5, 6]]`
//	   - Output: `[6, 15]`
	public static void p7(int[][] a) {
		int len = a.length;
		int[] b = new int[len];
		for (int i = 0; i < len; i++) {
			int sum = 0;
			for (int j = 0; j < len; j++) {
				int elem = a[i][j];
				sum+=elem;
				b[i] = sum;
			}
		}
		System.out.println(Arrays.toString(b));
		
	}
	
//	
//	8. Column-wise sum of elements
//	   - Input: `[[1, 2], [3, 4], [5, 6]]`
//	   - Output: `[9, 12]`
//	
//	9. Sum of digits in each row
//	   - Input: `[[11, 22], [33, 44]]`
//	   - Output: `[4, 7]`
//	
//	10. Count of even and odd elements in each row
//	    - Input: `[[12, 15], [17, 22]]`
//	    - Output: `[[1 even, 1 odd], [1 even, 1 odd]]`
//	
//	11. Product of elements in each column
//	    - Input: `[[2, 3], [4, 5]]`
//	    - Output: `[8, 15]`
//	
//	12. Sum of elements in each diagonal (if square matrix)
//	    - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	    - Output: `[15]`
//	
//	================================================================================
//	
//	### 3. Transforming Elements by Conditions

//	13. Replace even elements with their sum of digits
//	    - Input: `[[44, 23], [56, 19]]`
//	    - Output: `[[8, 23], [11, 19]]`
//	
//	14. Replace odd elements with their square
//	    - Input: `[[11, 22], [13, 14]]`
//	    - Output: `[[121, 22], [169, 14]]`
//	
//	15. Replace elements greater than a threshold with zero
//	    - Input: `[[10, 25], [30, 5]]`, threshold = 20
//	    - Output: `[[10, 0], [0, 5]]`
//	
//	16. Replace prime elements with -1
//	    - Input: `[[7, 12], [17, 21]]`
//	    - Output: `[[-1, 12], [-1, 21]]`
//	
//	17. Replace each element with sum of row and column indices
//	    - Input: `[[0, 0, 0], [0, 0, 0], [0, 0, 0]]`
//	    - Output: `[[0, 1, 2], [1, 2, 3], [2, 3, 4]]`
//	
//	18. Multiply each element by its row index
//	    - Input: `[[1, 2], [3, 4], [5, 6]]`
//	    - Output: `[[0, 0], [3, 4], [10, 12]]`
//	
//	=======================================================================================
//	
//	### 4. Submatrices and Specific Positions

//	19. Calculate sum of all elements in a 2x2 submatrix
//	    - Input: `[[5, 6, 7], [8, 9, 10], [11, 12, 13]]`, submatrix: top-left
//	    - Output: `28`
//	
//	20. Find the largest element in each 2x2 submatrix
//	    - Input: `[[3, 7, 8], [5, 6, 10], [12, 15, 9]]`
//	    - Output: `[[7, 10], [15, 15]]`
//	
//	21. Replace corner elements with their product
//	    - Input: `[[3, 8, 9], [4, 5, 6], [7, 2, 1]]`
//	    - Output: `[[3*9, 8, 9*3], [4, 5, 6], [7*1, 2, 1*3]]`
//	
//	22. Find sum of boundary elements only
//	    - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	    - Output: `30`
//	
//	23. Find sum of all elements excluding the boundary
//	    - Input: `[[10, 20, 30], [40, 50, 60], [70, 80, 90]]`
//	    - Output: `50`
//	
//	==============================================================================================
//	
//	### 5. Custom Operations and Transformations

//	24. Count elements in each row with sum of digits greater than 5
//	    - Input: `[[12, 15, 22], [9, 25, 35]]`
//	    - Output: `[2, 2]`
//	
//	25. Count prime elements in each column
//	    - Input: `[[2, 4, 6], [3, 9, 8], [5, 7, 12]]`
//	    - Output: `[2, 1, 0]`
//	
//	26. Replace each element by the sum of digits of the largest element in its row
//	    - Input: `[[3, 12, 10], [7, 15, 20]]`
//	    - Output: `[[3, 3, 3], [5, 5, 5]]`
//	
//	27. Transpose a 2D array
//	    - Input: `[[1, 2, 3], [4, 5, 6]]`
//	    - Output: `[[1, 4], [2, 5], [3, 6]]`
//	
//	28. Calculate product of diagonal elements if square matrix
//	    - Input: `[[2, 1, 3], [4, 5, 6], [7, 8, 9]]`
//	    - Output: `90`
//	
//	===================================================================================
//	
//	### 6. Advanced 2D Array Manipulations

//	29. Reverse each row in the 2D array
//	    - Input: `[[1, 2, 3], [4, 5, 6]]`
//	    - Output: `[[3, 2, 1], [6, 5, 4]]`
//	
//	30. Reverse each column in the 2D array
//	    - Input: `[[1, 2], [3, 4], [5, 6]]`
//	    - Output: `[[5, 6], [3, 4], [1, 2]]`
//	
//	31. Rotate the 2D array 90 degrees clockwise
//	    - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	    - Output: `[[7, 4, 1], [8, 5, 2], [9, 6, 3]]`
//	
//	32. Count elements divisible by a specific number in each row
//	    - Input: `[[10, 15, 25], [30, 35, 45]]`, divisor = 5
//	    - Output: `[3, 3]`
//	
//	33. Sum elements in each diagonal separately if square matrix
//	    - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	    - Output: `[15, 15]` (primary and secondary diagonals)
//	
//	34. Identify rows where sum of elements is even
//	    - Input: `[[1, 2, 3], [4, 6, 8], [3, 5, 7]]`
//	    - Output: `[2nd row]`
//	
//	35. Find the row with the maximum sum of elements
//	    - Input: `[[3, 7, 1], [2, 9, 8], [4, 6, 5]]`
//	    - Output: `2nd row`
//	
//	36. Sort elements in each row of 2D array
//	    - Input: `[[5, 1, 3], [8, 6, 7]]`
//	    - Output: `[[1, 3, 5], [6, 7, 8]]`

//  ================================================================================
//	7. Aggregate Operations on Specific Elements
//	
//	37. Find the sum of all elements above the main diagonal in a square matrix
//	   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `11`
//	
//	38. Find the sum of all elements below the main diagonal in a square matrix
//	   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `19`
//	
//	39. Count the number of non-zero elements in the 2D array
//	   - Input: `[[0, 1, 2], [3, 0, 4], [5, 6, 0]]`
//	   - Output: `6`
//	
//	40. Replace each element with the maximum element in its column
//	   - Input: `[[2, 5, 1], [3, 7, 4], [6, 1, 8]]`
//	   - Output: `[[6, 7, 8], [6, 7, 8], [6, 7, 8]]`
//	
//	======================================================================================================
//	
//	8. Row and Column Calculations with Conditions
//	
//	41. Replace each element with the sum of elements in its row if the row sum is even
//	   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `[[1, 2, 3], [15, 15, 15], [7, 8, 9]]`
//	
//	42. Replace each element with the sum of elements in its column if the column sum is odd
//	   - Input: `[[3, 2, 3], [1, 4, 1], [1, 3, 2]]`
//	   - Output: `[[3, 2, 6], [5, 4, 6], [5, 3, 6]]`
//	
//	43. Find the number of rows with an odd sum of elements
//	   - Input: `[[3, 2, 1], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `2`
//	
//	44. Find the average of all elements in each row
//	   - Input: `[[10, 20, 30], [5, 15, 25], [1, 2, 3]]`
//	   - Output: `[20, 15, 2]`
//	
//	45. Find the average of all elements in each column
//	   - Input: `[[10, 20], [30, 40], [50, 60]]`
//	   - Output: `[30, 40]`
//	
//	======================================================================================================
//	
//	9. Transformation Based on Neighboring Elements
//	
//	46. Replace each element with the sum of its four neighbors (up, down, left, right)
//	   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `[[6, 8, 10], [12, 15, 18], [16, 20, 22]]`
//	
//	47. Replace each element with the sum of its diagonal neighbors (top-left, top-right, bottom-left, bottom-right)
//	   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `[[5, 8, 5], [14, 20, 14], [5, 8, 5]]`
//	
//	48. Replace each element with the difference of the sum of its neighboring elements and itself
//	   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `[[4, 6, 6], [11, 15, 11], [14, 16, 10]]`
//	
//	49. Replace each element with the average of its neighboring elements
//	   - Input: `[[2, 4, 6], [8, 10, 12], [14, 16, 18]]`
//	   - Output: `[[6, 8, 8], [12, 14, 12], [14, 16, 10]]`
//	
//	50. Replace boundary elements with zero and keep inner elements as they are
//	   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `[[0, 0, 0], [0, 5, 0], [0, 0, 0]]`
//	
//	======================================================================================================
//	
//	10. Specialized Aggregation Tasks
//	
//	51. Calculate the sum of all elements in the array that are divisible by a given number
//	   - Input: `[[10, 20, 15], [25, 30, 35]]`, divisor = 5
//	   - Output: `135`
//	
//	52. Find the count of elements in each column that are prime numbers
//	   - Input: `[[11, 4, 5], [13, 6, 17], [2, 8, 19]]`
//	   - Output: `[3, 0, 3]`
//	
//	53. Calculate the sum of elements on the secondary diagonal in a square matrix
//	   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `15`
//	
//	54. Replace elements by their row median value
//	   - Input: `[[1, 9, 3], [4, 6, 8], [10, 15, 12]]`
//	   - Output: `[[3, 3, 3], [6, 6, 6], [12, 12, 12]]`
//	
//	55. Replace elements by their column median value
//	   - Input: `[[1, 5, 9], [3, 7, 2], [4, 6, 8]]`
//	   - Output: `[[3, 6, 8], [3, 6, 8], [3, 6, 8]]`
//	
//	======================================================================================================
//	
//	11. Rearranging and Reshaping Elements
//	
//	56. Rotate the 2D array 180 degrees
//	   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `[[9, 8, 7], [6, 5, 4], [3, 2, 1]]`
//	
//	57. Flip each row in the 2D array left-to-right
//	   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `[[3, 2, 1], [6, 5, 4], [9, 8, 7]]`
//	
//	58. Flip each column in the 2D array top-to-bottom
//	   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `[[7, 8, 9], [4, 5, 6], [1, 2, 3]]`
//	
//	59. Shift all elements in each row to the right by one position
//	   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `[[3, 1, 2], [6, 4, 5], [9, 7, 8]]`
//	
//	60. Shift all elements in each column down by one position
//	   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
//	   - Output: `[[4, 5, 6], [7, 8, 9], [1, 2, 3]]`

}

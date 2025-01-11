package one_Dimenstional;

import java.util.Arrays;

public class Questions_1D_Arrays {
	public static void main(String[] args) {
		int[] a = {1,121, 23,661,323,553,245,6673 };
		System.out.println("Input : " + Arrays.toString(a));

		p25(a);
	}

//	Q3 ===================================================================

//	====================================================================================
//	====================================================================================
//	Topic: Sum of Digits and Single-Digit Sums
//	====================================================================================
//		Q1. Sum of each digit of each element
//		Input: `[8, 29, 399, 9, 45, 34, 91]`
//		Output: `[8, 11, 21, 9, 9, 7, 10]`
	public static void p1(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int elem = a[i];
			b[i] = add(elem);
		}
		System.out.println("Output : " + Arrays.toString(b));
	}

//
//		Q2. Sum of each digit of each element until a single digit
//		Input: `[8, 29, 399, 9, 45, 34, 91]`
//		Output: `[8, 2, 3, 9, 9, 7, 1]`
	public static void p2(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {

			int elem = a[i];

			int sum = add(elem);
			if (sum > 9) {
				sum = add(sum);
			}

			b[i] = sum;

		}
		System.out.println("Output : " + Arrays.toString(b));
	}

	public static int add(int elem) {
		int sum = 0;

		while (elem != 0) {
			sum += elem % 10;
			elem /= 10;
		}

		return sum;
	}

//
//		Q3. Product of each digit of each element
//		Input: `[8, 29, 399, 9, 45, 34, 91]`
//		Output: `[8, 18, 243, 9, 20, 12, 9]`
	public static void p3(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < b.length; i++) {
			int elem = a[i];

			int pro = 1;

			while (elem != 0) {
				pro *= elem % 10;
				elem /= 10;
			}
			b[i] = pro;
		}
		System.out.println("Output : " + Arrays.toString(b));
	}

//
//		Q4. Count even and odd digits of each element
//		Input : [8, 29, 399, 92, 45, 542, 91]
//		Output: [(1 even , 0 odd), (1 even , 1 odd), (0 even , 3 odd), (1 even , 1 odd), (1 even , 1 odd), (2 even , 1 odd), (0 even , 2 odd)]
	public static void p4(int[] a) {
		String[] b = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			int elem = a[i];

			int even = 0;
			int odd = 0;
			while (elem != 0) {
				int digit = elem % 10;
				if (digit % 2 == 0)
					even++;
				else
					odd++;
				elem /= 10;
			}
			b[i] = "(" + even + " even , " + odd + " odd)";

		}
		System.out.println("Output: " + Arrays.toString(b));
	}

//
//		Q5. Reverse each element's digits
//		   Input: `[123, 456, 789, 10]`
//		   Output: `[321, 654, 987, 1]`
	private static void p5(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int elem = a[i];

			int res = 0;
			while (elem != 0) {
				int digit = elem % 10;
				res = res * 10 + digit;
				elem /= 10;
			}
			b[i] = res;
		}
		System.out.println("Output: " + Arrays.toString(b));
	}

//
//		Q6. Replace each element by the largest digit in the element
//		   Input: `[123, 456, 789, 10]`
//		   Output: `[3, 6, 9, 1]`
	public static void p6(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < b.length; i++) {
			int elem = a[i];

			int max = 0;
			while (elem != 0) {
				int digit = elem % 10;
				if (digit > max) {
					max = digit;
				}
				elem /= 10;
			}
			b[i] = max;
		}
		System.out.println("Output: " + Arrays.toString(b));
	}
//
//		Q7. Replace each element by its single-digit root
//		   Input: `[88, 99, 123, 456]`
//		   Output: `[7, 9, 6, 6]`

	public static void p7(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {

			int elem = a[i];

			int sum = add(elem);
			if (sum > 9) {
				sum = add(sum);
			}

			b[i] = sum;

		}
		System.out.println("Output : " + Arrays.toString(b));

	}

//
//		====================================================================================
//		====================================================================================
//
//		Topic: Array Transformations and Conditions
//		====================================================================================
//		Q8. Replace even elements with their sum of digits
//		   Input: `[18, 29, 44, 15, 8]`
//		   Output: `[9, 29, 8, 15, 8]`
	public static void p8(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {

			int elem = a[i];

			b[i] = i % 2 != 0 ? add(elem) : elem;
		}
		System.out.println("Output : " + Arrays.toString(b));
	}

//
//		Q9. Replace each prime number with the sum of its digits
//		   Input: `[11, 17, 20, 29, 34]`
//		   Output: `[2, 8, 20, 11, 34]`
	public static void p9(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < b.length; i++) {
			int elem = a[i];
//				Find prime number then sum their digit;
			boolean prime = true;
			if (elem <= 1)
				prime = false;

			for (int j = 2; j <= elem / 2; j++) {
				if (elem % j == 0) {
					prime = false;
					break;
				}
			}

			b[i] = prime ? add(elem) : elem;
		}

		System.out.println("Output : " + Arrays.toString(b));

	}

//
//		Q10. Sort elements based on sum of digits
//		    Input: `[12, 21, 13, 31, 7]`
//		    Output: `[7, 12, 21, 13, 31]`
	public static void p10(int[] a) {
		int[] b = new int[a.length];

		// sum of each element
		for (int i = 0; i < b.length; i++) {
			int elem = a[i];

			int sum = add(elem);

			b[i] = sum;
		}

//			Sort array
		int n = b.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (b[j] > b[j + 1]) {
					int temp = b[j];
					b[j] = b[j + 1];
					b[j + 1] = temp;
				}
			}
		}
		System.out.println("Output: " + Arrays.toString(b));
	}

//
//		Q11. Replace elements greater than a given value with their sum of digits
//		    Input: `[99, 23, 50, 7]`, threshold = 30
//		    Output: `[18, 23, 5, 7]`
	public static void p11(int[] a) {
		int[] b = new int[a.length];

		for (int i = 0; i < b.length; i++) {
			int elem = a[i];
			b[i] = elem > 30 ? add(elem) : elem;

		}
		System.out.println("Output: " + Arrays.toString(b));
	}

//
//		Q12. Replace each element with the sum of digits of the largest digit
//		    Input: `[123, 45, 67, 89]`
//		    Output: `[3, 5, 7, 9]`
	public static void p12(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < b.length; i++) {
			int elem = a[i];

			int sum = 0;
			int max = 0;
			while (elem != 0) {
				int digit = elem % 10;
				if (digit > max) {
					max = digit;
					sum = add(max);
				}
				elem /= 10;
			}
			b[i] = sum;
		}
		System.out.println("Output: " + Arrays.toString(b));
	}

//
//		====================================================================================
//		====================================================================================
//
//		Topic: Subarrays and Grouped Calculations
//		====================================================================================
//		Q13. Find maximum sum of subarrays of length k
//		    Input: `[1, 3, 2, 5, 1, 1, 6]`, k = 3
//		    Output: `[2, 5, 1, 1, 6]` (sum: 8)
//
//		Q14. Find minimum product of subarrays of length k
//		    Input: `[4, 2, 6, 3]`, k = 2
//		    Output: `[2, 6]` (product: 12)
//
//		Q15. Sum of digits in each consecutive pair of elements
//		    Input: `[34, 56, 78, 91]`
//		    Output: `[7, 11, 15, 10]`
//
//		Q16. Calculate sum of digits for each subarray of length k
//		    Input: `[25, 46, 17]`, k = 2
//		    Output: `[11, 10]`
//
//		Q17. Average of elements in each subarray of length k
//		    Input: `[5, 15, 20, 25]`, k = 2
//		    Output: `[10, 17.5]`
//
//		====================================================================================
//		====================================================================================
//
//		Topic: Modifications Based on Element Positions
//		====================================================================================
//		Q18. Replace elements at even indexes with sum of digits
//		    Input: `[44, 23, 56, 89]`
//		    Output: `[8, 23, 11, 89]`
	public static void p18(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int elem = a[i];

			int sum = 0;

			if (i % 2 != 0) {
				while (elem != 0) {
					int digit = elem % 10;
					sum += digit;
					elem /= 10;
				}
			}

			b[i] = i % 2 != 0 ? sum : elem;

		}
		System.out.println("Output : " + Arrays.toString(b));
	}

//
//		Q19. Replace each element with the sum of digits of its index
//		    Input: `[20, 25, 15, 30]`
//		    Output: `[0, 1, 2, 3]`

	public static void p19(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int elem = a[i];

			int sum = add(elem);

			b[i] = sum;

		}
		System.out.println("Output : " + Arrays.toString(b));
	}

//
//		Q20. Find elements where sum of digits equals their index
//		    Input: `[10, 11, 20, 31]`
//		    Output: `[11]`
	public static void p20(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int elem = a[i];
			int sum = add(elem);

			if (sum == i) {
				System.out.println("index=" + i + " , elem=" + elem + " , sum=" + sum);
			}
		}
	}

//
//		Q21. Elements that are palindrome sums
//		    Input: `[45, 1221, 17]`
//		    Output: `[1221]`
	public static void p21(int[] a) {
		int[] b=new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int elem = a[i];
			
			int rev = reverse(elem);
			if(elem == rev ) {
				System.out.println("Palindromic Element : "+ elem);
			}			
		}
	}

//
//		Q22. Replace elements at odd indexes with their reverse digits
//		    Input : [123, 31, 14, 21, 13, 13, 6]
//			Output : [321, 31, 41, 21, 31, 13, 6]
	public static void p22(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int elem = a[i];
			int rev = 0;
			if (i % 2 == 0) {
				rev=reverse(elem);
			}
			b[i] = i % 2 == 0 ? rev : elem;
		}
		System.out.println("Output : " + Arrays.toString(b));
	}

	public static int reverse(int elem) {
		int rev = 0;
		while (elem != 0) {
			int digit = elem % 10;
			rev = rev * 10 + digit;
			elem /= 10;
		}
		return rev;
	}

//
//		====================================================================================
//		====================================================================================
//
//		Topic: Conditions on Array Elements
//		====================================================================================
//		Q23. Replace elements if sum of digits is greater than a specific value 
//			Input : [98999, 238897, 44575, 198975], threshold = 30
//			Output : [44, 37, 44575, 39]
	public static void p23(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = add(a[i]) > 30 ? add(a[i]) : a[i];
		}

		System.out.println("Output : " + Arrays.toString(b));
	}

//
//		Q24. Find elements where the sum of digits is a prime number
//		    Input : [1, 121, 23, 661, 323, 553, 245, 6673]`
//		    Output: `[1, 23,661,553,245]`
	public static void p24(int[] a) {
		String[] b = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			int elem = a[i];
			int sum = add(elem);
		
			if (isPrime(sum) ) {				
				System.out.println(("(elem="+elem+", sum="+sum+" is Prime)"));
			}
		}
	}
	public static boolean isPrime(int num) {
		
		if(num<=1) return true;
		for (int i = 2; i <= num/2; i++) {
			if(num%i==0) {
				return false;
			}
			else {
				return true;
			}
		}
		
		return true;
	}
	
//
//		Q25. Check if any element's sum of digits equals its reverse
//		    Input: `[12, 21, 33, 42]`
//		    Output: `[33]`
	public static void p25(int[] a) {
		int[] b= new int[a.length];
		for (int i = 0; i < b.length; i++) {
			int elem = a[i];
			
			int sum = add(elem);
			int rev = reverse(elem);
			
			if(sum == rev) {
				System.out.println("sum==rev : "+elem);
			}
		}
	}
//
//		Q26. Filter out elements with odd digit sums
//		    Input: `[45, 32, 17, 29]`
//		    Output: `[32, 17]`
//
//		Q27. Identify elements where the product of digits equals their sum of digits
//		    Input: `[22, 33, 15]`
//		    Output: `[15]`
//
//		====================================================================================
//		====================================================================================
//
//		Topic: Array Operations and Transformations
//		====================================================================================
//		Q28. Count elements with sum of digits in a specific range
//		    Input: `[11, 22, 33, 44]`, range = (5, 10)
//		    Output: `2` (elements: `[22, 44]`)
//
//		Q29. Square elements with an odd sum of digits
//		    Input: `[11, 24, 35, 45]`
//		    Output: `[11, 24, 1225, 2025]`
//
//		Q30. Find the largest element after calculating sum of digits
//		    Input: `[99, 29, 15, 11]`
//		    Output: `99`
//
//		Q31. Sum of each element up to two-digit sums
//		    Input: `[999, 88, 76]`
//		    Output: `[18, 16, 13]`
//
//		Q32. Convert each element to binary and count ones
//		    Input: `[3, 7, 8, 15]`
//		    Output: `[2, 3, 1, 4]`
//
//		====================================================================================
//		====================================================================================
//
//		Topic: Advanced Combinations and Challenges
//		====================================================================================
//		Q33. Replace elements by the difference between largest and smallest digits
//		    Input : [123783, 367935, 2374, 2389, 134, 3, 17, 19]
//			Output: [  7,      6,      5,    7,   3,  3,  6,  8]
	public static void p33(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < b.length; i++) {
			int elem = a[i];

			int max = 0;
			int min = 0;
			int diff = 0;
			while (elem != 0) {
				int digit = elem % 10;
				if (digit > max) {
//					min = max;
					max = digit;
				} else if (digit < min || digit > min) {
					min = digit;
				}
				elem /= 10;
			}
			diff = max - min;
			b[i] = diff;

		}
		System.out.println("Output : " + Arrays.toString(b));
	}

//
//		Q34. Replace each element with the reverse of the sum of digits
//		    Input : [1239, 395, 274, 2389, 134, 3, 67, 19]
//			Output : [51, 71, 31, 22, 8, 3, 31, 1]
	public static void p34(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int elem = a[i];

			int sum = add(elem);
			int rev = 0;
			while (sum != 0) {
				int digit = sum % 10;
				rev = rev * 10 + digit;
				sum /= 10;
			}

			b[i] = rev;

		}
		System.out.println("Output : " + Arrays.toString(b));
	}

//
//		Q35. Group elements by single-digit sums
//		    Input: `[18, 27, 36, 9]`
//		    Output: `{9: [18, 27], 3: [36, 9]}`
//
//		Q36. Replace elements with factorial of sum of digits
//		    Input: `[11, 23, 15]`
//		    Output: `[2, 6, 120]`
	public static void p36(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int elem = a[i];

			int sum = add(elem);
			int fact = factorial(sum);

			a[i] = fact;
		}
		System.out.println("Output : " + Arrays.toString(a));
	}

	public static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		int prod = 1;
		for (int i = 1; i <= n; i++) {
			prod *= i;
		}

		return prod;
	}
//
//		Q37. Identify elements with a palindromic sum of digits
//		    Input: `[121, 131, 145]`
//		    Output: `[121, 131]`

}

package Searching;

public class Test {

	public static void main(String[] args) {
		int[] a = { 2, 2, 3, 4, 5, 7, 7, 8, 9, 9 };

		//call for linearSearch() By loop
		System.out.println(linearSearch(a, 5));
		System.out.println(linearSearch(a, 10));

		//call for linearSearch() By recursion
		System.out.println(linearSearch(a, 7, 0));
		System.out.println(linearSearch(a, 11, 0));

		//call for binarySearch() By loop
		System.out.println(binarySearch(a, 9));
		System.out.println(binarySearch(a, 10));

		//call for binarySearch() By recursion
		System.out.println(binarySearch(a, 5, 0, a.length - 1));
		System.out.println(binarySearch(a, 10, 0, a.length - 1));
	}

// Binary Search by loop
	public static int binarySearch(int[] a, int elem) {
		int start = 0;
		int end = a.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (elem == a[mid])
				return mid;
			else if (elem < a[mid])
				end = mid - 1;

			start = mid + 1;
		}
		return -1;
	}

	// Binary Search by recursion
	public static int binarySearch(int[] a, int elem, int start, int end) {
		// base condition
		if (start > end)
			return -1;

		int mid = (start + end) / 2;
		if (elem == a[mid])
			return mid;
		else if (elem < a[mid])
			return binarySearch(a, elem, start, mid - 1);

		return binarySearch(a, elem, mid + 1, end);

	}

	// Linear Search by loop
	public static int linearSearch(int[] a, int elem) {
		for (int i = 0; i < a.length; i++) {
			if (elem == a[i])
				return i;

		}
		return -1;
	}

	// Linear Search by recursion
	public static int linearSearch(int[] a, int elem, int start) {
		// base condition
		if (start > a.length - 1)
			return -1;

		if (elem == a[start])
			return start;

		return linearSearch(a, elem, start + 1);
	}

}

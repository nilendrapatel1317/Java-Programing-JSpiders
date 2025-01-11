package Searching;

public class Binary_Search {
	public static void main(String[] args) {
		int[] a = { 2, 2, 3, 4, 5, 7, 7, 8, 9, 9 };
		System.out.println(search(a, 9));
		System.out.println(search(a, 10));
		System.out.println(search(a, 5, 0, a.length-1));
	}

	//by using lopp
	public static int search(int[] a, int elem) {
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

	
	//By using recursion
	public static int search(int[] a, int elem, int start, int end) {

		if(start > end) return -1;
		int mid = (start + end) / 2;

		if (elem == a[mid])
			return mid;

		else if (elem < a[mid])
			return search(a, elem, start, mid - 1);

		return search(a, elem, mid + 1, end);
	}
}

package one_Dimenstional;

public class bs {
	public static void main(String[] args) {
		int[] a = { 2, 2, 3, 4, 5, 7, 7, 8, 9, 9 };

		System.out.println(search(a, 9, 0, a.length - 1));
	}

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

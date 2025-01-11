package two_Dimenstional;

public class Multiplication_2D_Arrays {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 3, 2, 1 }, { 2, 2, 1 } };
		int[][] b = { { 2, 1, 1 }, { 3, 2, 1 }, { 1, 1, 2 } };

		int[][] c = multiply(a, b);

		for (int[] temp : c) {
			for (int n : temp) {
				System.out.print(n + "\t");
			}
			System.out.println();
		}

	}

	public static int[][] multiply(int[][] a, int[][] b) {
		int len = a.length;

		int[][] c = new int[len][len];

		for (int i = 0; i < len; i++) { // used for each row
			for (int j = 0; j < len; j++) { // used for each column
				for (int k = 0; k < len; k++) { // used for each element
					c[i][j] += a[i][k] * b[k][j];
//					System.out.println(a[i][k] +"*"+b[k][j]+"="+c[i][j]);
				}
				System.out.println();
			}
		}

		return c;
	}
}

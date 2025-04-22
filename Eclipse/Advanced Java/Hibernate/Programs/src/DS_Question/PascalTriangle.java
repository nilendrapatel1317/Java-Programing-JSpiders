package DS_Question;

public class PascalTriangle {
	public static void main(String[] args) {
		int row = 6;
		int[][] a = new int[row][];
		int[][] result = isPascal(a);
		int space = row-1;
		for (int[] num : result) {
			for (int i = 1; i <= space; i++) {
				System.out.print(" ");
			}
			for (int n : num) {
				System.out.print(n+" ");
			}
			System.out.println();
			space--;
		}
		
	}

	private static int[][] isPascal(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = new int[i+1];
			for (int j = 0; j < a[i].length; j++) {
				if(i==j||j==0) {
					a[i][j] = 1;
				}
				else {
					a[i][j] = a[i-1][j-1]+a[i-1][j];
				}
			}
		}
		return a;
	}
}

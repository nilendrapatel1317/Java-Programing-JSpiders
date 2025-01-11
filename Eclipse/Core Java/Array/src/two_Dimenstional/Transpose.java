package two_Dimenstional;

public class Transpose {
	public static void main(String[] args) {
		int[][] a = {
				{2,3,5},
				{7,1,0},
				{6,9,5}
			};
		int[][] b = new int[a.length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				b[i][j]=a[j][i];
			}
		}
		
		for (int[] temp : b) {
			for (int n : temp) {
				System.out.print(n+"\t");
			}
			System.out.println();
		}
	}
	
	
}

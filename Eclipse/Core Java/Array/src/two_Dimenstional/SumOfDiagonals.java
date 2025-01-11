package two_Dimenstional;

public class SumOfDiagonals {

	public static void main(String[] args) {
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		
		int sum = 0;
//		for (int i = 0; i < a.length; i++) {
//			for (int j = 0; j < a.length-1; j++) {
//				if(i==j) sum+=a[i][j];
//			}
//		}
		for (int i = 0; i < a.length; i++) {
			sum+=a[i][i];
		}
		
		System.out.println(sum);

	}

}

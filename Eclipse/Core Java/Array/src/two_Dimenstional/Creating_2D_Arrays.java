package two_Dimenstional;

import java.util.Arrays;


// Creating 2D Arrays
public class Creating_2D_Arrays {
	public static void main(String[] args) {
		//Method 1
		int[][] a = new int[3][4];
		a[0][0] = 10;
		a[0][1] = 20;
		a[0][2] = 30;
		a[0][3] = 40;
		a[1][0] = 50;
		a[1][1] = 60;
		a[1][2] = 70;
		a[1][3] = 80;
		a[2][0] = 90;
		a[2][1] = 100;
		a[2][2] = 110;
		a[2][3] = 120;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println();
		//Method 2
		int[][] b = new int[3][];
		b[0] = new int[3];
		b[1] = new int[4];
		b[2] = new int[5];
		
		for (int[] temp : b) {
			for (int n : temp) {
				System.out.print(n+"\t");
			}
			System.out.println();
		}
		
		
		System.out.println();
		//Method 3
		int[][] c = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		
		for (int[] temp : c) {
			for (int n : temp) {
				System.out.print(n+"\t");
			}
			System.out.println();
		}
	}
}































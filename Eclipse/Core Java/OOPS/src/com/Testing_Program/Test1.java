package com.Testing_Program;

public class Test1 {
	public static void main(String[] args) {
		int n = 5;	

		for (int r = 1; r <= 2*n - 1; r++) {
			int totalColsInRow = r <= n ? r : 2*n-r;
			for (int c = 1; c <= totalColsInRow; c++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}
}

//  num = 5
//	row	 col		
//	1	1		*
//	2	2		* *
//	3	3		* * *
//	4	4		* * * *
//	5	5		* * * * *
//	6	4		* * * *
//	7	3		* * * 
//	8	2		* *
//	9	1		*
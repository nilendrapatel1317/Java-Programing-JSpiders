package two_Dimenstional;

public class Sum_Of_Dia_And_Anti_Dia {

	public static void main(String[] args) {
		int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		int len = a.length;
		int sum = 0;
		for (int i = 0; i < len; i++) {
			System.out.print(a[i][i]+" ");
			sum+=a[i][i];
			if(len%2 != 0 && i==len/2) continue;
			System.out.print(a[i][len-1-i]+" ");
			sum+=a[i][len-1-i];
		}
		System.out.println();
		System.out.println("sum="+sum);

	}

}

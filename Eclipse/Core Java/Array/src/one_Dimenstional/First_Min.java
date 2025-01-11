package one_Dimenstional;

public class First_Min {
	public static void main(String[] args) {
		int[] a = {4,3,5,6,8,7,9,2,12};
		System.out.println(firstMinNum(a));
		
	}
	
	public static int firstMinNum(int[] a) {
		int firstMin = a[0];
		for (int i = 0; i < a.length; i++) {
			if(a[i] < firstMin) {
				firstMin = a[i];
			}
		}
		return firstMin;
	}
}

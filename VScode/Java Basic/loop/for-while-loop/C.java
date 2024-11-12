import java.util.Scanner;
class C 
{
	public static void main(String[] args) 
	{
		//Expected Output: 1+2+3+4+5=15
		int sum = 0;
		String str = "";
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int num = scn.nextInt();
		
		for(int i=1; i<=num; i++){
			sum += i;
			str += i;
			if(i<num) str += " + ";
					
		}
		System.out.println(str + " = " + sum);
	}
}

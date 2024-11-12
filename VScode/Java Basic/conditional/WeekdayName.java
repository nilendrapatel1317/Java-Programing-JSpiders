import java.util.Scanner;
class WeekdayName
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a week day number : ");
		int day = scn.nextInt();
		
		switch (day)
		{
			case 1:
				System.out.println(day + " is Sunday");
				break;
			case 2:
				System.out.println(day + " is Monday");
				break;
			case 3:
				System.out.println(day + " is Tuesday");
				break;
			case 4:
				System.out.println(day + " is Wednesday");
				break;
			case 5:
				System.out.println(day + " is Thursday");
				break;
			case 6:
				System.out.println(day + " is Friday");
				break;
			case 7:
				System.out.println(day + " is Saturday");
				break;
			default:
				System.out.println(day + "Error : Invalid input");
		
		}
		WeekdayName.main(null);
	}
}

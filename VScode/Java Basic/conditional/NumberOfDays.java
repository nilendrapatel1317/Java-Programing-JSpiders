import java.util.Scanner;
class NumberOfDays 
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a month : ");
		int mon = scn.nextInt();
		
		System.out.print("Enter a year in format xxxx :");
		int year = scn.nextInt();
		
		switch (mon)
		{
			//For checking 31 days
			case 1:	
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("31 days are present in " + mon + " month in " + year + " year !" );
				break;
			
			//For checking 30 days
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("30 days are present in " + mon + " month in " + year + " year !" );
				break;
			
			//For February month (depends on leap year)
			case 2:
				if((year%400 == 0) || (year%4 == 0 && year%100 != 0)){
					System.out.println("29 days are present in " + mon + " month in " + year + " year !" );
				} else {
					System.out.println("28 days are present in " + mon + " month in " + year + " year !" );
				}
				
				break;
			
			
			default:
				System.out.println("Error : Invalid Input" );
				
		}
		System.out.println();
		NumberOfDays.main(null);
	}
}

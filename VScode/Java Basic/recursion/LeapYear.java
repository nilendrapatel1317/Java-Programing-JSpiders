import java.util.Scanner;

public class LeapYear {

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scn.nextInt();

        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is Not a Leap Year");
        }

        main(null);
    }
}

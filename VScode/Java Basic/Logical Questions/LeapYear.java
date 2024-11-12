
import java.util.Scanner;

public class LeapYear {

    static boolean isLeapYear(int y) {
        // if((y%4==0 && y%100 != 0) || y%400 == 0 ){
        //     return true;
        // }

        if (y % 4 == 0) {
            if (y % 100 == 0) {
                return y % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a year : ");
        int year = scn.nextInt();

        // Check if given year is Leap year or not 
        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }

        System.out.println();

        //Print All leap year up to given range
        System.out.print("Enter year range : ");
        int range = scn.nextInt();
        System.out.println("Leap year List Up to Range" + range);
        for (int i = 1; i <= range; i++) {
            if (isLeapYear(i)) {
                System.out.println(i);
            }
        }

        System.out.println();

        //Print All leap year between given start and end range
        System.out.print("Enter starting range : ");
        int start = scn.nextInt();
        System.out.print("Enter ending range : ");
        int end = scn.nextInt();
        System.out.println("Leap year List Up to Range" + range);
        for (int i = start; i <= end; i++) {
            if (isLeapYear(i)) {
                System.out.println(i);
            }
        }
    }
}


import java.util.Scanner;

public class BinToDec {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Binary Number :");
        int num = scn.nextInt();
        int decimal = 0, i = 1;
        while (num > 0) {
            decimal += (num %10) * i;
            i *= 2;
            num /= 10;
        }
        System.out.println("Decimal equivalent is: " + decimal);
    }
}

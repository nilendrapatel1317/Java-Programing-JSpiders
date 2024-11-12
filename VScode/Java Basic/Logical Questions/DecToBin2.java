import java.util.Scanner;
class DecToBin2 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scn.nextInt();
        int result = 0;
        int i = 1;
        while(num > 0){
            int bit = num %2;
            result = bit * i + result;
            i *= 10;
            num /=2;
        }
        System.out.println(result);

        main(null);
    }
}
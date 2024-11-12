import java.util.Scanner;
class DecToBin {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scn.nextInt();
        String result ="";

        while(num > 0){
            int bit = num %2;
            result = bit + result;
            num /=2;
        }
        System.out.println(result);

        main(null);
    }
}
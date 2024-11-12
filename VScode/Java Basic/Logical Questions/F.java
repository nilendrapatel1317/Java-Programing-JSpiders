public class F {
    public static void main(String[] args) {
        int num = 153, originalNum, remainder, result = 0, n = 0;
        originalNum = num;
        for (; originalNum != 0; originalNum /= 10, ++n);
        originalNum = num;
        for (; originalNum != 0; originalNum /= 10) {
            remainder = originalNum % 10;
            result += Math.pow(remainder, n);
        }
        if (result == num)
            System.out.println(num + " is an Armstrong number.");
        else
            System.out.println(num + " is not an Armstrong number.");
    }
}

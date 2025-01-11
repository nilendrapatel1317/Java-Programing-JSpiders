
public class AA {
  public static void main(String[] args) {
    System.out.println(singleDigit(11234));
  }

  public static int singleDigit(int n) {
    int sum = 0;
    while (n != 0) {
      int digit = n % 10;
      sum += digit;
      n /= 10;
    }
    return sum > 9 ? singleDigit(sum) : sum;
  }
}

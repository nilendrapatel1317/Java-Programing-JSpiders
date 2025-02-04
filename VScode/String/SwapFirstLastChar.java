public class SwapFirstLastChar {

  public static void main(String[] args) {
    String s = "How are you Nilendra";
    System.out.println(s);
    String[] strArr = s.split(" ");

    for (int i = 0; i < strArr.length; i++) {
      String elem = strArr[i];

      System.out.print(reverse(elem) + " ");
    }
  }

  public static String reverse(String elem) {
    String s1 = "";
    char[] ch = elem.toCharArray();
    int i = 0;
    int j = ch.length - 1;

    for (int k = 0; k < ch.length; k++) {
      if (k == i) {
        s1 += ch[j];
      } else if (k == j) {
        s1 += ch[i];
      } else {
        s1 += ch[k];
      }
    }
    return s1;
  }
}

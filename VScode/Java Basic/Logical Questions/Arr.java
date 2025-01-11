
public class Arr {
  public static void main(String[] args) {
    int[] a = {1,3,4,0,4};

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length-1; j++) {
        if(a[i]==a[j+1]){
          System.out.println(i);
        }
      }
    }

  }
}

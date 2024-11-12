public class B {
  int i = 20;

  B(int i){
    this.i =i;
  }

  public static void main(String[] args) {
    B b1 = new B(34);
    // In main method I created a new object of class B and assigning it to the variable b1. The value 34 is passed to the constructor, which is assign this value to the object's i variable. After this b1.i will hold the value 34.
    System.out.println(b1.i);
  }
}

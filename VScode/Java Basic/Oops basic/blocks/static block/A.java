
class A {

    static int i;
    int j;

    static {
        i = 10;
        System.out.println("Hello Nilendra ");
    }
    A(){
      System.out.println("Constructor");
    }

    public static void main(String[] args) {
        new A(); // calling constrauctor
        new A(); //
        new A();
    }
}

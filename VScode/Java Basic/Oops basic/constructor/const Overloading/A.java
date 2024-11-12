
class A {

    int first, second;

    A(int x, int y) {
        first = x;
        second = y;
    }

    A() {
        this(10, 20);
    }

    void display() {
        System.out.println(first + " " + second);
    }

    public static void main(String args[]) {
      A p = new A();
      p.display();
    }
}

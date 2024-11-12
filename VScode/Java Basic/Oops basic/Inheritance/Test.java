
class A {

    
}

class B extends A {

    B() {
        System.out.println("B Cons");
    }

}

public class Test {
    public static void main(String[] args) {
        new B();
    }
}

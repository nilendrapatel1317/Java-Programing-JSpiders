class A {
    int a = 20;          // instance variable or non-static variable
    static int b = 30;   // class variable or static variable

    public static void main(String[] args) {
        int c = 10;      // Local variable

        // To print the local variable c
        System.out.println("Value of c (local variable): " + c);

        // To print the static variable b
        System.out.println("Value of b (static variable): " + b);

        // To print the non-static variable a
        A obj = new A(); // Create an instance of class A
        System.out.println("Value of a (non-static variable): " + obj.a);
    }
}

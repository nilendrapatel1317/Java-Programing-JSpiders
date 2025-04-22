package Collection;

interface A {
    default void show() {
        System.out.println("Interface A");
    }
}
abstract class Nilu{
	public Nilu() {
		
	}
}

interface B {
    default void show() {
        System.out.println("Interface B");
    }
}

// Class implementing both interfaces
class C implements A, B {
    // Resolving conflict by overriding
    public void show() {
        A.super.show();
        B.super.show();
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
    }
}

package OOPs;

abstract class A {
	//It have constructor
	public A() {}
	abstract void m1(int i);
	
}
class B extends A{

	@Override
	void m1(int i) {
		System.out.println(i);
		
	}
	
}

interface C {
	// don't have contructor
	
	void m2(int i); //til JDK 7 All methods are by default public and abstract
}

class D implements C{

	@Override
	public void m2(int i) {
		System.out.println(i);
		
	}
	
}

public class Test {
	public static void main(String[] args) {
		A a1 = new B();
		a1.m1(10);
		C c2 = new C() {
			
			@Override
			public void m2(int i) {
				System.out.println("Hii");
				
			}
		};
		c2.m2(40);
		
		C c1 = new D();
		c1.m2(20);
		
	}

	private static void CaseChange() {
		String str = "AkShAy";
		StringBuilder result = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (Character.isUpperCase(c))
				result.append(Character.toLowerCase(c));
			else
				result.append(Character.toUpperCase(c));
		}
		System.out.println(result); // Output: aKsHaY
	}
}

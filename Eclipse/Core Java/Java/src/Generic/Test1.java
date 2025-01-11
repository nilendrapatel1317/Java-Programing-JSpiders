package Generic;

class A<E>{
	private E x;
	public void add(E e) {
		x=e;
	}
	public E get() {
		return x;
	}
}

public class Test1 {
	public static void main(String[] args) {
		A<String> a1 = new A<String>();
		a1.add("Nilendra");
		
		String s = a1.get();
		System.out.println(s);
		
		A<Integer> a2 = new A<Integer>();
		a2.add(20);
		int n = a2.get();
		System.out.println(n);
	}
}

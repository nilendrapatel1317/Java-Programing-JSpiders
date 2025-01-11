package Generic;

class GenericExample<T, U> {
	T obj1;
	U obj2;

	public GenericExample(T obj1, U obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	public void print() {
		System.out.println(obj1);
		System.out.println(obj2);
	}
}

public class Test2 {
	public static void main(String[] args) {
		GenericExample<String , Integer> obj1 = new GenericExample<String , Integer>("Nilendra", 101);
		GenericExample<String , Integer> obj2 = new GenericExample<>("d", 101);
		
		
		obj1.print();
		obj2.print();
	}
}

package OOPs;

class Parent {
	String name = "Dinesh Patel";
}

class Child1 extends Parent {
	String name = "Nilendra Patel";

	Child1() {
		System.out.println("Student Name : "+name); // Child class variable
		System.out.println("Parent name : "+super.name); // Parent class variable
		System.out.println();
	}
}

class Child2 extends Parent {
	String name = "Neelesh Patel";
	
	Child2() {
		System.out.println("Student Name : "+name); // Child class variable
		System.out.println("Parent name : "+super.name); // Parent class variable
		System.out.println();
	}
}

class Child3 extends Parent {
	String name = "Neha Patel";
	
	Child3() {
		System.out.println("Student Name : "+name); // Child class variable
		System.out.println("Parent name : "+super.name); // Parent class variable
		System.out.println();
	}
}

public class Test1 {
	public static void main(String[] args) {
		new Child1();
		new Child2();
		new Child3();
	}
}

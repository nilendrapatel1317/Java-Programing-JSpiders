package comparable;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Circle c = new Circle(10);
		System.out.println(c);
		System.out.println();

		
		Circle[] a = { 
				new Circle(60), 
				new Circle(30), 
				new Circle(70), 
				new Circle(50) 
			};
		Arrays.sort(a);
		for (Circle c1 : a) {
			System.out.println(c1);
		}
		
		
//		===============================================================================
		System.out.println();
		Student[] std = {
				new Student("Nilendra",99),
				new Student("Archna",59),
				new Student("Rohit",77),
				new Student("Boss",89),
				new Student("Priya",19),
				new Student("Nandini",29),
				new Student("Karan",62),
		};
		
	Arrays.sort(std);
	for (Student student : std) {
		System.out.println(student);
	}
	}
}

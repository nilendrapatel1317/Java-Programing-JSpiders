package HashSet_for_Object_type;

public class Test {
	public static void main(String[] args) {
		HashSet h = new HashSet();
		Student s1 = new Student("Nilendra", 99);
		Student s2 = new Student("Archana", 89);
		Student s3 = new Student("Nilendra", 99);
		Student s4 = new Student("Vikash", 45);
		Student s5 = new Student("Dinesh", 77);
		Student s6 = new Student("Nilendra", 89);
		Student s7 = new Student("Nilu", 77);
		
		System.out.println("Size of hashset : " + h.size());
		System.out.println();
		h.add(s1);
		h.add(s2);
		h.add(s3);
		h.add(s4);
		h.add(s5);
		h.add(s6);
		h.add(s7);
		
		h.traverse();
		System.out.println();
		System.out.println("Size of hashset : " + h.size());
		
//		System.out.println(h.search(s2));
		
		
	}
}

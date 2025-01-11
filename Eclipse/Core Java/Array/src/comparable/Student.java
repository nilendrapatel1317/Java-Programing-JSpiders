package comparable;

public class Student implements Comparable {
	String name;
	int marks;

	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {

		return "name = " + name + " , marks = " + marks;
	}

	@Override
	public int compareTo(Object o) {
		
//		//compared based on name
//		return this.name.compareTo(((Student)o).name);
		
		Student s = (Student) o;
		if(marks > s.marks) return 1;
		if(marks < s.marks) return -1;
		return 0;
	}

}

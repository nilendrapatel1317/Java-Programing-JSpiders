package HashSet_for_Object_type;

public class Student {
	String name;
	int marks;
	
	public Student(String name , int marks) {
		this.name = name;
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return "Student [ name = "+name+" , marks = "+marks+" ]";
	}
	
	@Override
	public int hashCode() {
		return name.charAt(0);
	}
	
	@Override
	public boolean equals(Object arg) {
		if(!(arg instanceof Student)) return false;
		
		Student s = (Student)arg; //Downcasting from Object type to Student type
		return name.equals(s.name) && marks==s.marks;
		
	}
}

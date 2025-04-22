package springdemoo.demo;

public class Student {
	private String name;
	Mobile mobile;
	
	public Student() {
		System.out.println("Object Created");
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
		System.out.println("Dependency Injected");
	}


	public Mobile getMobile() {
		return mobile;
	}


	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}


	public Student(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return name +" is using "+ mobile.getName() + " mobile";
	}
	
	public void init() {
		System.out.println("Object initialized");
	}

	public void destroy() {
		System.out.println("Object Destroyed");
	}
	
	

}

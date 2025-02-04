package employee;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String email;

	public Employee(int id, String name, int age, String gender, String email) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}

	public Employee(String name, int age, String gender, String email) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}
}

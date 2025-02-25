package mock;

public class Users {
	private int id;
	private String name;
	private String username;
	private int age;
	private String gender;
	private String email;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", username=" + username + ", age=" + age + ", gender=" + gender
				+ ", email=" + email + ", password=" + password + "]";
	}
	public Users(String name, String username, int age, String gender, String email, String password) {
		this.name = name;
		this.username = username;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	
	
	
}

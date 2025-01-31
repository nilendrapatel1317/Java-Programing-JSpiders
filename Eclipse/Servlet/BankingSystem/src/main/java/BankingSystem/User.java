package BankingSystem;

public class User {
	private long id;
	private String name;
	private int age;
	private String gender;
	private String city;
	private long phone;
	private String email;
	private String password;
	private long accountNumber;

	public User() {
	}

	// For Login
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	// For Register
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// For Update User details
	public User(String name, int age, String gender, String city, long phone) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.phone = phone;
	}

	public void deleteUserObject(long id, String name, int age, String gender, String city, long phone, String email, String password,
			long accountNumber) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.accountNumber = accountNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
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

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", city=" + city
				+ ", phone=" + phone + ", email=" + email + ", password=" + password + ", accountNumber="
				+ accountNumber + "]";
	}
}

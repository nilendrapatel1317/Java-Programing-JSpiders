package Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeDriver {
	private Connection connection;
	private Scanner scanner;

	public EmployeeDriver(Connection connection, Scanner scanner) {
		this.connection = connection;
		this.scanner = scanner;
	}

	public void register() {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();
		System.out.print("Enter Password: ");
		String password = scanner.nextLine();
		if (emp_exist(email)) {
			System.out.println("\nEmployee Already Exists for this Email Address !!");
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
			return;
		}
		String register_query = "INSERT INTO employee (id ,name, email, password) VALUES(?,?, ?, ?)";
		try {
			int empId = generateEmployeeId();
			PreparedStatement preparedStatement = connection.prepareStatement(register_query);
			preparedStatement.setInt(1, empId);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("\nRegistration Successfull !!");
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
			} else {
				System.out.println("\nRegistration Failed !!");
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int generateEmployeeId() {
		try {
			Statement statement = connection.createStatement();
			String fetchAccountQuery = "SELECT id FROM employee ORDER BY id DESC LIMIT 1";
			ResultSet resultSet = statement.executeQuery(fetchAccountQuery);
			if (resultSet.next()) {
				int last_emp_id = resultSet.getInt("id");
				return last_emp_id + 1;
			} else {
				return 100100;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 100100;
	}

	public long login() {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();
		email = email.toLowerCase();
		System.out.print("Enter Password: ");
		String password = scanner.nextLine();
		String login_query = "SELECT * FROM employee WHERE email = ? AND password = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(login_query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt("id");
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private boolean emp_exist(String email) {
		String query = "SELECT * FROM employee WHERE email = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void fetchEmployee(long empId) {
		try {
			String empQuery = "SELECT * FROM employee WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(empQuery);
			preparedStatement.setLong(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String role = resultSet.getString("role");
				String email = resultSet.getString("email");

				System.out.println("\nEmployee Profile: ");
				System.out.println(
						"+----------+----------------+-----+----------+----------------------+--------------------+");
				System.out.println(
						"| EmpID    | Name           | Age | Gender   | Role                 | Email              |");
				System.out.println(
						"+----------+----------------+-----+----------+----------------------+--------------------+");
				System.out.printf("| %-8s | %-14s | %-3s | %-8s | %-20s | %-18s |\n", id, name, age, gender, role,
						email);
				System.out.println(
						"+----------+----------------+-----+----------+----------------------+--------------------+");

			} else {
				System.out.println("\nEmployee Not Found !! Please First Login !!");
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployeeDetails(long empId, int choice) {
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		try {
			switch (choice) {
			case 1:
				scanner.nextLine();
				System.out.print("Enter Employee Name: ");
				String name = scanner.nextLine();
				if (name.trim().length() > 0) {
					String nameQuery = "UPDATE employee SET name = ? WHERE id = ?";
					PreparedStatement name_pstm = connection.prepareStatement(nameQuery);
					name_pstm.setString(1, name);
					name_pstm.setLong(2, empId);
					if (name_pstm.executeUpdate() > 0) {
						System.out.println("\nEmployee Name Updated Successfully !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					} else {
						System.out.println("\nUpdation Failed !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					}
				} else {
					System.out.println("\nUpdation Failed !! Name can not be empty !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
				break;
			case 2:
				scanner.nextLine();
				System.out.print("Enter Employee Age: ");
				int age = scanner.nextInt();
				if (age >= 15) {
					String ageQuery = "UPDATE employee SET age = ? WHERE id = ?";
					PreparedStatement age_pstm = connection.prepareStatement(ageQuery);
					age_pstm.setInt(1, age);
					age_pstm.setLong(2, empId);
					if (age_pstm.executeUpdate() > 0) {
						System.out.println("\nEmployee Age Updated Successfully !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					} else {
						System.out.println("\nUpdation Failed !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					}
				} else {
					System.out.println("\nUpdation Failed !! Age must greater than equal to 15 !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
				break;
			case 3:
				scanner.nextLine();
				System.out.print("Enter Employee Gender: ");
				String gender = scanner.nextLine();
				gender = gender.toLowerCase();
				if (gender.equals("male") || gender.equals("female")) {
					String cityQuery = "UPDATE employee SET gender = ? WHERE id = ?";
					PreparedStatement city_pstm = connection.prepareStatement(cityQuery);
					city_pstm.setString(1, gender);
					city_pstm.setLong(2, empId);
					if (city_pstm.executeUpdate() > 0) {
						System.out.println("\nEmployee Gender Updated Successfully !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					} else {
						System.out.println("\nUpdation Failed !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					}
				} else {
					System.out.println("\nUpdation Failed !! Gender either Male or Female !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
				break;
			case 4:
				scanner.nextLine();
				System.out.print("Enter Employee Role: ");
				String role = scanner.nextLine();
				String phoneQuery = "UPDATE employee SET role = ? WHERE id = ?";
				PreparedStatement phone_pstm = connection.prepareStatement(phoneQuery);
				phone_pstm.setString(1, role);
				phone_pstm.setLong(2, empId);
				if (phone_pstm.executeUpdate() > 0) {
					System.out.println("\nEmployee Role Updated Successfully !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				} else {
					System.out.println("\nUpdation Failed !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
				break;
			}

		} catch (SQLException e) {
			e.getSQLState();
			e.printStackTrace();
		}
		return;
	}

	public void deleteEmployee(long empId) {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Password: ");
		String password = scanner.nextLine();

		try {
			String fetchUserDetailQuery = "SELECT * FROM employee WHERE id = ? AND password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(fetchUserDetailQuery);
			preparedStatement.setLong(1, empId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				System.out.print("Do you want to Delete User Profile (y/n): ");
				char choice = scanner.next().charAt(0);

				if (choice == 'y' || choice == 'Y') {
					String deleteUserQuery = "DELETE FROM employee where id = ? AND password = ?";
					PreparedStatement delete_user_pstm = connection.prepareStatement(deleteUserQuery);
					delete_user_pstm.setLong(1, empId);
					delete_user_pstm.setString(2, password);
					int deleteUserStatus = delete_user_pstm.executeUpdate();
					if (deleteUserStatus == 1) {
						System.out.println("\nEmployee Deleted Successfully !!\nPlease Enter 4 to register !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					} else {
						System.out.println("\nFailed to Delete Employee !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					}
				} else {
					System.out.println("\nOperation Canceled !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
			} else {
				System.out.println("\nIncorrect Password !!");
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void changeLoginPassword(long empId) {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Current Password: ");
		String old_password = scanner.nextLine();

		try {
			String fetchUserDetailQuery = "SELECT password FROM employee WHERE id = ? AND password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(fetchUserDetailQuery);
			preparedStatement.setLong(1, empId);
			preparedStatement.setString(2, old_password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				System.out.print("Enter New Password: ");
				String new_password = scanner.nextLine();

				String changePinQuery = "Update employee SET password = ? where id = ? AND password = ?";
				PreparedStatement change_pin_pstm = connection.prepareStatement(changePinQuery);
				change_pin_pstm.setString(1, new_password);
				change_pin_pstm.setLong(2, empId);
				change_pin_pstm.setString(3, old_password);
				int changePinStatus = change_pin_pstm.executeUpdate();
				if (changePinStatus == 1) {
					System.out.println("\nPassword Changed Successfully !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				} else {
					System.out.println("\nFailed to Change Password !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
			} else {
				System.out.println("\nIncorrect Current Password !!");
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
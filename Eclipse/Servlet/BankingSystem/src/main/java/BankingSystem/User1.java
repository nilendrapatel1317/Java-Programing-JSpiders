package BankingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User1 {
	private Connection connection;
	private Scanner scanner;

	public User1(Connection connection, Scanner scanner) {
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
		if (user_exist(email)) {
			System.out.println("\nUser Already Exists for this Email Address !!");
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
			return;
		}
		String register_query = "INSERT INTO users (name, email, password) VALUES(?, ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(register_query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
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

	public long login() {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();
		email = email.toLowerCase();
		System.out.print("Enter Password: ");
		String password = scanner.nextLine();
		String login_query = "SELECT * FROM users WHERE email = ? AND password = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(login_query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getLong("id");
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private boolean user_exist(String email) {
		String query = "SELECT * FROM users WHERE email = ?";
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

	public void user_profile(long userId) {
		scanner.nextLine();

		try {

			String userProfileQuery = "SELECT * FROM users WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(userProfileQuery);
			preparedStatement.setLong(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String city = resultSet.getString("city");
				long phone = resultSet.getLong("phone");
				String email = resultSet.getString("email");

				System.out.println("\nUser Profile: ");
				System.out.println(
						"+----------+------------------+--------+----------------+--------------+----------------------------+");
				System.out.println(
						"| ID       | Name             | Age    | City           | Phone        | Email                      |");
				System.out.println(
						"+----------+------------------+--------+----------------+--------------+----------------------------+");
				System.out.printf("| %-8s | %-16s | %-6s | %-14s | %-12s | %-26s |\n", id, name, age, city, phone,
						email);
				System.out.println(
						"+----------+------------------+--------+----------------+--------------+----------------------------+");

			} else {
				System.out.println("\nInvalid Pin !!");
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void user_profile(long userId, long account_number) {
		try {
			String userProfileQuery = "SELECT * FROM users Join accounts on users.id = accounts.user_id where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(userProfileQuery);
			preparedStatement.setLong(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String city = resultSet.getString("city");
				long phone = resultSet.getLong("phone");
				String email = resultSet.getString("email");
				long user_account_number = resultSet.getLong("account_number");

				System.out.println("\nUser Profile: ");
				System.out.println(
						"+----------+------------------+--------+----------------+--------------+----------------------------+----------------+");
				System.out.println(
						"| ID       | Name             | Age    | City           | Phone        | Email                      | Account Number |");
				System.out.println(
						"+----------+------------------+--------+----------------+--------------+----------------------------+----------------+");
				System.out.printf("| %-8s | %-16s | %-6s | %-14s | %-12s | %-26s | %-14s |\n", id, name, age, city,
						phone, email, user_account_number);
				System.out.println(
						"+----------+------------------+--------+----------------+--------------+----------------------------+----------------+");

			} else {
				System.out.println("\nInvalid Pin !!");
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUserDetails(long userId, long account_number, int choice) {
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		try {
			switch (choice) {
			case 1:
				scanner.nextLine();
				System.out.print("Enter Name: ");
				String name = scanner.nextLine();
				if(name.trim().length()>0) {
					String nameQuery = "UPDATE users SET name = ? WHERE id = ?";
					PreparedStatement name_pstm = connection.prepareStatement(nameQuery);
					name_pstm.setString(1, name);
					name_pstm.setLong(2, userId);
					if (name_pstm.executeUpdate() > 0) {
						System.out.println("\nUser Name Updated Successfully !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					} else {
						System.out.println("\nUpdation Failed !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					}
				}
				else {
					System.out.println("\nUpdation Failed !! Name can not be empty !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
				break;
			case 2:
				scanner.nextLine();
				System.out.print("Enter Age: ");
				int age = scanner.nextInt();
				if(age >= 10) {
					String ageQuery = "UPDATE users SET age = ? WHERE id = ?";
					PreparedStatement age_pstm = connection.prepareStatement(ageQuery);
					age_pstm.setInt(1, age);
					age_pstm.setLong(2, userId);
					if (age_pstm.executeUpdate() > 0) {
						System.out.println("\nUser Age Updated Successfully !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					} else {
						System.out.println("\nUpdation Failed !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					}
				}
				else {
					System.out.println("\nUpdation Failed !! Age must greater than equal to 10 !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
				break;
			case 3:
				scanner.nextLine();
				System.out.print("Enter City: ");
				String city = scanner.nextLine();
				if(city.trim().length() >= 3) {
					String cityQuery = "UPDATE users SET city = ? WHERE id = ?";
					PreparedStatement city_pstm = connection.prepareStatement(cityQuery);
					city_pstm.setString(1, city);
					city_pstm.setLong(2, userId);
					if (city_pstm.executeUpdate() > 0) {
						System.out.println("\nUser City Updated Successfully !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					} else {
						System.out.println("\nUpdation Failed !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					}
				}
				else {
					System.out.println("\nUpdation Failed !! City name too short !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
				break;
			case 4:
				scanner.nextLine();
				System.out.print("Enter Phone: ");
				long phone = scanner.nextLong();
				if(String.valueOf(phone).length() == 10) {
					String phoneQuery = "UPDATE users SET phone = ? WHERE id = ?";
					PreparedStatement phone_pstm = connection.prepareStatement(phoneQuery);
					phone_pstm.setLong(1, phone);
					phone_pstm.setLong(2, userId);
					if (phone_pstm.executeUpdate() > 0) {
						System.out.println("\nUser Phone Number Updated Successfully !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					} else {
						System.out.println("\nUpdation Failed !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					}
				}
				else {
					System.out.println("\nUpdation Failed !! Phone number must be 10 digits !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
				break;
			}

		} catch (SQLException e) {
			e.getSQLState();
			e.printStackTrace();
		}
	}

	public void changeLoginPassword(long userId) {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Current Password: ");
		String old_password = scanner.nextLine();

		try {
			String fetchUserDetailQuery = "SELECT password FROM users WHERE id = ? AND password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(fetchUserDetailQuery);
			preparedStatement.setLong(1, userId);
			preparedStatement.setString(2, old_password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				System.out.print("Enter New Password: ");
				String new_password = scanner.nextLine();

				String changePinQuery = "Update users SET password = ? where id = ? AND password = ?";
				PreparedStatement change_pin_pstm = connection.prepareStatement(changePinQuery);
				change_pin_pstm.setString(1, new_password);
				change_pin_pstm.setLong(2, userId);
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
	
	public void deleteUser(long userId) {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Password: ");
		String password = scanner.nextLine();

		try {
			String fetchUserDetailQuery = "SELECT * FROM users WHERE id = ? AND password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(fetchUserDetailQuery);
			preparedStatement.setLong(1, userId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				System.out.print("Do you want to Delete User Profile (y/n): ");
				char choice = scanner.next().charAt(0);

				if(choice =='y' || choice == 'Y') {
					String deleteUserQuery = "DELETE FROM users where id = ? AND password = ?";
					PreparedStatement delete_user_pstm = connection.prepareStatement(deleteUserQuery);
					delete_user_pstm.setLong(1, userId);
					delete_user_pstm.setString(2, password);
					int deleteUserStatus = delete_user_pstm.executeUpdate();
					if (deleteUserStatus == 1) {
						System.out.println("\nUser Deleted Successfully !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					} else {
						System.out.println("\nFailed to Delete User !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					}
				}
				else {
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

}
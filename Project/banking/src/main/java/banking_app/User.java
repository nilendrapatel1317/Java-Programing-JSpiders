package banking_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
	private Connection connection;
	private Scanner scanner;

	public User(Connection connection, Scanner scanner) {
		this.connection = connection;
		this.scanner = scanner;
	}

	public void register() {
		scanner.nextLine();
		System.out.println("\n----------------------------------------");
		System.out.print("Enter Full Name: ");
		String full_name = scanner.nextLine();
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();
		System.out.print("Enter Password: ");
		String password = scanner.nextLine();
		if (user_exist(email)) {
			System.out.println("\nUser Already Exists for this Email Address !!");
			return;
		}
		String register_query = "INSERT INTO bank_user(full_name, email, password) VALUES(?, ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(register_query);
			preparedStatement.setString(1, full_name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("\nRegistration Successfull !!");
				System.out.println("----------------------------------------");
			} else {
				System.out.println("\nRegistration Failed !!");
				System.out.println("----------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String login() {
		scanner.nextLine();
		System.out.println("\n----------------------------------------");
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();
		System.out.print("Enter Password: ");
		String password = scanner.nextLine();
		String login_query = "SELECT * FROM bank_user WHERE email = ? AND password = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(login_query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return email;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean user_exist(String email) {
		String query = "SELECT * FROM bank_user WHERE email = ?";
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

	public ResultSet current_user(String email) {
		try {
			String currentUserQuery = "SELECT * FROM bank_user WHERE email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(currentUserQuery);
			preparedStatement.setString(1, email);
			return preparedStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void user_profile(String email) {
		scanner.nextLine();
		System.out.println("\n----------------------------------------");
		try {
			String userProfileQuery = "SELECT * FROM bank_user WHERE email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(userProfileQuery);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				String user_full_name = resultSet.getString("full_name");
				String user_email = resultSet.getString("email");

				System.out.println("\n User Profile: ");
				System.out.println("+------------------+------------------------------+");
				System.out.println("| Full Name        | Email                        |");
				System.out.println("+------------------+------------------------------+");
				System.out.printf("| %-16s | %-28s |\n", user_full_name, user_email);
				System.out.println("+------------------+------------------------------+");

			} else {
				System.out.println("\nInvalid Pin !!");
				System.out.println("----------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUserDetails(long account_number) {
		System.out.println("========================================");
		System.out.println("|         Work is going on...         |");
		System.out.println("========================================");
	}
	public void changeLoginPassword(long account_number) {
		System.out.println("========================================");
		System.out.println("|         Work is going on...         |");
		System.out.println("========================================");
	}
	
}
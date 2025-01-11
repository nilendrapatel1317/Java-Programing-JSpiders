package banking_app;

import java.sql.*;
import java.util.Scanner;

public class Accounts {
	private Connection connection;
	private Scanner scanner;

	public Accounts(Connection connection, Scanner scanner) {
		this.connection = connection;
		this.scanner = scanner;

	}

	public long openAccount(String email, User user) throws SQLException {
		ResultSet rs = user.current_user(email);

		if (!accountExist(email) && rs.next()) {
			String user_full_name = rs.getString("full_name");
			System.out.println("\n----------------------------------------");
			String open_account_query = "INSERT INTO Accounts(account_number, full_name, email, balance, security_pin) VALUES(?, ?, ?, ?, ?)";
			scanner.nextLine();
			System.out.print("Enter Initial Amount: ");
			double balance = scanner.nextDouble();
			scanner.nextLine();
			System.out.print("Enter Security Pin: ");
			String security_pin = scanner.nextLine();
			try {
				long account_number = generateAccountNumber();
				PreparedStatement preparedStatement = connection.prepareStatement(open_account_query);
				preparedStatement.setLong(1, account_number);
				preparedStatement.setString(2, user_full_name);
				preparedStatement.setString(3, email);
				preparedStatement.setDouble(4, balance);
				preparedStatement.setString(5, security_pin);
				int rowsAffected = preparedStatement.executeUpdate();
				if (rowsAffected > 0) {
					return account_number;
				} else {
					throw new RuntimeException("\nAccount Creation failed !!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		throw new RuntimeException("\nAccount Already Exist !!");
	}

	public long getAccountNumber(String email) {
		String query = "SELECT account_number from Accounts WHERE email = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getLong("account_number");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("\nAccount Number Doesn't Exist !!");
	}

	private long generateAccountNumber() {
		try {
			Statement statement = connection.createStatement();
			String fetchAccountQuery = "SELECT account_number from Accounts ORDER BY account_number DESC LIMIT 1";
			ResultSet resultSet = statement.executeQuery(fetchAccountQuery);
			if (resultSet.next()) {
				long last_account_number = resultSet.getLong("account_number");
				return last_account_number + 1;
			} else {
				return 10000100;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 10000100;
	}

	public boolean accountExist(String email) {
		String query = "SELECT account_number from Accounts WHERE email = ?";
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
}
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

	public long openAccount(long userId) throws SQLException {

		if (!accountExist(userId)) {
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
			String open_account_query = "INSERT INTO Accounts (account_number, balance, security_pin , user_id) VALUES(?, ?, ?, ?)";
			scanner.nextLine();
			System.out.print("Enter Initial Amount: ");
			double balance = scanner.nextDouble();
			scanner.nextLine();
			System.out.print("Enter Security Pin: ");
			int security_pin = scanner.nextInt();
			try {
				long account_number = generateAccountNumber();
				PreparedStatement preparedStatement = connection.prepareStatement(open_account_query);
				preparedStatement.setLong(1, account_number);
				preparedStatement.setDouble(2, balance);
				preparedStatement.setInt(3, security_pin);
				preparedStatement.setLong(4, userId);

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

	public long getAccountNumber(long userId) {
		String query = "SELECT account_number from Accounts WHERE user_id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
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
				return 26130100;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 26130100;
	}

	public boolean accountExist(long userId) {
		String query = "SELECT account_number from Accounts WHERE user_id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
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
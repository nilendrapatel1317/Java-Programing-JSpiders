package BankingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankingServices {
	static Connection connection;

	static {
		String url = "jdbc:postgresql://localhost:5432/banking_system";
		String user = "postgres";
		String password = "123";

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Error initializing database connection: " + e.getMessage());
		}
	}

	public static int transferMoney(Account account, long receiver_account_number, double amount) {
		try {

			if (amount <= 0) {
				return -1; 
			}

			if (amount > account.getBalance()) {
				return -2; 
			}

			if (receiver_account_number <= 0) {
				return -3;
			}
			
			if(receiver_account_number == account.getAccountNumber()) {
				return -6;
			}
			String fetch_recevier_account = "SELECT * FROM Accounts WHERE account_number = ? ";
			PreparedStatement fetchRecevierAccountPreparedStatement = connection.prepareStatement(fetch_recevier_account);
			fetchRecevierAccountPreparedStatement.setLong(1, receiver_account_number);
			ResultSet rs = fetchRecevierAccountPreparedStatement.executeQuery();
			if(rs.next()) {
				String debit_query = "UPDATE Accounts SET balance = balance - ? WHERE account_number = ?";
				String credit_query = "UPDATE Accounts SET balance = balance + ? WHERE account_number = ?";

				// Debit and Credit prepared Statements
				PreparedStatement creditPreparedStatement = connection.prepareStatement(credit_query);
				PreparedStatement debitPreparedStatement = connection.prepareStatement(debit_query);

				// Set Values for debit and credit prepared statements
				debitPreparedStatement.setDouble(1, amount);
				debitPreparedStatement.setLong(2, account.getAccountNumber());
				creditPreparedStatement.setDouble(1, amount);
				creditPreparedStatement.setLong(2, receiver_account_number);

				int rowsAffected1 = debitPreparedStatement.executeUpdate();
				int rowsAffected2 = creditPreparedStatement.executeUpdate();

				if (rowsAffected1 > 0 && rowsAffected2 > 0) {
					account.setBalance(account.getBalance()-amount);
					return 1;
				} else {
					return 0;
				}
			}else {
				return -4;
			}

			

		} catch (SQLException e) {
			e.printStackTrace();
			return -5; // SQL error
		}
	}

	public static int debitMoney(Account account, double amount) {
		try {
			// Retrieve the current balance
			double current_balance = account.getBalance();

			// Check if the debit amount is valid
			if (amount <= 0) {
				return -2; // Invalid debit amount
			}

			// Ensure sufficient balance
			if (amount > current_balance) {
				return -1; // Insufficient balance
			}

			// Prepare the SQL query to update the balance
			String debit_query = "UPDATE Accounts SET balance = balance - ? WHERE account_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(debit_query);
			preparedStatement.setDouble(1, amount);
			preparedStatement.setLong(2, account.getAccountNumber());

			// Execute the query
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				// Update was successful
				account.setBalance(current_balance - amount); // Update the account object
				return 1; // Success
			} else {
				// No rows were updated (possibly invalid account number)
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -3; // SQL error
		}
	}

	public static int creditMoney(Account account, double amount) {
		try {
			// Retrieve the current balance
			double current_balance = account.getBalance();

			// Check if the debit amount is valid
			if (amount <= 0) {
				return -1; // Invalid debit amount
			}

			// Prepare the SQL query to update the balance
			String debit_query = "UPDATE Accounts SET balance = balance + ? WHERE account_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(debit_query);
			preparedStatement.setDouble(1, amount);
			preparedStatement.setLong(2, account.getAccountNumber());

			// Execute the query
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				// Update was successful
				account.setBalance(current_balance + amount); // Update the account object
				return 1; // Success
			} else {
				// No rows were updated (possibly invalid account number)
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -2; // SQL error
		}
	}

	public static boolean changeSecurityPin(Account account, int securityPin) {
		String query = "UPDATE Accounts SET security_pin = ? WHERE account_number = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, securityPin);
			preparedStatement.setLong(2, account.getAccountNumber());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				account.setSecurity_pin(securityPin);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void secureAccount(Account account, boolean flag) {
		String query = "UPDATE Accounts SET acc_lock = ? WHERE account_number = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setBoolean(1, flag);
			preparedStatement.setLong(2, account.getAccountNumber());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				account.setAcc_lock(flag);
				return;
			} else {
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	public static int register(User user) {
		if (userExist(user.getEmail())) {
			System.out.println("User already exists for this email address.");
			return 0;
		}

		String registerQuery = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(registerQuery)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());

			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows > 0) {
				String fetchQuery = "SELECT * FROM users WHERE email = ? AND password = ? ";
				try (PreparedStatement fetchPS = connection.prepareStatement(fetchQuery)) {
					fetchPS.setString(1, user.getEmail());
					fetchPS.setString(2, user.getPassword());

					ResultSet rs = fetchPS.executeQuery();
					if (rs.next()) {
						user.setId(rs.getLong("id"));
						user.setAge(rs.getInt("age"));
						user.setCity(rs.getString("city"));
						user.setPhone(rs.getLong("phone"));
						user.setAccountNumber(rs.getLong("account_number"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return affectedRows;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private static boolean userExist(String email) {
		String query = "SELECT * FROM users WHERE email = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, email);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				return resultSet.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean login(User user) {
		String loginQuery = "SELECT * FROM users WHERE email = ? AND password = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(loginQuery)) {
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setCity(rs.getString("city"));
				user.setPhone(rs.getLong("phone"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setAccountNumber(rs.getLong("account_number"));
				user.setGender(rs.getString("gender"));
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean editUser(User user) {
		String updateQuery = "UPDATE users SET name = ?, age = ?, gender = ?, city = ?, phone = ? WHERE email = ? AND password = ?";
		String fetchQuery = "SELECT * FROM users WHERE email = ? AND password = ?";

		try (PreparedStatement ps1 = connection.prepareStatement(updateQuery)) {
			// Set parameters for the update query
			ps1.setString(1, user.getName());
			ps1.setInt(2, user.getAge());
			ps1.setString(3, user.getGender());
			ps1.setString(4, user.getCity());
			ps1.setLong(5, user.getPhone());
			ps1.setString(6, user.getEmail());
			ps1.setString(7, user.getPassword());

			int rowsUpdated = ps1.executeUpdate();
			if (rowsUpdated > 0) {
				// Fetch the updated user details
				try (PreparedStatement ps2 = connection.prepareStatement(fetchQuery)) {
					ps2.setString(1, user.getEmail());
					ps2.setString(2, user.getPassword());

					ResultSet rs = ps2.executeQuery();
					if (rs.next()) {
						user.setId(rs.getLong("id"));
						user.setName(rs.getString("name"));
						user.setAge(rs.getInt("age"));
						user.setGender(rs.getString("gender"));
						user.setCity(rs.getString("city"));
						user.setPhone(rs.getLong("phone"));
						user.setAccountNumber(rs.getLong("account_number"));
					}
				}
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static long openAccount(User user, Account account) {

		if (!accountExist(user.getId())) {
			String open_account_query = "INSERT INTO Accounts (account_number, balance, security_pin , user_id) VALUES(?, ?, ?, ?)";
			double balance = account.getBalance();
			int security_pin = account.getSecurity_pin();
			try {
				long account_number = generateAccountNumber();
				PreparedStatement preparedStatement = connection.prepareStatement(open_account_query);
				preparedStatement.setLong(1, account_number);
				preparedStatement.setDouble(2, balance);
				preparedStatement.setInt(3, security_pin);
				preparedStatement.setLong(4, user.getId());

				int rowsAffected = preparedStatement.executeUpdate();
				if (rowsAffected > 0) {
					user.setAccountNumber(account_number);
					account.setAccountNumber(account_number);
					account.setBalance(balance);
					account.setSecurity_pin(security_pin);
					return account_number;

				} else {
					System.out.println("Account Creation failed !!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Account Already Exist !!");
		return 0;
	}

	public static boolean accountExist(long userId) {
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

	private static long generateAccountNumber() {
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

	public static boolean updatAccountNumber(User user, Account account) {
		String query = "UPDATE users SET account_number = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, account.getAccountNumber());
			preparedStatement.setLong(2, user.getId());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				System.out.println("i=" + i);
				return true;
			} else {
				System.out.println("i=" + i);
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean changePassword(User user, String newPassword) {
		String query = "UPDATE users SET password = ? WHERE email = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, user.getEmail());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				user.setPassword(newPassword);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean verifySecurityPin(long accountNumber, int securityPin) {
		String verifyQuery = "SELECT * FROM Accounts WHERE account_number = ? AND security_pin = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(verifyQuery);
			preparedStatement.setLong(1, accountNumber);
			preparedStatement.setInt(2, securityPin);
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

	public static boolean userAccountDetails(Account account, long accountNumber) {
		String query = "SELECT * FROM Accounts WHERE account_number = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setLong(1, accountNumber);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					account.setAccountNumber(resultSet.getLong("account_number"));
					account.setBalance(resultSet.getDouble("balance"));
					account.setSecurity_pin(resultSet.getInt("security_pin"));
					account.setAcc_lock(resultSet.getBoolean("acc_lock"));
					account.setUser_id(resultSet.getInt("user_id"));
				}
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

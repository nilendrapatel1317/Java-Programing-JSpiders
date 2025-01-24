package BankingSystem;

//import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class AccountManager {
	private Connection connection;
	private Scanner scanner;

	AccountManager(Connection connection, Scanner scanner) {
		this.connection = connection;
		this.scanner = scanner;
	}

	public boolean acc_lock_status(long account_number) throws SQLException {
		String acc_lockQuery = "SELECT acc_lock FROM accounts WHERE account_number = ?";
		PreparedStatement accLock_pstm = connection.prepareStatement(acc_lockQuery);
		accLock_pstm.setLong(1, account_number);
		ResultSet accLockStatus = accLock_pstm.executeQuery();
		if (accLockStatus.next()) {
			return accLockStatus.getBoolean("acc_lock");

		}
		return false;

	}

	public void userAccountDetails(long account_number) {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Security Pin: ");
		int security_pin = scanner.nextInt();
		try {
			String userAcountQuery = "SELECT * FROM Accounts WHERE account_number = ? AND security_pin = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(userAcountQuery);
			preparedStatement.setLong(1, account_number);
			preparedStatement.setInt(2, security_pin);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				long user_account_number = resultSet.getLong("account_number");
				double user_balance = resultSet.getDouble("balance");
				Boolean acc_lock = resultSet.getBoolean("acc_lock");
				int user_id = resultSet.getInt("user_id");

				System.out.println("\n User Account Details: ");
				System.out.println("+----------+----------------+------------+-------------+");
				System.out.println("| User ID  | Account Number | Balance    | Lock Status |");
				System.out.println("+----------+----------------+------------+-------------+");
				System.out.printf("| %-8s | %-14s | %-10s | %-11s |\n", user_id, user_account_number, user_balance,
						acc_lock);
				System.out.println("+----------+----------------+------------+-------------+");

			} else {
				System.out.println("\nInvalid Pin !!");
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void debitMoney(long account_number) throws SQLException {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Amount: ");
		double amount = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Enter Security Pin: ");
		int security_pin = scanner.nextInt();
		try {
			connection.setAutoCommit(false);
			if (account_number != 0) {
				String userDetailQuery = "SELECT * FROM Accounts WHERE account_number = ? and security_pin = ? ";
				PreparedStatement preparedStatement = connection.prepareStatement(userDetailQuery);
				preparedStatement.setLong(1, account_number);
				preparedStatement.setInt(2, security_pin);
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					double current_balance = resultSet.getDouble("balance");
					if (amount <= current_balance) {
						String debit_query = "UPDATE Accounts SET balance = balance - ? WHERE account_number = ?";
						PreparedStatement preparedStatement1 = connection.prepareStatement(debit_query);
						preparedStatement1.setDouble(1, amount);
						preparedStatement1.setLong(2, account_number);
						int rowsAffected = preparedStatement1.executeUpdate();
						if (rowsAffected > 0) {
							System.out.println("\nRs." + amount + " debited Successfully !!");
							System.out.println("---------------------------------------------------------------------------------------------------------------------");
							connection.commit();
							connection.setAutoCommit(true);
							return;
						} else {
							System.out.println("\nTransaction Failed !!");
							System.out.println("---------------------------------------------------------------------------------------------------------------------");
							connection.rollback();
							connection.setAutoCommit(true);
						}
					} else {
						System.out.println("\nInsufficient Balance !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					}
				} else {
					System.out.println("\nInvalid Pin !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.setAutoCommit(true);
	}

	public void creditMoney(long account_number) throws SQLException {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Amount: ");
		double amount = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Enter Security Pin: ");
		int security_pin = scanner.nextInt();

		try {
			connection.setAutoCommit(false);
			if (account_number != 0) {
				String userDetailQuery = "SELECT * FROM Accounts WHERE account_number = ? and security_pin = ? ";
				PreparedStatement preparedStatement = connection.prepareStatement(userDetailQuery);
				preparedStatement.setLong(1, account_number);
				preparedStatement.setInt(2, security_pin);
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					String credit_query = "UPDATE Accounts SET balance = balance + ? WHERE account_number = ?";
					PreparedStatement preparedStatement1 = connection.prepareStatement(credit_query);
					preparedStatement1.setDouble(1, amount);
					preparedStatement1.setLong(2, account_number);
					int rowsAffected = preparedStatement1.executeUpdate();
					if (rowsAffected > 0) {
						System.out.println("\nRs." + amount + " credited Successfully !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
						connection.commit();
						connection.setAutoCommit(true);
						return;
					} else {
						System.out.println("\nTransaction Failed !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
						connection.rollback();
						connection.setAutoCommit(true);
					}
				} else {
					System.out.println("\nInvalid Security Pin !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.setAutoCommit(true);
	}

	public void transferMoney(long sender_account_number) throws SQLException {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Receiver Account Number: ");
		long receiver_account_number = scanner.nextLong();
		System.out.print("Enter Amount: ");
		double amount = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Enter Security Pin: ");
		int security_pin = scanner.nextInt();
		try {
			connection.setAutoCommit(false);
			if (sender_account_number != 0 && receiver_account_number != 0) {
				String senderUserDetailQuery = "SELECT * FROM Accounts WHERE account_number = ? AND security_pin = ? ";
				PreparedStatement preparedStatement = connection.prepareStatement(senderUserDetailQuery);
				preparedStatement.setLong(1, sender_account_number);
				preparedStatement.setInt(2, security_pin);
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					double current_balance = resultSet.getDouble("balance");
					if (receiver_account_number != sender_account_number) {
						if (amount <= current_balance) {

							// Write debit and credit queries
							String debit_query = "UPDATE Accounts SET balance = balance - ? WHERE account_number = ?";
							String credit_query = "UPDATE Accounts SET balance = balance + ? WHERE account_number = ?";

							// Debit and Credit prepared Statements
							PreparedStatement creditPreparedStatement = connection.prepareStatement(credit_query);
							PreparedStatement debitPreparedStatement = connection.prepareStatement(debit_query);

							// Set Values for debit and credit prepared statements
							creditPreparedStatement.setDouble(1, amount);
							creditPreparedStatement.setLong(2, receiver_account_number);
							debitPreparedStatement.setDouble(1, amount);
							debitPreparedStatement.setLong(2, sender_account_number);
							int rowsAffected1 = debitPreparedStatement.executeUpdate();
							int rowsAffected2 = creditPreparedStatement.executeUpdate();
							if (rowsAffected1 > 0 && rowsAffected2 > 0) {
								System.out.println("\nRs." + amount + " Transferred Successfully !!");
								System.out.println("---------------------------------------------------------------------------------------------------------------------");
								connection.commit();
								connection.setAutoCommit(true);
								return;
							} else {
								System.out.println("\nTransaction Failed !!");
								System.out.println("---------------------------------------------------------------------------------------------------------------------");
								connection.rollback();
								connection.setAutoCommit(true);
							}
						} else {
							System.out.println("\nInsufficient Balance !!");
							System.out.println("---------------------------------------------------------------------------------------------------------------------");
						}
					} else {
						System.out.println("\nSelf Transfer is not Allowed !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					}
				} else {
					System.out.println("\nInvalid Security Pin !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
			} else {
				System.out.println("\nInvalid account number !!");
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.setAutoCommit(true);
	}

	public void getBalance(long account_number) {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Security Pin: ");
		int security_pin = scanner.nextInt();
		try {
			String balanceQuery = "SELECT balance FROM Accounts WHERE account_number = ? AND security_pin = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(balanceQuery);
			preparedStatement.setLong(1, account_number);
			preparedStatement.setInt(2, security_pin);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				double balance = resultSet.getDouble("balance");
				System.out.println("\nBalance: Rs " + balance);
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
			} else {
				System.out.println("\nInvalid Pin !!");
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void change_pin(long account_number) {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Current Security Pin: ");
		int security_pin = scanner.nextInt();

		try {
			String fetchUserDetailQuery = "SELECT security_pin FROM Accounts WHERE account_number = ? AND security_pin = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(fetchUserDetailQuery);
			preparedStatement.setLong(1, account_number);
			preparedStatement.setInt(2, security_pin);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				System.out.print("Enter New Security Pin: ");
				int new_security_pin = scanner.nextInt();

				String changePinQuery = "Update Accounts set security_pin = ? where account_number = ? AND security_pin = ?";
				PreparedStatement change_pin_pstm = connection.prepareStatement(changePinQuery);
				change_pin_pstm.setInt(1, new_security_pin);
				change_pin_pstm.setLong(2, account_number);
				change_pin_pstm.setInt(3, security_pin);
				int changePinStatus = change_pin_pstm.executeUpdate();
				if (changePinStatus == 1) {
					System.out.println("\nSecurity Pin Changed Successfully !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				} else {
					System.out.println("\nFailed to Change Pin !!");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
				}
			} else {
				System.out.println("\nInvalid Pin !!");
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void transaction_history(long account_number) {
		System.out.println("=====================================================================================================================");
		System.out.println("|         Work is going on...         |");
		System.out.println("=====================================================================================================================");
	}

	public void deleteAccount(long account_number) {
		System.out.println("=====================================================================================================================");
		System.out.println("|         Work is going on...         |");
		System.out.println("=====================================================================================================================");
	}

	public void accountLock(long account_number) {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Pin: ");
		int security_pin = scanner.nextInt();

		try {
			String fetchUserDetailQuery = "SELECT * FROM accounts WHERE account_number = ? AND security_pin = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(fetchUserDetailQuery);
			preparedStatement.setLong(1, account_number);
			preparedStatement.setInt(2, security_pin);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				System.out.print("Do you want to Lock Your Account (y/n): ");
				char choice = scanner.next().charAt(0);

				if (choice == 'y' || choice == 'Y') {
					String lockAccountQuery = "UPDATE accounts SET acc_lock = ? where account_number = ? AND security_pin = ?";
					PreparedStatement delete_user_pstm = connection.prepareStatement(lockAccountQuery);
					delete_user_pstm.setBoolean(1, true);
					delete_user_pstm.setLong(2, account_number);
					delete_user_pstm.setInt(3, security_pin);
					int accLockStatus = delete_user_pstm.executeUpdate();
					if (accLockStatus == 1) {
						System.out.println("\nYour Account Locked !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					} else {
						System.out.println("\nFailed to lock your account !!");
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

	public void accountUnlock(long account_number) {
		scanner.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Pin: ");
		int security_pin = scanner.nextInt();

		try {
			String fetchUserDetailQuery = "SELECT * FROM accounts WHERE account_number = ? AND security_pin = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(fetchUserDetailQuery);
			preparedStatement.setLong(1, account_number);
			preparedStatement.setInt(2, security_pin);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				System.out.print("Do you want to Lock Your Account (y/n): ");
				char choice = scanner.next().charAt(0);

				if (choice == 'y' || choice == 'Y') {
					String lockAccountQuery = "UPDATE accounts SET acc_lock = ? where account_number = ? AND security_pin = ?";
					PreparedStatement delete_user_pstm = connection.prepareStatement(lockAccountQuery);
					delete_user_pstm.setBoolean(1, false);
					delete_user_pstm.setLong(2, account_number);
					delete_user_pstm.setInt(3, security_pin);
					int accLockStatus = delete_user_pstm.executeUpdate();
					if (accLockStatus == 1) {
						System.out.println("\nYour Account Unlocked !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					} else {
						System.out.println("\nFailed to unlock your account !!");
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
}

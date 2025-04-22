package banking_app;

import java.sql.*;
import java.util.Scanner;

public class BankingApp {
	private static final String url = "jdbc:postgresql://localhost:5432/banking_system?user=postgres&password=123";

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url);
			Scanner scanner = new Scanner(System.in);
			User user = new User(connection, scanner);
			Accounts accounts = new Accounts(connection, scanner);
			AccountManager accountManager = new AccountManager(connection, scanner);

			long userId;
			long accountNumber;

			while (true) {
				System.out.println("\n*** WELCOME TO BANKING SYSTEM ***");
				System.out.println();
				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Exit");
				System.out.print("\nEnter your choice: ");
				int choice1 = scanner.nextInt();
				switch (choice1) {
				case 1:
					user.register();
					break;
				case 2:
					userId = user.login();
					if (userId != 0) {
						System.out.println("\nUser Logged In !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
						if (!accounts.accountExist(userId)) {
							System.out.println();
							System.out.println("1. Open a new Bank Account");
							System.out.println("2. Log Out");
							System.out.print("\nEnter your choice: ");
							int subChoice = scanner.nextInt();
							if (subChoice == 1) {
								accountNumber = accounts.openAccount(userId);
								System.out.println("\nAccount Created Successfully !!");
								System.out.println("\nYour Account Number is: " + accountNumber);
								System.out.println("---------------------------------------------------------------------------------------------------------------------");
							} else {
								break;
							}

						}
						accountNumber = accounts.getAccountNumber(userId);
						int choice2 = 0;
						while (choice2 != 4) {
							System.out.println();
							System.out.println("1. Profile Feature");
							System.out.println("2. Banking Feature");
							System.out.println("3. Security");
							System.out.println("4. Log Out");
							System.out.print("\nEnter your choice: ");
							choice2 = scanner.nextInt();
							switch (choice2) {
							case 1:
								int choice3 = 0;
								while (choice3 != 3) {
									System.out.println();
									System.out.println("1. View User Details");
									System.out.println("2. Update User Details");
									System.out.println("3. Return Back");
									System.out.print("\nEnter your choice: ");
									choice3 = scanner.nextInt();
									switch (choice3) {
									case 1:
										user.user_profile(userId, accountNumber);
										break;
									case 2:
										int choice4 = 0;
										while (choice4 != 5) {
											System.out.println();
											System.out.println("1. Edit User Name");
											System.out.println("2. Edit User Age");
											System.out.println("3. Edit User City");
											System.out.println("4. Edit Phone Number");
											System.out.println("5. Return Back");
											System.out.print("\nEnter your choice: ");
											choice4 = scanner.nextInt();
											switch (choice4) {
											case 1:
												user.updateUserDetails(userId, accountNumber, choice4);
												break;
											case 2:
												user.updateUserDetails(userId, accountNumber, choice4);
												break;
											case 3:
												user.updateUserDetails(userId, accountNumber, choice4);
												break;
											case 4:
												user.updateUserDetails(userId, accountNumber, choice4);
												break;
											case 5:
												break;
											default:
												System.out.println("\nEnter Valid Choice !!");
												System.out.println("---------------------------------------------------------------------------------------------------------------------");
												break;
											}
										}
										break;
									case 3:
										break;
									default:
										System.out.println("\nEnter Valid Choice !!");
										System.out.println("---------------------------------------------------------------------------------------------------------------------");
										break;
									}
								}

								break;
							case 2:
								Boolean accLockStatus = accountManager.acc_lock_status(accountNumber);
								if (!accLockStatus) {
									int choice6 = 0;
									while (choice6 != 7) {
										System.out.println();
										System.out.println("1. Check Balance");
										System.out.println("2. View Account Details");
										System.out.println("3. Debit Money (Withdraw)");
										System.out.println("4. Credit Money (Deposit)");
										System.out.println("5. Transfer Money");
										System.out.println("6. Transaction History");
										System.out.println("7. Return Back");
										System.out.print("\nEnter your choice: ");
										choice6 = scanner.nextInt();
										switch (choice6) {
										case 1:
											accountManager.getBalance(accountNumber);
											break;
										case 2:
											accountManager.userAccountDetails(accountNumber);
											break;
										case 3:
											accountManager.debitMoney(accountNumber);
											break;
										case 4:
											accountManager.creditMoney(accountNumber);
											break;
										case 5:
											accountManager.transferMoney(accountNumber);
											break;
										case 6:
											accountManager.transaction_history(accountNumber);
											break;
										case 7:

											break;
										default:
											System.out.println("\nEnter Valid Choice !!");
											System.out.println("---------------------------------------------------------------------------------------------------------------------");
											break;
										}
									}
								} else {
									System.out.println("\nSORRY !! Your Account Is Locked !!");
									System.out.println("---------------------------------------------------------------------------------------------------------------------");
								}
								break;
							case 3:
								int choice5 = 0;
								while (choice5 != 5) {
									System.out.println();
									System.out.println("1. Change Login Password");
									System.out.println("2. Change Security Pin");
									System.out.println("3. Account Locking");
									System.out.println("4. Account Unlocking");
									System.out.println("5. Return Back");
									System.out.print("\nEnter your choice: ");
									choice5 = scanner.nextInt();
									switch (choice5) {
									case 1:
										user.changeLoginPassword(userId);
										break;
									case 2:
										accountManager.change_pin(accountNumber);
										break;
									case 3:
										accountManager.accountLock(accountNumber);
										break;
									case 4:
										accountManager.accountUnlock(accountNumber);
										break;
									case 5:
										break;
									default:
										System.out.println("\nEnter Valid Choice !!");
										System.out.println("---------------------------------------------------------------------------------------------------------------------");
										break;
									}
								}
								break;
							case 4:
								break;
							default:
								System.out.println("\nEnter Valid Choice !!");
								System.out.println("---------------------------------------------------------------------------------------------------------------------");
								break;
							}
						}

					} else {
						System.out.println("\nIncorrect Email or Password !!");
						System.out.println("---------------------------------------------------------------------------------------");
					}
				case 3:
					System.out.println("\n=====================================================================================================================");
					System.out.println("THANK YOU FOR USING BANKING SYSTEM !!!");
					System.out.println("Exiting System !!");
					System.out.println("=====================================================================================================================");
					return;
				default:
					System.out.println("\nEnter Valid Choice");
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
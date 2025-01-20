package Service;

import java.sql.*;
import java.util.Scanner;

import Driver.EmployeeDriver;

public class EmployeeService {
	private static final String url = "jdbc:postgresql://localhost:5432/employee_management_system?user=postgres&password=123";

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url);
			Scanner scanner = new Scanner(System.in);
			EmployeeDriver empDriver = new EmployeeDriver(connection, scanner);

			long empId;

			while (true) {
				System.out.println("\n*** WELCOME TO EMPLOYEE MANAGEMENT SYSTEM ***");
				System.out.println();
				System.out.println("1. Register Employee");
				System.out.println("2. Login Employee");
				System.out.println("3. Display All Employees");
				System.out.println("4. Exit Application");
				System.out.print("\nEnter your choice: ");
				int choice1 = scanner.nextInt();
				switch (choice1) {
				case 1:
					empDriver.register();
					break;
				case 2:
					empId = empDriver.login();
					if (empId != 0) {
						System.out.println("\nEmployee Logged In !!");
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
						int choice2 = 0;
						while (choice2 != 4) {
							System.out.println();
							System.out.println("1. View Employee Details");
							System.out.println("2. Update Employee Details");
							System.out.println("3. Delete Employee Details");
							System.out.println("4. Log Out");
							System.out.print("\nEnter your choice: ");
							choice2 = scanner.nextInt();
							switch (choice2) {
							case 1:
								empDriver.fetchEmployee(empId);
								break;
							case 2:
								int choice3 = 0;
								while (choice3 != 6) {
									System.out.println();
									System.out.println("1. Edit Emp Name");
									System.out.println("2. Edit Emp Age");
									System.out.println("3. Edit Emp Gender");
									System.out.println("4. Edit Emp Role");
									System.out.println("5. Change Login Password");
									System.out.println("6. Return Back");
									System.out.print("\nEnter your choice: ");
									choice3 = scanner.nextInt();
									switch (choice3) {
									case 1:
										empDriver.updateEmployeeDetails(empId, choice3);
										break;
									case 2:
										empDriver.updateEmployeeDetails(empId, choice3);
										break;
									case 3:
										empDriver.updateEmployeeDetails(empId, choice3);
										break;
									case 4:
										empDriver.updateEmployeeDetails(empId, choice3);
										break;
									case 5:
										empDriver.changeLoginPassword(empId);
										break;
									case 6:
										break;
									default:
										System.out.println("\nEnter Valid Choice !!");
										System.out.println("---------------------------------------------------------------------------------------------------------------------");
										break;
									}
								}
								break;
							case 3:
								empDriver.deleteEmployee(empId);
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
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
					}
					break;
				case 3:
					empDriver.allEmployees();
					break;
				case 4:
					System.out.println("\n===================================================================================================================");
					System.out.println("THANK YOU FOR USING EMPLOYEE MANAGEMENT SYSTEM !!!");
					System.out.println("Exiting System !!");
					System.out.println("===================================================================================================================");
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
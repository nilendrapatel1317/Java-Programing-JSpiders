package OOPs;

import java.util.Scanner;

public class ExtraxtYear {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your date of birth (DD-MM-YYYY): ");
		String dob = sc.nextLine();

		// Extracting the year
		String[] parts = dob.split("-");
		System.out.println("Year of Birth: " + parts[2]);

		sc.close();
	}
}

import java.util.Scanner;

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of units used
        System.out.print("Enter the number of units used: ");
        int units = scanner.nextInt();

        // Input whether the bill is paid on time
        System.out.print("Is the bill paid on time? (Enter 1 for 'YES'/ Enter 0 for 'NO'): ");
        int onTime = scanner.nextInt();

        // Calculate the bill based on units
        double bill = calculateBill(units);

        // Apply discount or fine
        if(onTime == 1 || onTime == 0){
			if (onTime == 1) {
				bill = bill - (bill * 0.05); // 5% discount for on-time payment
			} else {
				bill = bill + (bill * 0.10); // 10% fine for late payment
			}

			// Output the final bill
			System.out.printf("The total bill is: %.2f\n", bill);
		}
		
		else{
			System.out.println("Enter correct details");
			ElectricityBill.main(null);
		}
    }

    public static double calculateBill(int units) {
        double bill = 0;
        if (units <= 20) {
            bill = 0; // Electricity is free for up to 20 units
        } else if (units <= 70) {
            bill = (units - 20) * 2; // 2 rs/unit for the next 50 units
        } else if (units <= 100) {
            bill = 50 * 2 + (units - 70) * 4; // 4 rs/unit for the next 30 units
        } else if (units <= 180) {
            bill = 50 * 2 + 30 * 4 + (units - 100) * 7; // 7 rs/unit for the next 80 units
        } else {
            bill = 50 * 2 + 30 * 4 + 80 * 7 + (units - 180) * 15; // 15 rs/unit for anything above 180 units
        }
        return bill;
    }
}

package MultiThreading;

public class Account_Driver {
	public static void main(String[] args) {
		Account a1 = new Account();

		System.out.println("Deposit Operation");

		new DepositThread(a1, 1000);
		new DepositThread(a1, 1000);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
		a1.displayBal();
		System.out.println();
		System.out.println("Withdraw Operation");
		new WithdrawThread(a1, 500);
		new WithdrawThread(a1, 700);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
		a1.displayBal();

	}

}

class Account {
	private int balance = 1000;

	synchronized void displayBal() {
		System.out.println("Balance = " + balance);
	}

	void deposit(int amt) {
		int currBal = balance;
		int newBal = currBal + amt;
		try {
			Thread.sleep(500);
		} catch (Exception e) {

		}
		balance = newBal;
		System.out.println(amt + " rs deposited into your bank.");
	}

	void withdraw(int amt) {
		int currBal = balance;
		int newBal = currBal - amt;
		try {
			Thread.sleep(500);
		} catch (Exception e) {

		}
		balance = newBal;
		System.out.println(amt + " rs withdraw from your bank.");
	}

}

//Thread For Deposit Money
class DepositThread implements Runnable {
	Account acc;
	int amt;

	DepositThread(Account acc, int amt) {
		this.acc = acc;
		this.amt = amt;
		new Thread(this).start();
	}

	@Override
	public void run() {
		synchronized (acc) {
			acc.deposit(amt);
		}

	}
}

//Thread For withdraw Money
class WithdrawThread implements Runnable {
	Account acc;
	int amt;

	WithdrawThread(Account acc, int amt) {
		this.acc = acc;
		this.amt = amt;
		new Thread(this).start();
	}

	@Override
	public void run() {
		synchronized (acc) {
			acc.withdraw(amt);
		}

	}
}

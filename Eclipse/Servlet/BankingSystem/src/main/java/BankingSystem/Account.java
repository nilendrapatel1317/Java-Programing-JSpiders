package BankingSystem;

public class Account {    
	private long accountNumber;
    private double balance;
    private int security_pin;
    private boolean acc_lock;
    private long user_id;
	public Account(long accountNumber, double balance, int security_pin, boolean acc_lock, long user_id) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.security_pin = security_pin;
		this.acc_lock = acc_lock;
		this.user_id = user_id;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getSecurity_pin() {
		return security_pin;
	}
	public void setSecurity_pin(int security_pin) {
		this.security_pin = security_pin;
	}
	public boolean isAcc_lock() {
		return acc_lock;
	}
	public void setAcc_lock(boolean acc_lock) {
		this.acc_lock = acc_lock;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", security_pin=" + security_pin
				+ ", acc_lock=" + acc_lock + ", user_id=" + user_id + "]";
	}
	
	
    

   
}

package MultiThreading;

public class UnsafeThread {

	public static void main(String[] args) {
		
		new Thread1();

		Thread t2 = new Thread2();
		t2.start();
	}
}

class Thread1 extends Thread {
	public Thread1() {
		start();
	}

	public void run() {
		System.out.println("Thread1 is starts");
		for (int i = 1; i <= 20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
		System.out.println("Thread1 is ends");
	}
}

class Thread2 extends Thread {
	public void run() {
		System.out.println("Thread2 is starts");
		for (char i = 'A'; i < 'Z'; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
		System.out.println("Thread2 is ends");
	}
}

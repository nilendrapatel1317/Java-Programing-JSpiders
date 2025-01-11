package MultiThreading;

public class ThreadAttribute {
	public static void main(String[] args) {
		Thread t1 = Thread.currentThread();
		System.out.println(t1.getName());
		System.out.println(t1.getId());
		System.out.println(t1.getPriority());
		System.out.println(t1.getState());

//		t1.start();
		// Calling isDaemon() after calling start() it will throw an exception that is "IllegalThreadStateException" 
	
		if(t1.isDaemon()) {
			System.out.println("Daemon Thread");
		}
		else {
			System.out.println("User Thread");
		}
	}
	
}

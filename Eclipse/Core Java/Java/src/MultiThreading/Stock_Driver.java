package MultiThreading;

public class Stock_Driver {
	public static void main(String[] args) {
		Stock s = Stock.getInstance();
		
		s.display();
		
		new UpdateThread(30);
		s.display();
		try { Thread.sleep(2000); } catch (Exception e) {}
		
		new ConsumeThread(25);
		s.display();
		try { Thread.sleep(2000); } catch (Exception e) {}
		
		new ConsumeThread(25);
		s.display();
		try { Thread.sleep(2000); } catch (Exception e) {}
		
		new ConsumeThread(25);
		s.display();
		try { Thread.sleep(2000); } catch (Exception e) {}
//		
		new ConsumeThread(25);
		s.display();
		try { Thread.sleep(2000); } catch (Exception e) {}
		
		new UpdateThread(100);
		s.display();
		try { Thread.sleep(2000); } catch (Exception e) {}
		
		
		s.display();
		
		
	}
}

class Stock {
	private int items ;
	
	//Singleton class implementation starts
	//Private Data member of class type
	private static Stock obj = null;
	
	//Private Constructor of class type
	private Stock() {}
	
	//Public getInstance method of class type
	public static Stock getInstance() {
		if(obj==null) obj=new Stock();
		return obj;
	}
	//Singleton class implementation ends
	
	
	public void display() {
		System.out.println("Total avaliable items : "+items);
	}
	
	synchronized public void update(int n) {
		items+=n;
		System.out.println("Stock is updated by "+n+" items");
//		notify(); // it will notify only one thread which is in wait state (JVM will decide the thread)
		notifyAll(); //it will notify all threads which are in wait state
	}
	
	synchronized public void consume(int n) {
		System.out.println("Consumer requires "+n+" items");
		while(items < n) {
			System.out.println("Stock is less, waiting for updates.");
			try {
				wait();
			} catch (Exception e) {

			}
		}
		items-=n;
		System.out.println(n+" items are consumed");
	}
}


class UpdateThread implements Runnable{
	int items;
	
	public UpdateThread(int items) {
		this.items = items;
		new Thread(this).start();
	}
	
	public void run() {
		System.out.println();
		System.out.println("Running Thread : "+ Thread.currentThread().getName());
		Stock.getInstance().update(items);
	}
}

class ConsumeThread implements Runnable{
	int items;
	
	public ConsumeThread(int items) {
		this.items = items;
		new Thread(this).start();
	}
	
	public void run() {
		System.out.println();
		System.out.println("Running Thread : "+ Thread.currentThread().getName());
		Stock.getInstance().consume(items);
	}
}































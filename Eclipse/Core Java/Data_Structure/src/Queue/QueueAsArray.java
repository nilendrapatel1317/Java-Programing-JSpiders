package Queue;

public class QueueAsArray {
	private int top = 0;
	private int last = 0;
	private int count = 0;

	private int[] a = new int[100];

	// size() method
	public int size() {
		return count;
	}

	// isEmpty() method
	public boolean isEmpty() {
		return count == 0;
	}

	// peek() method
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		return a[top];
	}

	// poll() method
	public int poll() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}

		int elem = a[top];
		top = (top+1)%a.length;
		count--;
		return elem;
	}
	 
	//add() method
	public void add(int elem) {
		if (count == a.length) {
            System.out.println("Queue is Full");
            return;
        }
		a[last] = elem;
		last = (last+1)%a.length;
		count++;	
	}

}

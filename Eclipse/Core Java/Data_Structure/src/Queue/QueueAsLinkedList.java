package Queue;

public class QueueAsLinkedList {
	Node head;
	Node tail;

	int count = 0;

	// size() method
	public int size() {
		return count;
	}

	// isEmpty() method
	public boolean isEmpty() {
		return count == 0;
	}

	// peek() method
	public Object peek() {
		if (head == null) {
			System.out.println("Queue is Empty");
			return null;
		}

		return head.elem;
	}

	// poll() method
	public Object poll() {
		if (head == null) {
			System.out.println("Queue is Empty");
			return null;
		}
		Object elem = head.elem;
		head = head.next;
		count--;
		return elem;
	}

	// add() method
	public void add(Object elem) {
		Node n = new Node(elem);
		if (head == null) {
			head = n;
			tail = n;
			count++;
			return;
		}

		tail.next = n;
		tail = n;
		count++;

	}
}

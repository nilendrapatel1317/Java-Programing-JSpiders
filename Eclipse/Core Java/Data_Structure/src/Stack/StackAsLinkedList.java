package Stack;

public class StackAsLinkedList {
	Node head;
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
			throw new NullPointerException();
		}
		return head.elem;
	}

	// pop() method
	public Object pop() {
		if (head == null) {
			throw new NullPointerException();
		}
		Object elem = head.elem;
		head = head.next;
		count--;
		return elem;
	}

	// push() method
	public void push(Object elem) {
		Node n = new Node(elem);

		if (head == null) {
			head = n;
			count++;
			return;
		}

		head = new Node(elem, head);
		count++;

	}
}

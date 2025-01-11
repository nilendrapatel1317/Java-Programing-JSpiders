package Stack;

public class Test3 {
	class Node {
		Object elem;
		Node prev;
		Node next;

		public Node(Object e) {
			elem = e;
			prev = next = null;
		}

		public Node(Object e, Node p, Node n) {
			elem = e;
			prev = p;
			next = n;
		}
	}

	Node head;
	int count = 0;

	public int size() {
		return count;
	}

	public void remove(int index) {
		if (index <= -1 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if(index==0) {
			head=head.next;
			head.prev = null;
			count--;
			return;
		}
		
		Node curr = head;
		for (int i = 1; i < index; i++) {
			curr = curr.next;
		}
		curr.next = curr.next.prev;
		if(curr.next != null ) curr.next.prev = curr;
		count--;
	}
}

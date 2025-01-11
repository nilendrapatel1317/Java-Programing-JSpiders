package Doubly_Linked_List;

public class DoubleLinkedList {
	Node first;
	int count = 0;

	// size()
	public int size() {
		return count;
	}

	// traverse()
	public void traverse() {
		if (first == null) {
			System.out.println("List is Empty");
			return;
		}

		Node curr = first;
		while (curr != null) {
			System.out.print(curr.elem + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	// add(40)
	public void add(Object elem) {
		if (first == null) {
			first = new Node(elem);
			count++;
			return;
		}
		Node curr = first;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node(elem, curr, null);
		count++;
	}

	// add(index,elem)
	public void add(int index, Object elem) {
		if (index <= -1 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			Node n = new Node(elem, null, first);
			first.prev = n;
			first = n;
			count++;
			return;
		}

		Node curr = first;
		for (int i = 1; i < index; i++) {
			curr = curr.next;

		}

		Node n = new Node(elem, curr, curr.next);
		curr.next.prev = n;
		curr.next = n;
		count++;

	}

	// get()
	public Object get(int index) {
		if (index <= -1 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (first == null) {
			System.out.println("List is Empty");
			return null;
		}

		Node curr = first;
		for (int i = 1; i <= index; i++) {
			curr = curr.next;
		}

		return curr.elem;
	}

	// seach()
	public boolean search(Object elem) {
		if (first == null) {
			return false;
		}
		Node curr = first;
		while (curr != null) {
			if (elem == curr.elem)
				return true;
			curr = curr.next;
		}

		return false;
	}

	// remove(index)
	public void remove(int index) {
		if (index <= -1 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			first = first.next;
			first.prev = null;
			count--;
			return;
		}

		Node curr = first;
		for (int i = 1; i < index; i++) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
		if (curr.next != null)
			curr.next.next.prev = curr;
		count--;
	}
	
	//reverse()
	public void reverse() {
		if(first==null) {
			System.out.println("List is empty");
			return;
		}
		
		Node prev = null;
		Node curr = first;
		Node next = null;
		
		while(curr!=null) {
			next=curr.next;
			curr.next = prev;
			curr.prev = next;
			prev=curr;
			curr=next;
		}
		first=prev;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package Singly_Linked_LIst;

public class SingleLinkedList {
	private Node first;
	private int count;

	// size()
	public int size() {
		return count;
	}

	// traverse()
	public void traverse() {
		if (first == null) {
			System.out.println("Linked List is Empty");
			return;
		}
		Node curr = first;
//		while(curr!=null) {
//			System.out.print(curr.elem +" ");
//			curr = curr.next;
//		}
		for (int i = 0; i < size(); i++) {
			String arrow = i < size() - 1 ? " -> " : "";
			System.out.print(curr.elem + arrow);
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
		curr.next = new Node(elem);
		count++;
	}

	// add(3,70)
	public void add(int index, Object elem) {
		if (index <= -1 || index > size()) {
			throw new IndexOutOfBoundsException("Invalid index: " + index);
		}

		if (index == 0) {
			first = new Node(elem,first);
			count++;
			return;
		}

		Node curr = first;
		for (int i = 1; i < index; i++) {
			curr = curr.next;
		}
		curr.next = new Node(elem, curr.next);
		count++;

	}

	// remove()
	public void remove() {
		if (first == null) {
			System.out.println("Linked List is empty");
			return;
		}

		first = first.next;
		count--;
	}

	// remove(index)
	public void remove(int index) {
		if (index <= -1 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			first = first.next;
			count--;
			return;
		}

		Node curr = first;
		for (int i = 1; i < index; i++) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
		count--;
	}

	// search()
	public boolean search(Object elem) {
		if (first == null) {
			System.out.println("List is empty");
			return true;
		}
		Node curr = first;
		while (curr != null) {
			if (elem == curr.elem)
				return true;
			curr = curr.next;
		}

		return false;
	}

	// get() element specific index
	public Object get(int index) {
		if (index <= -1 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		Node curr = first;
		for (int i = 1; i <= index; i++) {
			curr = curr.next;
		}
		
		return curr.elem;

	}
	
	//revere()
	public void reverse() {
		if(first==null) {
			System.out.println("List is Empty");
			return;
		}
		Node prev = null;
		Node curr = first;
		Node next = null;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev = curr;
			curr=next;
		}
		first=prev;
		
	}

}

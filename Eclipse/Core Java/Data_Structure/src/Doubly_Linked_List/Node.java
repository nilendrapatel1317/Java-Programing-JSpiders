package Doubly_Linked_List;

public class Node {
	Object elem;
	Node next;
	Node prev;

	public Node(Object e) {
		elem = e;
		next = null;
		prev = null;
	}

	public Node(Object e, Node p, Node n) {
		elem = e;
		prev = p;
		next = n;
	}
}

package HashSet_for_int_type;


class HashSet {
	// inner Node class
	class Node {
		int key;
		Node next;

		public Node(int key, Node next) {
			this.key = key;
			this.next = next;
		}
	}

	private Node[] a = new Node[10];
	private int count = 0;

	// size()method
	public int size() {
		return count;
	}

	// isEmpty() method
	public boolean isEmpty() {
		return count == 0;
	}

	// add() method
	public boolean add(int key) {
		int index = key % a.length; // Hash Function for int type element
		index = Math.abs(index);

		if (a[index] == null) {
			a[index] = new Node(key, null);
			count++;
			return true;
		}

		Node curr = a[index];
		Node prev = null;

		while (curr != null) {
			if (key == curr.key)
				return false;
			prev = curr;
			curr = curr.next;
		}
		prev.next = new Node(key, null);
		count++;
		return true;
	}

	// traverse() method
	public void traverse() {
		System.out.println("HashSet Elements : ");
		for (int i = 0; i < a.length; i++) {
			Node curr = a[i];
			while (curr != null) {
				System.out.print(curr.key + " ");
				curr = curr.next;
			}
		}
		System.out.println();
	}

	// search() method
	public boolean search(int key) {
		int index = key % a.length;
		index = Math.abs(index);

		Node curr = a[index];
		while (curr != null) {
			if (key == curr.key)
				return true;
			curr = curr.next;
			System.out.println(curr);
		}
		return false;
	}

	// delete() method
	public boolean delete(int key) {
		int index = key % a.length;
		index = Math.abs(index);

		Node curr = a[index];
		Node prev = null;
		while (curr != null) {
			if (key == curr.key) {
				if (prev == null) {
	                // If the node to delete is the head, move the head to the next node
					a[index] = curr.next;
	            } else {
	                // If it's not the head, update the previous node's next pointer
	                prev.next = curr.next;
	            }
				count--;
				return true;
			}
			prev = curr;
			curr = curr.next;
		}
		System.out.println(curr);
		return false;

	}

}


public class HashSetDriver {
	public static void main(String[] args) {
		HashSet h = new HashSet();
		
		System.out.println("Size of HashSet : "+h.size());
		
		h.add(93);
		h.add(42);
		h.add(11);
		h.add(50);
		h.add(63);
		h.add(16);
		h.add(67);
		h.add(11);
		h.add(88);
		h.add(92);
		h.add(42);
		
		System.out.println();
		h.traverse();
		System.out.println();
		System.out.println("Size of HashSet : "+h.size());
		int searchElem = 93;
		System.out.println(h.search(searchElem) ? searchElem +" Found in HashSet" : searchElem +" Not Found in HashSet");
		
		int deletedItem = 50;
		boolean flag = h.delete(deletedItem);
		System.out.println(flag ? deletedItem+" key found and deleted." : deletedItem+" key Not found !" );
		System.out.println("Size of HashSet : "+h.size());
		h.traverse();
	}
}

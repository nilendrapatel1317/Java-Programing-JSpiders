package HashSet_for_Object_type;

public class HashSet {
	public class Node {
		Object key ;
		Node next;

		public Node(Object key,Node next) {
			this.key = key;
			this.next=next;
		}
	}
	
	private Node[] a = new Node[10];
	private int count = 0;

	// size() method
	public int size() {
		return count;
	}

	// isEmpty() method
	public boolean isEmpty() {
		return count == 0;
	}

	// add() method
	public boolean add(Object Key) {
		int index = Key.hashCode() % a.length;
		index = Math.abs(index);

		if (a[index] == null) {
			a[index] = new Node(Key, null);
			count++;
			return true;
		}

		Node curr = a[index];
		Node prev = null;
		while (curr != null) {
			if (Key.equals(curr.key))
				return false;
			prev = curr;
			curr = curr.next;
		}
		prev.next = new Node(Key, null);
		count++;
		return true;
	}

	// traverse() method
	public void traverse() {
		System.out.println("HashSet Elements : ");
		for (int i = 0; i < a.length; i++) {
			Node curr = a[i];
			while (curr != null) {
				System.out.println(curr.key + " ");
				curr = curr.next;
			}
		}
	}

	// search() method
//	public Boolean search(Object key) {
//		int index = key.hashCode()%a.length;
//		index = Math.abs(index);
//		
//		Node curr = a[index];
//		while(curr!=null) {
//			if(key==curr.key) return true;
//			curr = curr.next;
//		}
//		return false;
//	}

}

package Doubly_Linked_List;

public class Test {
	public static void main(String[] args) {
		DoubleLinkedList d= new DoubleLinkedList();

		System.out.println(d.size());
		d.add(10);
		d.add(20);
		d.add(30);
		d.add(40);
		d.add(50);
		d.traverse();
		
		d.add(2, 77);
		d.traverse();
		System.out.println(d.get(0));
		System.out.println(d.search(77) ? "Found" : "Not found");
		
		d.remove(5);
		d.traverse();
		d.reverse();
		d.traverse();
	}
}

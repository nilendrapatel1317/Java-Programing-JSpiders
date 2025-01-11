package Singly_Linked_LIst;

public class Test {
	public static void main(String[] args) {
		SingleLinkedList s = new SingleLinkedList();
		System.out.println(s.size());
		s.add(10);
		s.add(20);
		s.add(30);
		s.add(40);
		s.add(50);
		System.out.println(s.size());
		s.traverse();
		s.add(5, 77);
		s.traverse();
		
		s.reverse();
		s.traverse();
		
		System.out.println(s.get(0));
		//searching
		int num = 5;
		System.out.println(s.search(num) ? num+" Found ": num+" Not found");
		
		
		
		s.remove();
		s.traverse();
		s.remove(2);
		s.traverse();
	}
}

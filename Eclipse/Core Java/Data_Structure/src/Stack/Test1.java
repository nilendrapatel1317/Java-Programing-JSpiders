package Stack;

public class Test1 {

	public static void main(String[] args) {
		StackAsLinkedList s = new StackAsLinkedList();
		
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.push(70);
		
		System.out.println("Size of Stack : "+s.size());
		System.out.println(s.isEmpty()? "Stack is Empty": "Stack Not Full");
		System.out.println("Top element of Stack : "+s.peek());
		while(!s.isEmpty()) {
			System.out.println(s.pop() + " Popped from Stack");
		}
		System.out.println(s.isEmpty()? "Stack is Empty": "Stack Not Full");

	}

}

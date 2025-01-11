package Stack;

public class Test2 {
	public static void main(String[] args) {
		StackAsArray s = new StackAsArray();
		
		System.out.println(s.size());
//		System.out.println(s.isEmpty());
//		System.out.println(s.peek());

		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
//		
		System.out.println(s.size());
//		System.out.println(s.isEmpty());
//		System.out.println(s.peek());
//		
//		while(!s.isEmpty()) {
//			System.out.println(s.pop() + " Popped from Stack");
//		}
//		System.out.println(s.peek());
	}
}

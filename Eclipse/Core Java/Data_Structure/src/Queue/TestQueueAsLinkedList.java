package Queue;

public class TestQueueAsLinkedList {
	public static void main(String[] args) {
		QueueAsLinkedList q = new QueueAsLinkedList();
		System.out.println("Size of Queue : "+q.size());
		System.out.println(q.isEmpty() ? "" : "Queue is Not Empty");
		System.out.println("Top Element in Queue : "+q.peek());
		System.out.println(q.poll());
		
		for (int i = 10; i <= 100; i+=10) {
			q.add(i);
			System.out.println(i + " Added into Queue");
		}
		
		
		System.out.println("Size of Queue : "+q.size());
		System.out.println(q.isEmpty() ? "" : "Queue is Not Empty");
		System.out.println("Top Element in Queue : "+q.peek());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println("Top Element in Queue : "+q.peek());
	}
}

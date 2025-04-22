package Collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(40);
		queue.add(10);
		queue.add(30);
		queue.add(50);
		queue.add(20);
		System.out.println("LinkedList : "+queue);
		Queue<Integer> queue2 = new ArrayDeque<Integer>(queue);
		System.out.println("ArrayDeque : "+queue2);
		Queue<Integer> queue3 = new PriorityQueue<Integer>(queue);
		System.out.println("PriorityQu For Primitive data: "+queue3);
		
		Queue<String> queue4 = new PriorityQueue<String>();
		queue4.add("D");
		queue4.add("N");
		queue4.add("A");
		queue4.add("G");
		queue4.add("B");
		queue4.add("C");
		List<String> list = new ArrayList<String>();
		while(!queue4.isEmpty()) {			
			list.add(queue4.poll());
		}
		System.out.println("PriorityQu for Non primitive data : " + list);
		
		
	}
}

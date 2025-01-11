package Collection_Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;


public class Priority_Queue {
	public static void main(String[] args) {
		Queue q=new PriorityQueue();
		q.add('x');
		q.add('v');
		q.add('w');
		q.add('f');
		q.add('j');
		
		System.out.println(q.peek());
	}
}

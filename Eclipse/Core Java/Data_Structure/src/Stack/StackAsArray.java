package Stack;

public class StackAsArray {
	int top = 0;

	int[] a = new int[100];

	// size() method
	public int size() {
		return top;
	}

	// isEmpty() method
	public boolean isEmpty() {
		return top <= 0;
	}
	
	//peek() method
	public int peek() {
		if(top <= 0) {
			System.out.println("Stack is Empty");
			return 0;
		}
		
		return a[top];
	}
	
	//pop() method
	public int pop() {
		if(top <= 0) {
			System.out.println("Stack is Empty");
			return 0;
		}
		
		int elem = a[top--];
		return elem;
	}
	
	//push() method
	public void push(int n) {
		if(top > a.length) {
			System.out.println("Stack is Full");
			return;
		}
		System.out.println();
		System.out.println(top+" , "+n);
		System.out.println();
		a[top++] = n;
	}
}



























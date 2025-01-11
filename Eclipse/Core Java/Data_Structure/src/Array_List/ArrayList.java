package Array_List;

class ArrayListImplementation {
	private Object[] a;
	private int pos;
	
	
	public ArrayListImplementation() {
		this.a = new Object[5];
		this.pos = 0;
	}
	
	//Method for Add element at end
	public void add(Object e) {
		if(pos >= size()) increaseArraySize();
		a[pos]=e;
		pos++;
	}
	
	//Method For increase Array Size
	private void increaseArraySize() {
		Object[] temp = new Object[size() + 3];
		System.arraycopy(a, 0, temp, 0, size());
		a=temp;
	}
	
	//Method for Get element (View Element)
	public Object get(int index) {
		if(index <= -1 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
				
		return a[index];
	}
	
	
	//Method for Add element at specific index(position)
	public void add(int index , Object e) {
		if(index<=-1 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if(pos >= size()) increaseArraySize();
		
		a[index]=e;
		pos++;
	}
	
	//Method for Array Size
	public int size() {
		return pos;
	}
	
	
	
	public void printArray() {
		for (int i = 0; i < size(); i++) {
			System.out.print(get(i)+" ");
		}
	}
}

public class ArrayList{

	public static void main(String[] args) {
		ArrayListImplementation arr = new ArrayListImplementation();

		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(40);
		arr.add(50);

		arr.printArray();
		System.out.println();

		arr.add(9, 70);
		arr.printArray();
		
		System.out.println(arr.size());

	}

}






























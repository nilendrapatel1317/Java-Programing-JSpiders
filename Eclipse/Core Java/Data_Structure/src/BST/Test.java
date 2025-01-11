package BST;

public class Test {
	public static void main(String[] args) {
		BST bst = new BST();
		
		bst.add(10);
		bst.add(32);
		bst.add(42);
		bst.add(8);
		bst.add(12);
		bst.add(16);
		
		System.out.println("Size of BST : "+bst.size());
		bst.traverse();
		bst.delete(10);
		bst.traverse();
		System.out.println("Size of BST : "+bst.size());
		int elem = 10;
		System.out.println(bst.search(elem) ? elem+" is Found in BST" : elem+" is Not found in BST");
	}
}

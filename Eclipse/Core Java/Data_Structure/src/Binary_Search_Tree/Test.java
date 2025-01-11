package Binary_Search_Tree;

public class Test {
	public static void main(String[] args) {
		BST b = new BST();
		System.out.println(b.add(50));
		System.out.println(b.add(23));
		System.out.println(b.add(70));
		System.out.println(b.add(33));
		System.out.println(b.add(12));
		System.out.println(b.add(84));
		System.out.println(b.add(60));
		
		System.out.println();
		b.traverse();
		System.out.println();
		
		b.delete(50);
		System.out.println();
		b.traverse();
		System.out.println();
		
	}
}

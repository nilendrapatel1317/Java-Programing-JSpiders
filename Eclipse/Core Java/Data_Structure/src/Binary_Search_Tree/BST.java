package Binary_Search_Tree;

public class BST {
	private Node root;
	private int count = 0;
	private boolean flag = true;

	// add() method
	public boolean add(int key) {
		root = addNode(root, key);
		return flag;
	}

	// recursive method for add() method
	public Node addNode(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			count++;
			return root;
		}

		if (key < root.key) {
			root.left = addNode(root.left, key);
		} else if (key > root.key) {
			root.right = addNode(root.right, key);
		} else {
			flag = false;
		}

		return root;
	}

	// traverse() method
	public void traverse() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
		}
	}

	// search() method
	public boolean search(int key) {
		return searchRecursive(root, key);
	}

	private boolean searchRecursive(Node root, int key) {
		if (root == null)
			return false;
		if (key == root.key)
			return true;
		if (key < root.key)
			return searchRecursive(root.left, key);
		return searchRecursive(root.right, key);
	}

	// delete() method
	public void delete(int key) {
		root = deleteRec(root, key);
	}

	private Node deleteRec(Node root, int key) {
		if (root == null)
			return root;

		if (key < root.key)
			root.left = deleteRec(root.left, key);
		else if (key > root.key)
			root.right = deleteRec(root.right, key);
		else {
			if (root.left == null && root.right == null)
				root = null;
			else if (root.left == null)
				root = root.right;
			else if (root.right == null)
				root = root.left;
			else {
				Node temp = findMinValue(root.right);
				root.key = temp.key;
				count--;
				root.right = deleteRec(root.right, root.key);
			}
		}
		return root;
	}

	// minvalue() method
	private Node findMinValue(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

}

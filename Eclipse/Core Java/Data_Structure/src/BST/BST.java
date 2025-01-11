package BST;

public class BST {
	private Node root;
	private int count;

	// size() method
	public int size() {
		return count;
	}

	// add() method
	public void add(int key) {
		root = addRec(root, key);
	}

	private Node addRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			count++;
			return root;
		}

		if (key < root.key) {
			root.left = addRec(root.left, key);
		} else if (key > root.key) {
			root.right = addRec(root.right, key);
		}

		return root;
	}

	// search() method
	public boolean search(int key) {
		return searchRec(root, key);
	}

	private boolean searchRec(Node root, int key) {
		if (root == null) {
			return false;
		}
		if (key == root.key) {
			return true;
		}

		if (key < root.key) {
			return searchRec(root.left, key);
		}

		return searchRec(root.right, key);
	}

	// delete() method
	public void delete(int key) {
		root = deleteRec(root, key);
	}

	private Node deleteRec(Node root, int key) {
		if (root == null) {
			return root;
		}

		//If key is present in Left side
		if (key < root.key) {
			root.left = deleteRec(root.left, key);
		} 
		//If key is present in Right side
		else if (key > root.key) {
			root.right = deleteRec(root.right, key);
		}
		//If key is present in Middle Node
		else {
			//If NO children present 
			if (root.left == null && root.right == null) {
				root = null;
			} 
			//If only right child present
			else if (root.left == null) {
				root = root.right;
			} 
			//If only left child present
			else if (root.right == null) {
				root = root.left;
			} 
			//delete the elem
			else {
				Node temp = findMinValue(root.right, key);
				root.key = temp.key;
				count--;
				root.right = deleteRec(root.right, root.key);
			}
		}

		return root;
	}

	private Node findMinValue(Node root, int key) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	// traverse() method
	public void traverse() {
		inorder(root);
		System.out.println();
	}

	private void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.key + " ");
			inorder(root.right);
		}
	}

}

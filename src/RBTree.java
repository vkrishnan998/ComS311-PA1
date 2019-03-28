

public class RBTree {
	Node root;
	Node nil;
	int height;
	int size;
	
	public RBTree() {
		root.color = 1;
		nil.color = 1;
		height = 1;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public Node getNILNode() {
		return nil;
	}
	
	public int getSize() {
		findSize(root);
		return size;
	}
	
	public int getHeight() {
		findBlackHeight(root);
		return height;
	}
	
	public void findBlackHeight(Node root) {
		if (root == null) {
			return;
		}
		if (root.color == 1) {
			height++;
		}
		findBlackHeight(root.left);
		findBlackHeight(root.right);
	}
	
	public void findSize(Node root) {
		if (root == null) {
			return;
		}
		else {
			size++;
		}
		findSize(root.left);
		findSize(root.right);
	}
}

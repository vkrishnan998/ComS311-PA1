

public class RBTree {
	Node root;
	Node nil;
	int height;
	int size;
	
	public RBTree() {
		root.color = 1;
		nil.color = 1;
		height = 1;
		findBlackHeightAndSize(root);
	}
	
	public Node getRoot() {
		return root;
	}
	
	public Node getNILNode() {
		return nil;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void findBlackHeightAndSize(Node root) {
		if (root == null) {
			return;
		}
		if (root.color == 1) {
			height++;
		}
		size++;
		findBlackHeightAndSize(root);
		findBlackHeightAndSize(root);
	}
}

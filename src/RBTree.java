/**
 * Team members:
 * 
 * @author Vatsal Bhatt
 * @author Vignesh Krishnan
 * 
 *         RBTree class, maintains operations on RBTree.
 */
public class RBTree {
	Node root;
	static Node nil;
	int height;
	int size;

	/**
	 * RB Tree constructor. It initializes nil node as well.
	 */
	public RBTree() {
		nil = new Node();
		nil.color = 1;
		nil.p = 0;
		nil.val = 0;
		nil.maxval = 0;
		nil.endPoint = new Endpoint();
		size = 0;
		height = 0;
		root = nil;

	}

	/**
	 * Returns the root of teh tree.
	 * 
	 * @return
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * Returns reference for the nil node, for the rbTree.
	 * 
	 * @return
	 */
	public Node getNILNode() {
		return nil;
	}

	/**
	 * Returns the number of internal nodes in the tree.
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Returns the height of the tree.
	 * 
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Find height of the RB tree
	 */
	public void findHeight() {
		height = recHeight(root);
	}

	/**
	 * Calculate height of the RB tree with recursion
	 * 
	 * @param root
	 * @return
	 */
	public int recHeight(Node root) {
		if (root == nil) {
			return 0;
		} else {
			int lHeight = recHeight(root.left);
			int rHeight = recHeight(root.right);

			if (lHeight > rHeight) {
				return (lHeight + 1);
			} else {
				return (rHeight + 1);
			}
		}
	}

	/**
	 * Calculate size of the RB tree
	 * 
	 * @param root
	 */
	public void findSize(Node root) {
		if (root == nil) {
			return;
		} else {
			size++;
		}
		findSize(root.left);
		findSize(root.right);
	}

	/**
	 * Node insertion algorithm for RB tree
	 * 
	 * @param z
	 */
	public void RBInsert(Node z) {
		Node y = nil;
		Node x = root;
		while (x != nil) {
			y = x;
			if (z.key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		z.parent = y;
		if (y == nil) {
			root = z;
		} else if (z.key < y.key) {
			y.left = z;
		} else {
			y.right = z;
		}
		z.left = nil;
		z.right = nil;
		z.color = 0;
		RBInsertFixup(z);
	}

	/**
	 * Insertion fixup for RB tree
	 * 
	 * @param z
	 */
	public void RBInsertFixup(Node z) {
		while (z.parent.color == 0) {
			if (z.parent == z.parent.parent.left) {
				Node y = z.parent.parent.right;
				if (y.color == 0) {
					z.parent.color = 1;
					y.color = 1;
					z.parent.parent.color = 0;
					z = z.parent.parent;
				} else {
					if (z == z.parent.right) {
						z = z.parent;
						leftRotate(z);
					}
					z.parent.color = 1;
					z.parent.parent.color = 0;
					rightRotate(z.parent.parent);
				}
			} else {
				Node y = z.parent.parent.left;
				if (y.color == 0) {
					z.parent.color = 1;
					y.color = 1;
					z.parent.parent.color = 0;
					z = z.parent.parent;
				} else {
					if (z == z.parent.left) {
						z = z.parent;
						rightRotate(z);
					}
					z.parent.color = 1;
					z.parent.parent.color = 0;
					leftRotate(z.parent.parent);
				}
			}
		}
		root.color = 1;

	}

	/**
	 * Left rotation for insertion fixup
	 * 
	 * @param x
	 */
	public void leftRotate(Node x) {
		Node y = x.right;
		x.right = y.left;
		if (y.left != nil) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == nil) {
			root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}

	/**
	 * Right rotate for insertion fixup
	 * 
	 * @param x
	 */
	public void rightRotate(Node x) {
		Node y = x.left;
		x.left = y.right;
		if (y.right != nil) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == nil) {
			root = y;
		} else if (x == x.parent.right) {
			x.parent.right = y;
		} else {
			x.parent.left = y;
		}
		y.right = x;
		x.parent = y;
	}

	/**
	 * Calculate and update val for nodes in the RB tree
	 * 
	 * @param v
	 */
	public void calcVal(Node v) {
		if (v == nil) {
			return;
		}
		calcVal(v.left);
		calcVal(v.right);
		v.val = v.left.val + v.p + v.right.val;
	}
}

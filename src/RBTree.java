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

		// handling duplicate Enpoint overlap
		if (!z.equals(root) && z.parent.key == z.key) {
			if (z.parent.p == -1 && z.p == 1 && z.equals(z.parent.right)) {
				z.parent.p = 1;
				z.p = -1;
			}
		}

		root.color = 1;
	}
	
	/**
	 * RB Transplant
	 * @param u
	 * @param v
	 */
	public void RBTransplant(Node u, Node v) {
		if (u.parent == nil) {
			root = v;
		} else if (u == u.parent.left) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		v.parent = u.parent;
	}
	
	/**
	 * Find minimum of the RB Tree
	 * @param x
	 * @return minimum node
	 */
	public Node Minimum(Node x) {
		Node current = x;

		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return (current);
	}
	
	/**
	 * To delete a node from the RB Tree
	 * @param z Node to delete
	 */
	public void RBDelete(Node z) {
		Node y = z;
		int yOrigColor = y.color;
		Node x = root;
		if (z.left == nil) {
			x = z.right;
			RBTransplant(z, z.right);
		} else if (z.right == nil) {
			x = z.left;
			RBTransplant(z, z.left);
		} else {
			y = Minimum(z.right);
			yOrigColor = y.color;
			x = y.right;
			if (y.parent == z) {
				x.parent = y;
			} else {
				RBTransplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			RBTransplant(z, y);
			y.left = z.left;
			y.left.parent = y;
			y.color = z.color;

		}
		if (yOrigColor == 1) {
			RBDeleteFixup(x);
		}

	}
	
	/**
	 * Deletion fixup
	 * @param x
	 */
	public void RBDeleteFixup(Node x) {
		while (x != root && x.color == 1) {
			if (x == x.parent.left) {
				Node w = x.parent.right;
				if (w.color == 0) {
					w.color = 1;
					x.parent.color = 0;
					leftRotate(x.parent);
					w = x.parent.right;
				}
				if (w.left.color == 1 && w.right.color == 1) {
					w.color = 0;
					x = x.parent;
				} else {
					if (w.right.color == 1) {
						w.left.color = 1;
						w.color = 0;
						rightRotate(w);
						w = x.parent.right;
					}
					w.color = x.parent.color;
					x.parent.color = 1;
					w.right.color = 1;
					leftRotate(x.parent);
					x = root;
				}
			} else {
				Node w = x.parent.left;
				if (w.color == 0) {
					w.color = 1;
					x.parent.color = 0;
					rightRotate(x.parent);
					w = x.parent.left;
				}
				if (w.right.color == 1 && w.left.color == 1) {
					w.color = 0;
					x = x.parent;
				} else {
					if (w.left.color == 1) {
						w.right.color = 1;
						w.color = 0;
						leftRotate(w);
						w = x.parent.left;
					}
					w.color = x.parent.color;
					x.parent.color = 1;
					w.left.color = 1;
					rightRotate(x.parent);
					x = root;
				}
			}
		}
		x.color = 1;
	}

	/**
	 * Left rotation for insertion/deletion fixup
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
	 * Right rotate for insertion/deletion fixup
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

	/**
	 * Calculate and update maxval for nodes
	 * 
	 * @param v
	 */
	public void findMaxVal(Node v) {

		if (v == RBTree.nil) {
			v.maxval = 0;
			v.emax = RBTree.nil.endPoint;
			return;
		}

		findMaxVal(v.left);
		findMaxVal(v.right);

		int maxLeft = v.left.maxval;
		int maxV = v.left.val + v.p;
		int maxRight = maxV + v.right.maxval;

		int max1 = Math.max(maxLeft, maxV);
		int max2 = Math.max(max1, maxRight);

		v.maxval = max2;

		if (max2 == v.left.maxval) {
			v.emax = v.left.emax;
		} else if (max2 == (v.left.val + v.p)) {
			v.emax = v.endPoint;
		} else {
			v.emax = v.right.emax;
		}
	}
}

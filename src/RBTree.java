

public class RBTree {
	static Node root;
	static Node nil;
	int height;
	int size;
	
	public RBTree() {
		nil = new Node();
		root.color = 1;
		nil.color = 1;
		nil.p = 0;
		nil.val = 0;
		nil.maxval = 0;
		size = 0;
		height = 1;
		root = nil;
		
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
	
	public void findHeight() {
		height = recHeight(root);
	}
	
	public int recHeight(Node root) {
		if (root == nil) {
			return 0;
		}
	    else
	    {  
	        int lHeight = recHeight(root.left);
	        int rHeight = recHeight(root.right);  
	      
	        if (lHeight > rHeight) {
	            return(lHeight + 1);  
	        }
	        else {
	        	return(rHeight + 1); 
	        }
	    }  
	}
	
	public void findSize(Node root) {
		if (root == nil) {
			return;
		}
		else {
			size++;
		}
		findSize(root.left);
		findSize(root.right);
	}
	
	public void s(Node a, Node b) {
		
	}
	
	public static void RBInsert(Node z) {
		Node y = nil;
		Node x = root;
		while (x != nil) {
			y = x;
			if (z.key < x.key) {
				x = x.left;
			}
			else {
				x = x.right;
			}
		}
		z.parent = y;
		if (y == nil) {
			root = z;
		}
		else if (z.key < y.key){
			y.left = z;
		}
		else {
			y.right = z;
		}
		z.left = nil;
		z.right = nil;
		z.color = 0;
		RBInsertFixup(z);
	}
	
	public static void RBInsertFixup(Node z) {
		while (z.parent.color == 0) {
			if (z.parent == z.parent.parent.left) {
				Node y = z.parent.parent.right;
				if (y.color == 0) {
					z.parent.color = 1;
					y.color = 1;
					z.parent.parent.color = 0;
					z = z.parent.parent;
				}
				else {
					if (z == z.parent.right) {
						z = z.parent;
						leftRotate(z);
					}
					z.parent.color = 1;
					z.parent.parent.color = 0;
					rightRotate(z.parent.parent);
				}
			}
			else {
				Node y = z.parent.parent.left;
				if (y.color == 0) {
					z.parent.color = 1;
					y.color = 1;
					z.parent.parent.color = 0;
					z = z.parent.parent;
				}
				else {
					if (z == z.parent.left) {
						z = z.parent;
						rightRotate(z);
					}
					z.parent.color = 1;
					z.parent.parent.color = 0;
					leftRotate(z.parent.parent);
				}
			}
			root.color = 0;
		}
	}
	
	public static void leftRotate(Node x) {
		Node y = x.right;
		x.right = y.left;
		if (y.left != nil) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == nil) {
			root = y;
		}
		else if (x == x.parent.left) {
			x.parent.left = y;
		}
		else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}
	
	
	public static void rightRotate(Node x) {
		Node y = x.left;
		x.left = y.right;
		if (y.right != nil) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == nil) {
			root = y;
		}
		else if (x == x.parent.right) {
			x.parent.right = y;
		}
		else {
			x.parent.left = y;
		}
		y.right = x;
		x.parent = y;
	}
	
	public static void inorder(Node x){
		if(x == nil){
			return;
		}
		inorder(x.left);
		inorder(x.right);
	}
}

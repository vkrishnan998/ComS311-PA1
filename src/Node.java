/**
 * Team members:
 * 
 * @author Vatsal Bhatt
 * @author Vignesh Krishnan
 * 
 *         Node class for RBTree.
 */
public class Node {
	Node left;
	Node right;
	Node parent;
	int color;
	int key;
	int p;
	int val;
	int maxval;
	Endpoint emax;
	Endpoint endPoint;

	public Node() {
		this.p = 0;
		this.maxval = 0;
		this.val = 0;
		endPoint = new Endpoint();
	}

	public Node(int key, int p) {
		this.key = key;
		this.p = p;
		val = 0;
		endPoint = new Endpoint(key);
	}

	/**
	 * Returns the parent of this node.
	 * 
	 * @return
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * Returns the left child.
	 * 
	 * @return
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Returns the right child.
	 * 
	 * @return
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Returns the endpoint value, which is an integer.
	 * 
	 * @return
	 */
	public int getKey() {
		return key;
	}

	/**
	 * Returns the value of the functionpbased on this endpoint.
	 * 
	 * @return
	 */
	public int getP() {
		return p;
	}

	/**
	 * Returns the val of the node as described in this assignment.
	 * 
	 * @return
	 */
	public int getVal() {
		return val;
	}

	/**
	 * Returns themaxvalof the node as described in this assignment.
	 * 
	 * @return
	 */
	public int getMaxVal() {
		return maxval;
	}

	/**
	 * Returns theEndpointobject that this node represents.
	 * 
	 * @return
	 */
	public Endpoint getEndpoint() {
		return endPoint;
	}

	/**
	 * Returns anEndpointobject that represents emax. Calling this method on the
	 * root node will give the End point object whose getValue() provides a
	 * point of maximum overlap.
	 * 
	 * @return
	 */
	public Endpoint getEmax() {
		return emax;
	}

	/**
	 * Returns 0 if red. Returns 1 if black.
	 * 
	 * @return
	 */
	public int getColor() {
		return color;
	}
}

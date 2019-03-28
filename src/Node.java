
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
	
	public Node(int key, int p) {
		this.key = key;
		this.p = p;
		val = 0;
		endPoint = new Endpoint(key);
	}
	
	public Node getParent(){
		return parent;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public Node getRight(){
		return right;
	}
	
	public int getKey(){
		return key;
	}
	
	public int getP(){
		return p;
	}
	
	public int getVal(){
		return val;
	}
	
	public int getMaxVal(){
		return maxval;
	}
	
	public Endpoint getEndpoint(){
		return endPoint; 
	}
	
	public Endpoint getEmax(){
		return emax;
	}
	
	public int getColor(){
		return color;
	}
	
	public void calcVal(Node v) {
		if (v == null) {
			return;
		}
		else {
			val += v.p;
		}
		calcVal(v.left);
		calcVal(v.right);
	}
}

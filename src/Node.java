
public class Node {
	Node left;
	Node right;
	Node parent;
	int color;
	int key;
	int p;
	int val;
	int maxVal;
	Endpoint emax;
	Endpoint e;
	
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
		return maxVal;
	}
	
	public Endpoint getEndpoint(){
		return e; 
	}
	
	public Endpoint getEmax(){
		return emax;
	}
	
	public int getColor(){
		return color;
	}
}

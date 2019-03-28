
public class Node {
	Node left;
	Node right;
	Node parent;
	int color;
	
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
		return 0;
	}
	
	public int getP(){
		return 0;
	}
	
	public int getVal(){
		return 0;
	}
	
	public int getMaxVal(){
		return 0;
	}
	
	public Endpoint getEndpoint(){
		return null; 
	}
	
	public Endpoint getEmax(){
		return null;
	}
	
	public int getColor(){
		return color;
	}
}

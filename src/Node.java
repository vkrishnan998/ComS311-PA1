
public class Node {
	Node left;
	Node right;
	Node parent;
	int color;
	
	Node getParent(){
		return parent;
	}
	
	Node getLeft(){
		return left;
	}
	
	Node getRight(){
		return right;
	}
	
	int getKey(){
		return 0;
	}
	
	int getP(){
		return 0;
	}
	
	int getVal(){
		return 0;
	}
	
	int getMaxVal(){
		return 0;
	}
	
	Endpoints getEndpoint(){
		return null; 
	}
	
	Endpoints getEmax(){
		return null;
	}
	
	int getColor(){
		return color;
	}
}

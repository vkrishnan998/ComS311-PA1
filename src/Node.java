
public class Node {
	Node left;
	Node right;
	Node parent;
	int color;
	int key;
	int p;
	static int val;
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
	public int findLeftMaxVal(Node v){
		int max = 0;
			
		if(max < v.val)
			max = v.val;
		
		RBTree.inorder(v.left);

		return max;
		
	}
	
	public int findCenterMaxVal(Node v){
		int max = 0;
	
		max = v.left.p + v.p;
		return max;
	}
	
	public int findRightMaxVal(Node v){
		int max = v.left.val + v.p;
		
		if(max < v.val)
			max = v.val;

		RBTree.inorder(v.right);

		return max;
	}
	
	public void findMaxVal(Node v){
		
		if(v == RBTree.nil){
			maxval = 0;
		}
		
		else{
			int max1 = Math.max(findLeftMaxVal(v), findCenterMaxVal(v));
			int max2 = Math.max(max1, findRightMaxVal(v));
		
			maxval = max2;
		}
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
	
	public static void calcVal(Node v) {
		if (v == RBTree.nil) {
			return;
		}
		else {
			val += v.p;
		}
		calcVal(v.left);
		calcVal(v.right);
	}
}

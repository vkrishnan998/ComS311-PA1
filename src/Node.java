
public class Node {
	Node left;
	Node right;
	Node parent;
	int color;
	int key;
	int p;
	static int val;
	static int maxval;
	Endpoint emax;
	Endpoint endPoint;
	
	
	public Node() {
		
	}
	
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
	
//	public static int findLeftMaxVal(Node v){
//		int max = 0;
//			
//		return RBTree.inorder(v.left, max);
//
//	}
//	
//	public static int findCenterMaxVal(Node v){
//		int max = 0;
//	
//		max = v.left.p + v.p;
//		return max;
//	}
//	
//	public static int findRightMaxVal(Node v){
//		int max = v.left.val + v.p;
//
//		return RBTree.inorder(v.right, max);
//	}
	
	public static void findMaxVal(Node v){
		
		if(v == RBTree.nil){
			maxval = 0;
		}
		
		findMaxVal(v.left);
		findMaxVal(v.right);
		
		int maxLeft = v.left.maxval;
		int maxV = v.left.val + v.p;
		int maxRight = maxV + v.right.maxval;

		int max1 = Math.max(maxLeft, maxV);
		int max2 = Math.max(max1, maxRight);
		
		maxval = max2;
		
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
	
	public void findEmax(Node v){
		for(int i = 0; i < Intervals.rbT.getSize(); i++){
			
		}
	}
}

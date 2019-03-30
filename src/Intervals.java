import java.util.ArrayList;

/**
 * Team members:
 * @author Vatsal Bhatt
 * @author Vignesh Krishnan
 * 
 * A wrapper class for RBTree
 */
public class Intervals {
	
	RBTree rbT;
	ArrayList<Integer> intervalIDs;
	int interval_id;	
	
	/**
	 * Constructor with no parameters.
	 */
	public Intervals() {
		rbT = new RBTree();
		interval_id = 0;
		intervalIDs = new ArrayList<Integer>();		
	}
	
	/**
	 * 
	 * Adds the interval with left endpoint a and right endpoint b 
	 * to the collection of intervals. Each newly inserted interval 
	 * must be assigned an ID. The IDs should be consecutive; that is, 
	 * the ID of the interval inserted on the ith call of this method should be i.
	 * For example if intervalInsert is called successively to insert intervals 
	 * [5,7],[4,9],[1,8], then the IDs of these intervals should be 1,2,3, respectively.These IDs are permanent
	 *  for the respective intervals. Keep track of the IDs, as multiple intervals that have the same endpoints
	 *   on both sides can be added. intervalInsertshould run in O(logn)time
	 * @param a
	 * @param b
	 */
	public void intervalInsert(int a, int b) {
		Node left = new Node(a, 1);
		Node right = new Node(b, -1);
		interval_id++;
		intervalIDs.add(interval_id);
		rbT.RBInsert(left);
		//Node.calcVal(left);
		//Node.findMaxVal(left);
		rbT.RBInsert(right);
		rbT.calcVal(rbT.root);
//		Node.calcVal(rbT.root);
		rbT.root.findMaxVal(rbT.root);

	}
	
	public boolean intervalDelete(int intervalID) {
		return false;
	}
	
	/**
	 * Finds the endpoint that has maximum overlap and returns its value. Thismethod should run in constant time.
	 * @return
	 */
	public int findPOM() {
		return rbT.getRoot().getEmax().getValue();
	}
	
	/**
	 * Returns the red-black tree used, which is an object of typeRBTree.
	 * @return
	 */
	public RBTree getRBTree() {
		return rbT;
	}
	
	/**
	 * This is a suggested way on how to add intervals and call POM()
	 * 
	 * @param args
	 */
	public static void main(String [] args) {
		int points[][] = {{0, 4}, {1, 6}, {3, 9}, {7, 11}};
		Intervals intv = new Intervals();
		
		for(int i=0; i<points.length; i++) {
			//System.out.println("Inserting: "+ Arrays.toString(points[i]));
			intv.intervalInsert(points[i][0], points[i][1]);
		}
		System.out.println("POM is: "+ intv.findPOM()); //Should return 3.
		System.out.println("Emax: " + intv.rbT.root.emax.getValue());
	}
	
	
}

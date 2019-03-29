import java.util.ArrayList;

public class Intervals {
	
	static RBTree rbT;
	ArrayList<Integer> intervalIDs;
	int interval_id;	
	
	public Intervals() {
		rbT = new RBTree();
		interval_id = 0;
		intervalIDs = new ArrayList<Integer>();		
	}
	
	public void intervalInsert(int a, int b) {
		Node left = new Node(a, 1);
		Node right = new Node(b, -1);
		interval_id++;
		intervalIDs.add(interval_id);
		rbT.RBInsert(left);
		rbT.RBInsert(right);
		Node.calcVal(left);
		Node.calcVal(right);
		Node.findMaxVal(left);
		Node.findMaxVal(right);

	}
	
	public boolean intervalDelete(int intervalID) {
		return false;
	}
	
	public int findPOM() {
		return rbT.getRoot().getEmax().getValue();
	}
	
	public RBTree getRBTree() {
		return rbT;
	}
	
	
}

import java.util.ArrayList;

public class Intervals {
	
	RBTree rbT;
	ArrayList<Integer> intervalIDs;
	
	
	
	public Intervals() {
		rbT = new RBTree();
		intervalIDs = new ArrayList<Integer>();
	}
	
	public void intervalInsert(int a, int b) {
		
	}
	
	public boolean intervalDelete(int intervalID) {
		return false;
	}
	
	public int findPOM() {
		return 0;
	}
	
	public RBTree getRBTree() {
		return rbT;
	}
	
	
}

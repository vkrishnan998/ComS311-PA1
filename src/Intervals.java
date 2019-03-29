import java.util.ArrayList;

import com.sun.javafx.scene.paint.GradientUtils.Point;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Intervals {
	
	RBTree rbT;
	ArrayList<Integer> intervalIDs;
	int interval_id;
	ArrayList<Point> points;
	
	
	public Intervals() {
		rbT = new RBTree();
		interval_id = 0;
		intervalIDs = new ArrayList<Integer>();
		points = new ArrayList<Point>();
		
	}
	
	public void intervalInsert(int a, int b) {
		Node left = new Node(a, 1);
		Node right = new Node(b, -1); 
		interval_id++;
		intervalIDs.add(interval_id);
		RBTree.RBInsert(left);
		RBTree.RBInsert(right);
		
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

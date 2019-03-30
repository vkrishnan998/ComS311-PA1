
public class Test {
	public static void main(String[] args) {
		Intervals x = new Intervals();
		x.intervalInsert(0, 4);
		System.out.println(x.rbT.root.key);
		x.intervalInsert(1, 6);
		x.intervalInsert(3, 9);
		x.intervalInsert(7, 11);
		
		System.out.println(x.rbT.root.right.val);
		System.out.println(x.rbT.root.left.maxval);
	}
}


public class Test {
	public static void main(String[] args) {
		Intervals x = new Intervals();
		x.intervalInsert(0, 4);
		x.intervalInsert(7, 11);
		x.intervalInsert(3, 9);
		x.intervalInsert(1, 6);
		
		
		System.out.println(x.rbT.root.key);
		System.out.println(x.rbT.root.left.key);
		System.out.println(x.rbT.root.right.key);
		System.out.println(x.rbT.root.right.left.key);
		System.out.println(x.rbT.root.right.left.left.key);
		System.out.println(x.rbT.root.right.right.key);
		System.out.println(x.rbT.root.left.left.key);
		System.out.println(x.rbT.root.left.right.key);
		System.out.println("---------------");
		System.out.println("Val: " + x.rbT.root.key + " "+ x.rbT.root.val);
		Node val = x.rbT.root.right.right;
		System.out.println("Maxval: " + val.key +" "+ val.maxval);
		System.out.println("Emax: " + val.key +" "+ val.emax.getValue());

	}
}

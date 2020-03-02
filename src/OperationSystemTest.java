
public class OperationSystemTest {

	public static void main(String[] args) {
		FileLeaf f1 = new FileLeaf("Jin", 13);
		FileLeaf f2 = new FileLeaf("Gren", 12);
		FileLeaf f3 = new FileLeaf("Akali", 127);
		FileLeaf f4 = new FileLeaf("Ali", 98);
		FileLeaf f5 = new FileLeaf("Ashe", 22);

		DirectoryComposite top = new DirectoryComposite("LOL");
		DirectoryComposite d1 = new DirectoryComposite("TOP");
		DirectoryComposite d2 = new DirectoryComposite("MID");
		DirectoryComposite d3 = new DirectoryComposite("JUNGLE");
		
		top.leafList.add(d1);
		top.leafList.add(d2);
		
		d2.leafList.add(d3);
		
		top.leafList.add(f1);
		top.leafList.add(f2);
		
		d1.leafList.add(f3);
		d2.leafList.add(f4);
		d3.leafList.add(f5);
		
		
		
		top.printOSTree(0);
	}

}

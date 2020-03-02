
public class FileLeaf implements OSComponent {
	public String name;
	public int size;

	public FileLeaf(String n, int s) {
		name = n;
		size = s;
	}

	public int getAllFilesNum() {
		return 1;
	}

	public int getAllFilesSize() {
		return size;
	}

	@Override
	public void printOSTree(int n) {
		for(int i=n;i>0;i--) System.out.print("   ");
		System.out.println(name + "(" + size + ")");

	}

}

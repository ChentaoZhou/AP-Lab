import java.util.ArrayList;

public class DirectoryComposite implements OSComponent {
	private String name;
	ArrayList<OSComponent> leafList;

	public DirectoryComposite(String n) {
		name = n;
		leafList = new ArrayList<OSComponent>();
		
	}

	public int getAllFilesNum() {
		int filesNum=0;
		for(OSComponent component:leafList) {
			filesNum = filesNum+component.getAllFilesNum();
		}
		return filesNum;
	}

	public int getAllFilesSize() {
		int filesSize = 0;
		for(OSComponent component:leafList) {
			filesSize = filesSize+component.getAllFilesSize();
		}
		return filesSize;
	}
	
	public void printOSTree(int n) {
		for(int i=n;i>0;i--) System.out.print("   ");
		System.out.println(name+"("+getAllFilesSize()+")");
		for(OSComponent component:leafList) {
			component.printOSTree(n+1);
		}
	}

}

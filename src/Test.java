import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		MyCollection mc = new MyCollection(10);
		Iterator<Double> it = mc.iterator();
		
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}

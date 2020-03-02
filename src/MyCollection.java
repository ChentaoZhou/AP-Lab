import java.util.Iterator;
import java.util.Random;

public class MyCollection implements Iterable {
	private int length;
	private Double[] d;
	private Random r = new Random();
	
	
	public MyCollection(int length) {
		this.length = length;
		d = new Double[this.length];
		for(int i=0; i<this.length;i++) {
			d[i] = r.nextDouble() -0.5;
		}
	}
	
	public Iterator<Double> iterator(){
		Iterator<Double> it = new DoubleIterator(this);
		return it;
	}
	public Double[] getSet() {
		return d;
	}
	
}

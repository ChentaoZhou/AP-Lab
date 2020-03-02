import java.util.Iterator;
import java.util.Random;

public class DoubleIterator implements Iterator<Double>{
	MyCollection mc;
	Double[] set;
	int pos;
	public DoubleIterator (MyCollection mc) {
		pos = 0;
		this.mc = mc;
		set = mc.getSet();
	}

	public boolean hasNext() {
		if(pos<set.length) return true;
		else return false;
	}
	public Double next() {
		if(pos>=set.length) {
			return null;
		}
		while(set[pos]<0) {
			pos++;
			if(pos>=set.length) return null;
		}
		if(pos<set.length)	return set[pos++];
		else return null;
	}
	
	

}

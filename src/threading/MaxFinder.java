package threading;

public class MaxFinder implements Runnable{
	Double[] array;
	Double[] result;
	int position;
	public MaxFinder(Double[] array, Double[] result, int position) {
		this.array = array;
		this.result = result;
		this.position = position;
	}
	public void run() {
		double bigest = 0;
		for(int i=0;i<array.length;i++) {
			if(bigest < array[i]) bigest = array[i];
		}
		result[position] = bigest;
	}
	
}

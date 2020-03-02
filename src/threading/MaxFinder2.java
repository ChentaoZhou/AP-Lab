package threading;

public class MaxFinder2 implements Runnable {
	Double[] array;
	SharedDouble result;

	public MaxFinder2(Double[] array, SharedDouble result) {
		this.array = array;
		this.result = result;
	}

	public void run() {
		double max = 0;
		for (int i = 0; i < array.length; i++) {
			if(max < array[i]) max = array[i];
		}
		System.out.println("max:"+max);
		result.compare(max);
	}
	  
	/** (5) version **/
//	public void run() {
//		for (int i = 0; i < array.length; i++) {
//			if (result.getD() < array[i]) {
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				result.setD(array[i]);
//			}
//		}
//	}
}

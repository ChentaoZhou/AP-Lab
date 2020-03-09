package threading;

import java.util.Arrays;

public class FindAmaxValue {
	
	public static void main(String[] args) {
		int nRows = 100;
		int nCols = 50;
//		Double[] result = new Double[100];
		SharedDouble sd = new SharedDouble();
		Double[][] randArray = new Double[nRows][nCols];
		for (int r = 0; r < nRows; r++) {
			for (int c = 0; c < nCols; c++) {
				randArray[r][c] = Math.random();
			}
		}
		
		for(int i=0;i<nRows;i++) {
			MaxFinder2 m = new MaxFinder2(randArray[i],sd);
			Thread t = new Thread(m);
			t.start();
		}
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Threading: "+sd.getD());
		
		
		
		
		
		
		
		
		
		/** the original version (2)**/
		
//		for(int i=0;i<nRows;i++) {
//			MaxFinder2 m = new MaxFinder2(randArray[i],sd);
//			Thread t = new Thread(m);
//			t.start();
//			try {
//				t.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		//System.out.println(Arrays.toString(result)); 
//		
//		Thread t = new Thread(new MaxFinder2(result,result,0));
//		t.start();
//		System.out.println("Threading: "+result[0]);
		
		
		
		
		
		
		
		double bigest = 0;
		for(int i =0;i<nRows;i++) {
			for(int j=0;j<nCols;j++) {
				if(bigest < randArray[i][j]) 
					bigest =randArray[i][j];
			}
		}
		System.out.println("No thread: "+bigest);
	}
}

package threading;

import java.util.Random;

public class MiniThread implements Runnable{

	public void run() {
		Random r = new Random();
		int n = r.nextInt(3000);
		try {
			Thread.sleep(n);
			System.out.println("Sorry, "+Thread.currentThread().getName()+" have slept for a while.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		MiniThread m = new MiniThread();
//		MiniThread m2 = new MiniThread();
//		MiniThread m3 = new MiniThread();
//		MiniThread m4 = new MiniThread();
		Thread t = new Thread(m,"1st");
		Thread t2 = new Thread(m,"2nd");
		Thread t3 = new Thread(m,"3rd");
		Thread t4 = new Thread(m,"4th");
		t.start();
		t2.start();
		t3.start();
		t4.start();
		System.out.println("I am the Main, I have started all threads");
		try {
			t.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("I am the Main, I finished my job and wite all of them.");
	}
}

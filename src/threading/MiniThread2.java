package threading;

public class MiniThread2 extends Thread{
	public void run() {
		int n = (int) (Math.random()*2000);
		//System.out.println(n);
		try {
			Thread.sleep(n);
			System.out.println("Sorry, I have slept for a while.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Thread t = new MiniThread2();
		t.start();
	}
}

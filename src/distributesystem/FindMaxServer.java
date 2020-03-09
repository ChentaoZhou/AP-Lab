package distributesystem;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FindMaxServer {
	private static int PORT = 8888;
	private static Socket client;
	private static ServerSocket listener;
	
	public static void main(String[] args) {
		try {
			listener = new ServerSocket(PORT);
			while(true) {
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/** inner class**/
	public static class Handler extends Thread{
		private Socket client;
		public Handler(Socket client) {
			this.client = client;
		}
		public void run() {
			
		}
	}
}

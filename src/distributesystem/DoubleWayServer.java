package distributesystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DoubleWayServer {
	private static int PORT = 8766;
	private static Socket client;
	private static ServerSocket listener;

	public static void main(String[] args) throws IOException {
		// create a server object by PORT number
		try {
			listener = new ServerSocket(PORT);
			while (true) {
				new Handler(listener.accept()).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				listener.close();
			} catch (IOException e) {
			}
		}

	}

	/** inner class **/
	public static class Handler extends Thread {
		private Socket client;

		public Handler(Socket socket) {
			client = socket;
		}

		public void run() {
			try {

				System.out.println("New connection started on thread " + this.getName());
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				Scanner s = new Scanner(client.getInputStream());
				while (s.hasNextLine()) {
//					out.println(quotes.get((new Random()).nextInt(quotes.size())));
//					Thread.sleep(5000);
					ArrayList<String> quotes = QuoteLoader.loadQuotes("quotes.txt");
					String line = s.nextLine();
					if(line.equals("MOTIVATEME")) {
						out.println(quotes.get((new Random()).nextInt(quotes.size())));
					}
					String statement = line.substring(0, 8);
					if(statement.equals("ADDQUOTE")) {
						String quote = line.substring(9);
						QuoteLoader.writeQuote(quote);
						out.println("A new quote has been added.");
					}
				}
			}  catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					this.client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

package distributesystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class SimpleServer {
	private static int PORT = 8766;
	public static void main(String[] args) throws IOException {
		//create a server object by PORT number
		ServerSocket listener = new ServerSocket(PORT);
		Socket client = listener.accept();
		
		PrintWriter out = new PrintWriter(client.getOutputStream(),true);
		ArrayList<String> quotes = QuoteLoader.loadQuotes("quotes.txt");
		out.println(quotes.get((new Random()).nextInt(quotes.size())));
		
		client.close();
	}
}

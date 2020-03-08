package distributesystem;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Writer implements Runnable{
	private Socket socket;
	public Writer(Socket s) {
		socket = s;
	}
	public void run() {
		try {
			Scanner sc = new Scanner(System.in);
			OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
			String line;
			ArrayList<String> quotes = QuoteLoader.loadQuotes("quotes.txt");
			while((line = sc.nextLine()).equals("MOTIVATEME")) {
				os.write(quotes.get((new Random()).nextInt(quotes.size()))+ '\n');
				os.flush();
			}
			sc.close();
			os.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

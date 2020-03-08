package distributesystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DoubleWayClient {
	private static int PORT = 8766;
	private static String server = "127.0.0.1";
	private static Socket socket;
	private static Scanner reader;
	

	public static void main(String[] args) throws IOException {
		try {
			Scanner s = new Scanner(System.in);
			socket = new Socket(server, PORT);
			reader = new Scanner(socket.getInputStream());
			while(s.hasNextLine()) {
				String line = s.nextLine();
				PrintWriter out = new PrintWriter(socket.getOutputStream()); 
				out.println(line);
				out.flush();
				
				if(reader.hasNextLine()) {
					System.out.println(reader.nextLine());
				}
			}
//			while (reader.hasNextLine()) {
//				System.out.println(reader.nextLine());
//			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}
}

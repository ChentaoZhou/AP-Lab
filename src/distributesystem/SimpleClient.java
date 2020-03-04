package distributesystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {
	private static int PORT = 8766;
	private static String server = "127.0.0.1";
	private static Socket socket;
	private static Scanner reader;

	public static void main(String[] args) throws IOException {
		try {
			socket = new Socket(server, PORT);
			reader = new Scanner(socket.getInputStream());
			while (reader.hasNextLine()) {
				System.out.println(reader.nextLine());
			}
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

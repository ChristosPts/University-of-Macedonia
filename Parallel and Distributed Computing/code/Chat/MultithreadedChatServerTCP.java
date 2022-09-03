import java.net.*;
import java.io.*;

public class MultithreadedChatServerTCP {
	private static final int PORT = 1234;
	
	public static void main(String args[]) throws IOException {

		ServerSocket connectionSocket = connectionSocket = new ServerSocket(PORT);
		
		while (true) {	

			System.out.println("Server is waiting first client in port: " + PORT);
			Socket dataSocket1 = connectionSocket.accept();
			System.out.println("Received request from " + dataSocket1.getInetAddress());
			System.out.println("Server is waiting second client in port: " + PORT);
			Socket dataSocket2 = connectionSocket.accept();
			System.out.println("Received request from " + dataSocket2.getInetAddress());

			ServerThread sthread1 = new ServerThread(dataSocket1, dataSocket2);
			sthread1.start();
			ServerThread sthread2 = new ServerThread(dataSocket2, dataSocket1);
			sthread2.start();
		}
	}
}



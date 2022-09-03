import java.io.*;
import java.net.*;

public class Client { 
   private static final String HOST = "localhost";
   private static final int PORT = 1234;

   public static void main(String[] arg) throws IOException, ClassNotFoundException {
           
	 Socket socketConnection = new Socket(HOST, PORT);

	 ObjectOutputStream clientOutputStream = new
		ObjectOutputStream(socketConnection.getOutputStream());
	 ObjectInputStream clientInputStream = new 
		ObjectInputStream(socketConnection.getInputStream());

	 Request req = new Request("MUL", 5, 6);

	 clientOutputStream.writeObject(req);
	 Reply rep = (Reply)clientInputStream.readObject();

	 System.out.println("Reply opcode = " + rep .getOpcode());
	 System.out.println("Reply value = " + rep .getValue());
	 
	 clientOutputStream.close();
	 clientInputStream.close();

	 socketConnection.close();
   }
}


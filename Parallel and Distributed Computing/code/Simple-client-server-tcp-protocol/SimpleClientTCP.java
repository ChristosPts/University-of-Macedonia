import java.net.*;
import java.io.*;
public class SimpleClientTCP {
        private static final String HOST = "localhost";
	private static final int PORT = 1234;
	
	public static void main(String args[]) throws IOException {

		//InetAddress address = InetAddress.getByName(HOST);
		Socket dataSocket = new Socket(HOST, PORT);
        	
		InputStream is = dataSocket.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		OutputStream os = dataSocket.getOutputStream();
		PrintWriter out = new PrintWriter(os,true);
		

		
		System.out.println("Connection to " + HOST + " established");

		String inmsg, outmsg;
		ClientProtocol app = new ClientProtocol();
		
		outmsg = app.prepareRequest();
		out.println(outmsg);
		inmsg = in.readLine();
		app.processReply(inmsg);
               

		dataSocket.close();
		System.out.println("Data Socket closed");
	}
}			


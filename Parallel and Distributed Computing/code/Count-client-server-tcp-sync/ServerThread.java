import java.io.*;
import java.net.*;

class ServerThread extends Thread
{
	private Socket dataSocket;
	private InputStream is;
   	private BufferedReader in;
	private OutputStream os;
   	private PrintWriter out;
	private Count count;

   	public ServerThread(Socket socket, Count c)
   	{
		dataSocket = socket;
		try {
			is = dataSocket.getInputStream();
			in = new BufferedReader(new InputStreamReader(is));
			os = dataSocket.getOutputStream();
			out = new PrintWriter(os,true);
			count = c;
		}
		catch (IOException e)	{		
			System.out.println("I/O Error " + e);
		}
	}
	
	public void run()
	{
   		String inmsg, outmsg;
		
		try {
			inmsg = in.readLine();
			ServerProtocol app = new ServerProtocol(count);
			outmsg = app.processRequest(inmsg);
			while (!outmsg.equals("EXIT")) {
				out.println(outmsg);
				inmsg = in.readLine();
				outmsg = app.processRequest(inmsg);		
			}	
			dataSocket.close();	

		} catch (IOException e)	{		
	 		System.out.println("I/O Error " + e);
		}
	}	
}	
			
		

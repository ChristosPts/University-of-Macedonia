import java.net.*;
import java.io.*;

public class MasterProtocol {

	private Sum mySum;
	private int myId;

	public MasterProtocol (Sum s, int id) {
		
		mySum = s;
		myId = id;
	}

	public String prepareRequest() {
	 
		String theOutput = mySum.printInit() + " " + String.valueOf(myId);
		return theOutput;
	}
	
	public void processReply(String theInput) {
	
		int repl = Integer.parseInt(theInput);
		mySum.addTo(repl);
	}	
}

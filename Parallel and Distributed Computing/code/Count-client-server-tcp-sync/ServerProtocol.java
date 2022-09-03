import java.net.*;
import java.io.*;

public class ServerProtocol {

	private Count counter;

	public ServerProtocol (Count c) {
		
		counter = c;
        }

	public String processRequest(String theInput) {
	 
        String theOutput;
		if (theInput.equals("INC ")) {
			counter.increment();
			theOutput = theInput + counter.print();
		} else  theOutput = theInput;	
		return theOutput;
	}
}

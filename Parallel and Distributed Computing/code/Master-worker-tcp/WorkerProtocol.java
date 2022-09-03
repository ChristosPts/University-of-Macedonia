import java.net.*;
import java.io.*;

public class WorkerProtocol {

	private int numWorkers;
	
	public WorkerProtocol(int num) {
		numWorkers = num;
	}	

	public String compute(String theInput) throws IOException {
	
		String[] splited = theInput.split("\\s+");
		int range = Integer.parseInt(splited[0]);
		int id = Integer.parseInt(splited[1]);
		
		System.out.println("Worker "+ id +" calculates");
		
		int block = range / numWorkers;
		int start = id * block;
		int stop = start + block;
		if (id == numWorkers-1) stop = range;
		
		int sum = 0;
		for (int i=start; i<stop; i++)
			sum += i;
			
		String theOutput = String.valueOf(sum);	
		return theOutput;
	}
}

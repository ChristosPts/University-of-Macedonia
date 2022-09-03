import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.*;
import java.util.*;

class soeExecutor{
	public static void main(String[] args){  
		
                int size = 0;
				int blockSize = 0;
				
                if (args.length != 2) {
					System.out.println("Usage: java SieveOfEratosthenes <size> <number of threads>");
					System.exit(1);
				}
				try {
					size = Integer.parseInt(args[0]);
					blockSize = Integer.parseInt(args[1]);
				}
			    catch (NumberFormatException nfe) {
					System.out.println("Integer argument expected");
					System.exit(1);
				}
		
		   if (blockSize == 0)//++
			   blockSize = Runtime.getRuntime().availableProcessors();
			
		   if (size <= 0) {
			   System.out.println("size should be positive integer");
			   System.exit(1);
				}
		
		// number of cpus
			int cores = Runtime.getRuntime().availableProcessors();
			System.out.println("cores = " + cores);
			
				if (blockSize == 0) blockSize = 1;
				
				int numTasks = size / blockSize;
				if ((size % blockSize) != 0) numTasks++;


			boolean[] prime = new boolean[size];
				  for(int i = 0; i <size; i++){
					   prime[i] = true; 		
				  
				  }
				  
			// get current time 
			long start = System.currentTimeMillis();			   
			
		// task creation 
		SqrtGroupTask tasks[] = new SqrtGroupTask[numTasks];
		
		ExecutorService executor = Executors.newFixedThreadPool(cores);
        	for (int i = 0; i < numTasks; i++) {
	    		tasks[i] = new SqrtGroupTask(i,blockSize, prime, size);
            		//System.out.println("A new task has been added in the queue: " + i);
            		executor.execute(tasks[i]);
        	}
       		try {
    	   		executor.shutdown();
    	   		executor.awaitTermination(20, TimeUnit.SECONDS);
			}
			catch (InterruptedException e) {
					System.err.println("tasks interrupted");
			}
			finally {
    			if (!executor.isTerminated()) {
        			System.err.println("cancel non-finished tasks");
    			}	
    			executor.shutdownNow();
       	 	}
			
			// get current time and calculate elapsed time
			long elapsedTimeMillis = System.currentTimeMillis()-start;

			int count = 0;
			for(int i = 0; i < size; i++) 
				if (prime[i] == true) {
					//System.out.println(i); 
					count++;
				}	
				
			System.out.println("number of primes "+count); 
			System.out.println("time in ms = "+ elapsedTimeMillis);
	}

}

class SqrtGroupTask implements Runnable{
	private boolean table[];
	private int iX;
	private int blockSize;
	private int size;
	private int limit;
	
	//constructor
	public SqrtGroupTask(int i, int block, boolean array[], int size){
		table = array;
		this.size = size;
		iX = i;
		limit = (int)Math.sqrt(size)+1;
		blockSize = block;
		
	}
	
	public void run(){
		  
		  int myFrom =0;
		  int myTo =0;
		  
		  myFrom = iX*blockSize;
		  myTo = myFrom + blockSize;
		  
		  if(myTo>limit) 
			  myTo = limit;
		  
			for (int p = myFrom; p <myTo; p++){
				if(p>=2)
					if(table[p]==true){
					// Update all multiples of p
					for (int i = p*p; i <= size; i += p)
						table[i] = false;
					}
				}
			}
}
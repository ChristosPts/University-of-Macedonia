/*
 * Not recommended ...to be avoided: too clever !!
*/
   
public class SimpleProgramWithThreadsSharedStaticSyncMethod {

    public static void main(String[] args) {

        int numThreads = 1;  

        if (args.length != 1) {
	    System.out.println("Usage: java SimpleProgramWithThreadsSharedStaticSync <number of threads>");
	    System.exit(1);
	}

	try {
	    numThreads = Integer.parseInt(args[0]);
	}
	catch (NumberFormatException nfe) {
	    System.out.println("Integer argument expected");
	    System.exit(1);
	}

	CounterThread counterThreads[] = new CounterThread[numThreads];
	for (int i = 0; i < numThreads; i++) {
	    counterThreads[i] = new CounterThread(i);
	    counterThreads[i].start();
	}

        for (int i = 0; i < numThreads; i++) {
            try {
	        counterThreads[i].join();
            }
            catch (InterruptedException e) {}
	} 
        System.out.println("n = "+CounterThread.n); 
    }
    
}    

class CounterThread extends Thread {
        
	static int n = 0;  	
	int threadID;
	    
	public CounterThread(int tid) {
	    this.threadID = tid;
	}
	  	
	public void run() {

	    for (int i = 0; i < 10000; i++) 
	            inc();
	            
	}
	    
	static synchronized void inc() { 
	       n = n + 1;   
	}
}
	
	
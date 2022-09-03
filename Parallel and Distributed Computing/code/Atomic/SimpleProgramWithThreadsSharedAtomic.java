import java.util.concurrent.atomic.AtomicInteger;
   
public class SimpleProgramWithThreadsSharedAtomic {

    static AtomicInteger n = new AtomicInteger(0);

    public static void main(String[] args) {

        int numThreads = 2;  

        if (args.length != 1) {
	    System.out.println("Usage: java SimpleProgramWithThreadsSharedAtomic <number of threads>");
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
        System.out.println("n = "+n); 
    }

    static class CounterThread extends Thread {
	  	
	int threadID;
	    
	public CounterThread(int tid) {
	    this.threadID = tid;
	}
	  	
	public void run() {
	  
	    for (int i = 0; i < 10000; i++) 
	    	n.getAndIncrement();    
	    
	}
    }
}	
	
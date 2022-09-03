import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleProgramWithThreadsSharedLockInner {

    static int n = 0;
    static Lock lock = new ReentrantLock();
    
    public static void main(String[] args) {

        int numThreads = 1;  

        if (args.length != 1) {
	    System.out.println("Usage: java SimpleProgramWithThreadsSharedLockInner <number of threads>");
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

	    for (int i = 0; i < 10000; i++) {
	        lock.lock();
			try { 
			    n = n + 1;
		    	} finally {
					lock.unlock() ;
				}
	        }	
		}
    }
}	
	

// A hack: something between lock and synchronized
  
public class SimpleProgramWithThreadsSharedSyncLockObj {

    public static void main(String[] args) {

        int numThreads = 2;  

        if (args.length != 1) {
	    System.out.println("Usage: java SimpleProgramWithThreadsSharedSyncLockObj <number of threads>");
	    System.exit(1);
		}
	
		try {
		    numThreads = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException nfe) {
		    System.out.println("Integer argument expected");
		    System.exit(1);
		}
	
	        SharedCounter counter = new SharedCounter();
	
		CounterThread counterThreads[] = new CounterThread[numThreads];
		for (int i = 0; i < numThreads; i++) {
		    counterThreads[i] = new CounterThread(i, counter);
		    counterThreads[i].start();
		}
	
        for (int i = 0; i < numThreads; i++) {
            try {
	        counterThreads[i].join();
            }
            catch (InterruptedException e) {}
		} 
        counter.print1();
        counter.print2();
    }

}

class SharedCounter {

    int n1;
    int n2;
    Object lock1 = new Object();
    Object lock2 = new Object();
  
    public SharedCounter (){
	this.n1 = 0;
        this.n2 = 0;
    }

    public void inc1() {
		synchronized (lock1) {
			n1 = n1 + 1;
        }
    }

    public void inc2() {
        synchronized (lock2) {
		    n2 = n2 + 1;
        }
    }
   
    public void print1 () {
		synchronized (lock1) {
	       	System.out.println("The value of n1 is " + n1);
		}
    }

    public void print2 () {
		synchronized (lock2) {
	       	System.out.println("The value of n2 is " + n1);
		}
    }

}


class CounterThread extends Thread {
  	
    int threadID; 
    SharedCounter count;
    
    public CounterThread(int tid, SharedCounter counter) {
        this.threadID = tid;
        this.count = counter;
    }
  	
    public void run() {
  
        for (int i = 0; i < 10000; i++) {
            count.inc1();
            count.inc2();
		}
    }
}


public class SimpleProgramWithThreadsSharedObj {

    public static void main(String[] args) {

        int numThreads = 1;  

        if (args.length != 1) {
		    System.out.println("Usage: java SimpleProgramWithThreadsSharedObj <number of threads>");
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
        System.out.println("n = "+counter.n); 
    }

}

class SharedCounter {

    int n;
    
    public SharedCounter (){
		this.n = 0;
    }
    
    public void inc() {
        n = n +1;
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
           	    count.inc();
		}
		System.out.println("Thread "+threadID+ " n = "+count.n); 
    }
}

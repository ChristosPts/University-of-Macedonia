
public class ThreadsValueArgument {

    public static void main(String[] args) {

        int numThreads = 1;  

        if (args.length != 1) {
		    System.out.println("Usage: java ThreadsValueArgument <number of threads>");
		    System.exit(1);
		}
	
		try {
		    numThreads = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException nfe) {
		    System.out.println("Integer argument expected");
		    System.exit(1);
		}
	
	    int n = 0;
		CounterThread counterThreads[] = new CounterThread[numThreads];
		for (int i = 0; i < numThreads; i++) {
		    counterThreads[i] = new CounterThread(i, n);
		    counterThreads[i].start();
		}
	
        for (int i = 0; i < numThreads; i++) {
            try {
				counterThreads[i].join();
				n += counterThreads[i].threadN;
            }
            catch (InterruptedException e) {}
		} 
		System.out.println("Main n = "+n); 
    }

}

class CounterThread extends Thread {
  	
    int threadID;
    int threadN; 
    
    public CounterThread(int tid, int n) {
        this.threadID = tid;
        this.threadN = n;
    }
  	
    public void run() {
              
        threadN = threadN + 1 + threadID;
        System.out.println("Thread "+threadID+ " n = "+threadN); 
    }
}

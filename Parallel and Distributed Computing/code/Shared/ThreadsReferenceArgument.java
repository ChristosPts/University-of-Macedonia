
   
public class ThreadsReferenceArgument {

    public static void main(String[] args) {

        int numThreads = 1;  
        

        if (args.length != 1) {
		    System.out.println("Usage: java ThreadsReferenceArgument <number of threads>");
		    System.exit(1);
		}
	
		try {
		    numThreads = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException nfe) {
		    System.out.println("Integer argument expected");
		    System.exit(1);
		}
		
	    int[] n = new int[numThreads];
	    for (int i = 0; i < numThreads; i++)
			n[i] = 0; 
		
		CounterThread counterThreads[] = new CounterThread[numThreads];
		for (int i = 0; i < numThreads; i++) {
		    counterThreads[i] = new CounterThread(i, n);
		    counterThreads[i].start();
		}

        for (int i = 0; i < numThreads; i++) {
            try {
				counterThreads[i].join();
            }
            catch (InterruptedException e) {}
		}
		for (int i = 0; i < numThreads; i++)
			System.out.println("n["+i+"] = "+n[i]); 	
    }

}

class CounterThread extends Thread {
  	
    int threadID;
    int[] n;
    
    public CounterThread(int tid, int[] narg) {
        this.threadID = tid;
        this.n = narg;
    }
  	
    public void run() {
        
        n[threadID] = n[threadID] + 1 + threadID ;
        System.out.println("Thread "+threadID+ " my n = "+n[threadID]); 
    }
}

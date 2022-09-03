
   
public class ThreadsGlobalVariables {

    static int n = 0; 
    static int[] a;

    public static void main(String[] args) {

        int numThreads = 1;  

        if (args.length != 1) {
		    System.out.println("Usage: java ThreadsGlobalVariables <number of threads>");
		    System.exit(1);
		}
	
		try {
		    numThreads = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException nfe) {
		    System.out.println("Integer argument expected");
		    System.exit(1);
		}
		
	    a = new int[numThreads];
	    
	    for (int i = 0; i < numThreads; i++)
			a[i] = 0; 
			
		CounterThread counterThreads[] = new CounterThread[numThreads];
		for (int i = 0; i < numThreads; i++) {
		    counterThreads[i] = new CounterThread(i);
		    counterThreads[i].start();
		}

        for (int i = 0; i < numThreads; i++) {
            try {
				counterThreads[i].join();
				n = n + counterThreads[i].threadN;
            }
            catch (InterruptedException e) {}
		} 
        for (int i = 0; i < numThreads; i++)
			System.out.println("a["+i+"] = "+a[i]);
			
		System.out.println("n = "+n); 
    }

	static class CounterThread extends Thread {
	  	
	    int threadID;
	    int threadN;
	    
	    public CounterThread(int tid) {
	        this.threadID = tid;
	        this.threadN = n;
	    }
	  	
	    public void run() {
	  
	        threadN = threadN + 1 + threadID;  
	        a[threadID] = a[threadID] + 1 + threadID;
			System.out.println("Thread "+threadID+" n = "+ threadN +"  a["+threadID+"] ="+ a[threadID]); 
	    }
	}
}	

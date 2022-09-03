
   
public class ThreadsSharedObject {

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
		
		SharedCounter count = new SharedCounter(numThreads);
			
		CounterThread counterThreads[] = new CounterThread[numThreads];
		for (int i = 0; i < numThreads; i++) {
		    counterThreads[i] = new CounterThread(i, count);
		    counterThreads[i].start();
		}

        for (int i = 0; i < numThreads; i++) {
            try {
				counterThreads[i].join();
				count.n = count.n + counterThreads[i].threadN;
            }
            catch (InterruptedException e) {}
		} 
        for (int i = 0; i < numThreads; i++)
			System.out.println("a["+i+"] = "+count.a[i]);
			
		System.out.println("n = "+count.n); 
    }
}
class SharedCounter {
	
	static int n; 
    static int[] a;
    
    public SharedCounter (int numThreads) {
		
			this.n = 0;
			this.a = new int[numThreads];
	    
			for (int i = 0; i < numThreads; i++)
				this.a[i] = 0; 
	}		

}    

class CounterThread extends Thread {
  	
    int threadID;
    int threadN;
    SharedCounter threadCount;
    
    public CounterThread(int tid, SharedCounter c) {
        this.threadID = tid;
        this.threadCount = c;
        this.threadN = threadCount.n;
        
    }
  	
    public void run() {
  
        threadN = threadN + 1 + threadID;  
        threadCount.a[threadID] = threadCount.a[threadID] + 1 + threadID;
		System.out.println("Thread "+threadID+" n = "+ threadN +"  a["+threadID+"] ="+ threadCount.a[threadID]); 
    }
}


// Wrong result: n is method variable
   
public class SimpleProgramWithThreadsMethodVar {

    public static void main(String[] args) {

        int numThreads = 1;  

        if (args.length != 1) {
		    System.out.println("Usage: java SimpleProgramWithThreads <number of threads>");
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
    }

}

class CounterThread extends Thread {
  	
    int threadID;
    
    public CounterThread(int tid) {
        this.threadID = tid;
    }
  	
    public void run() {
    
        int n = 0; 
        
        for (int i = 0; i < 10000; i++) {
            n = n + 1;
		}
        System.out.println("Thread "+threadID+ " n = "+n); 
    }
}

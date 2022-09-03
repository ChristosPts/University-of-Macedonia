// Wrong result: n is passed as a value argument
   
public class SimpleProgramWithThreadsValueArg {

    public static void main(String[] args) {

        int numThreads = 1;  
        int n = 0;

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
		    counterThreads[i] = new CounterThread(i, n);
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

}

class CounterThread extends Thread {
  	
    int threadID;
    int n;
    
    public CounterThread(int tid, int narg) {
        this.threadID = tid;
        this.n = narg;
    }
  	
    public void run() {
        
        for (int i = 0; i < 10000; i++) {
            n = n + 1;
		}
        System.out.println("Thread "+threadID+ " n = "+n); 
    }
}

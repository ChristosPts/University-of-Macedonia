import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedCounterWhile1{
  
    static int end = 10000;
    static int counter = 0;
    static int[] array = new int[end];
    static int numThreads = 4;
	static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
		
		if(args.length !=1){
			System.out.println("Please give threads");
			System.exit(1);
		}
	
		try{
			numThreads = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException  nfe){
			System.out.println("Integer Expected");
			System.exit(1);
		}
		
		if(numThreads<=0){
			System.out.println("Positive integer expected");
			System.exit(1);
		}
		
		
        CounterThread threads[] = new CounterThread[numThreads];
	
		for (int i = 0; i < numThreads; i++) {
			threads[i] = new CounterThread();
			threads[i].start();
		}
	
		for (int i = 0; i < numThreads; i++) {
			try {
				threads[i].join();
			}
			catch (InterruptedException e) {}
		} 
        check_array ();
    }
     
    static void check_array ()  {
		int i, errors = 0;

		System.out.println ("Checking...");

        for (i = 0; i < end; i++) {
			if (array[i] != 1) {
				errors++;
				System.out.printf("%d: %d should be 1\n", i, array[i]);
			}         
		}
        System.out.println (errors+" errors.");
    }


    static class CounterThread extends Thread {
  	
       public CounterThread() {
       }
  	
       public void run() {
		lock.lock();
		try {
            while (true) {
				if (counter >= end) 
                	break;
            	array[counter]++;
				counter++;	} 
			} finally {
			lock.unlock() ;
				}
            
		}            	
    }
}
  

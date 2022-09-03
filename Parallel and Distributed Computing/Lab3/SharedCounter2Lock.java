import java.util.concurrent.locks.*;

public class SharedCounter2{
  
    static int end = 1000;
    static int[] array = new int[end];
    static int numThreads = 0;
	static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

		if(args.length !=1){
			System.out.println("<number of threads>");
			System.exit(1);
		}
		
		try{
			numThreads = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException nfe){
			System.out.println("<number of threads> nees to be positive int");
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
			if (array[i] != numThreads*i) {
				errors++;
				System.out.printf("%d: %d should be %d\n", i, array[i], numThreads*i);
			}         
        }
        System.out.println (errors+" errors.");
    }


    static class CounterThread extends Thread {
  	
       public CounterThread() {
       }
  	
       public void run() {
  
            for (int i = 0; i < end; i++) {
				for (int j = 0; j < i; j++){
				lock.lock();
					try {
					array[i]++;	
					} finally {
						lock.unlock();
					}	
				}	
            } 
		}            	
    }
}
  

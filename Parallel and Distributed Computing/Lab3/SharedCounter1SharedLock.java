import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SharedCounter1{
    public static void main(String[] args) {

		int end = 1000;
		int[] array = new int[end];
		int numThreads = 0;

		if(args.length != 1){
			System.out.println("Please give <Number of Threads>");
			System.exit(1);
		}
		try{
			numThreads = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException nfe){
			System.out.println("Positive integer expected");
			System.exit(1);
		}
		
		if ( numThreads <= 0) { System.out.println("Positive integer expected");
			System.exit(1);
		}
		
		Thread threads[] = new Thread[numThreads];
		SharedCounter counter = new SharedCounter();
		
		for (int i = 0; i < numThreads; i++) {
			threads[i] = new CounterThread(end,array);
			threads[i].start();
		}
	
		for (int i = 0; i < numThreads; i++) {
			try {
				threads[i].join();
			}
			catch (InterruptedException e) {}
		} 
		check_array checker = new check_array (numThreads,end,array);
		System.out.println(checker.i +  checker.array[i] + "should be " + checker.numThreads*checker.i);
		  System.err.println(" errors:" + checker.errors );
    }
}


 class check_array{
		private int numThreads, end;
		private int  array[];
		int n;
		
		public check_array(int numThreads,int end, int array[]){
			this.numThreads = numThreads;
			this.end = end;
			this.array = array;
			
		
		}
	
	public void run() {	
		System.out.println("Checking...");
		int errors = 0;
        for (int i = 0; i < end; i++) {
		
			if (array[i] != numThreads*i) {
				errors++;
			   
        }
     
    }
 }
 }

class SharedCounter {

    int n;
    Lock lock = new ReentrantLock();

    public SharedCounter (){
		this.n = 0;
    }
}



class CounterThread extends Thread {
  	
		private int finale;
		private int table[];
		SharedCounter count;
		
       public CounterThread(int finale, int table[],SharedCounter counter) {
		   this.finale = finale;
		   this.table = table;
		   this.count = counter;
       }
  	
       public void run() {
  
            for (int i = 0; i < finale; i++) {
				for (int j = 0; j < i; j++){
			count.lock.lock();
				try {
					table[i]++;		
					} finally {
				count.lock.unlock() ;
            }
				}
            } 
		}            	
    }

  

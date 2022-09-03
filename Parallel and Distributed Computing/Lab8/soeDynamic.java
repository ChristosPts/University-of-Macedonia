import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class soeDynamic{
	
	static int totalTasks = 0;; 
	static int nThreads = 0; 
	static int tasksAssigned = -1; 
	static Lock lock = new ReentrantLock();
	
	public static void main(String[] args){  
	 ;
//-----------------------------------------------------------------------------------------------------------------			
                if (args.length != 2) {
	    		System.out.println("Usage: java SieveOfEratosthenes <size> <number of threads>");
	    		System.exit(1);
				}

				try {
					totalTasks = Integer.parseInt(args[0]);
					nThreads = Integer.parseInt(args[0]);
				}
				
				catch (NumberFormatException nfe) {
					System.out.println("Integer argument expected");
					System.exit(1);
				}
						
					if (nThreads == 0)
						nThreads = Runtime.getRuntime().availableProcessors();//++
				
					if (totalTasks <= 0) {
						System.out.println("size should be positive integer");
						System.exit(1);
				}
				

			boolean[] prime = new boolean[totalTasks+1];
			
			for(int i = 0; i < totalTasks+1; i++)
						prime[i] = true; 		

			// get current time 
			long start = System.currentTimeMillis();
			
					    //Create threads ++	
			Thread[] threads = new Thread[nThreads];
			for (int i = 0; i < threads.length; ++i){
				threads[i] = new Thread(new Worker(prime,i));
			}	
			
			//Start threads ++
			for (int i = 0; i < threads.length; ++i){
			threads[i].start();
		    }
			
		    // wait for threads to terminate ++
			for (int i = 0; i < threads.length; ++i){
			try {
				threads[i].join();
			}
			catch (InterruptedException e){
				System.err.println("this should not happen");}
			}	
			      
			// get current time and calculate elapsed time
			long elapsedTimeMillis = System.currentTimeMillis()-start;

			int count = 0;
			 for(int i = 0; i < totalTasks+1; i++) 
				if (prime[i] == true) {
					//System.out.println(i); 
					count++;
				}	
				
			System.out.println("number of primes "+count); 
			System.out.println("time in ms = "+ elapsedTimeMillis);
					
	}
	
	//  Κρίσιμo τμήμα για την διανομή εργασιών
	private static int getTask()
	{
	        lock.lock();
	        try {
		int limit = (int)Math.sqrt(totalTasks) + 1;
		// Διανέμει μια εργασία (στοιχείο πίνακα) 
			if (++tasksAssigned < limit) 
				return tasksAssigned;
			else
				return -1;
	        } finally {
	        	lock.unlock() ;
	        }			
	}


private static class Worker implements Runnable	{
		private int iX;
		private boolean table[];

		public Worker(boolean array [], int i){
			this.iX = iX;
			table = array;
		}

		public void run(){
			
			int p;
			while (( p = getTask()) >= 0){
					if(p>=2){
						//System.out.println("worker " + iX + " received " + p);
						if(table[p] == true){
					// Update all multiples of p
					for (int i = p*p; i <= totalTasks; i += p)
						table[i] = false;}
						}
						//System.out.println("worker " + iX + " done");
					   }
			
					}//run
			
		}
	}





			
			
				
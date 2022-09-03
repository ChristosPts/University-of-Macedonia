class soeCyclic{
	public static void main(String[] args){  		
		
		int size = 0;
		int numThreads = 0;
		
		  if (args.length != 2) { 
			System.out.println("Usage: java SieveOfEratosthenes <size> <number of threads>");
			System.exit(1);
			}			
		try {
			size = Integer.parseInt(args[0]);
			numThreads = Integer.parseInt(args[1]);
			}
		catch (NumberFormatException nfe) {
			 System.out.println("Integer argument expected");
			 System.exit(1);
				}
			
			if (numThreads == 0)
				numThreads = Runtime.getRuntime().availableProcessors();
			
			if (size <= 0) {
				System.out.println("size should be positive integer");
				System.exit(1);
			}

			boolean[] prime = new boolean[size+1];

			for(int i = 0; i < size+1; i++)
						prime[i] = true; 		


			// get current time 
			long start = System.currentTimeMillis();
					
					
			//Create threads ++
			soeCyclicThreads threads[] = new soeCyclicThreads[numThreads];
			
			for(int i = 0; i< numThreads; i++){
				threads[i] = new soeCyclicThreads(i,numThreads, prime, size);
				threads[i].start();
			}
			
			// wait for threads to terminate 
			for(int i = 0; i< numThreads; i++){
				try{
					threads[i].join();
				}catch (InterruptedException e){}
			}

	
				// get current time and calculate elapsed time
				long elapsedTimeMillis = System.currentTimeMillis()-start;

				int count = 0;
				for(int i = 0; i < size+1; i++) 
					if (prime[i] == true) {
						//System.out.println(i); 
						count++;
					}	
						
				System.out.println("number of primes "+count); 
				System.out.println("time in ms = "+ elapsedTimeMillis);
	}

}


class soeCyclicThreads extends Thread{
	
	private boolean table[];
	private int size;
	private int numThreads;
	private int iX;
	
	//constructor
	public soeCyclicThreads(int i, int numThreads, boolean prime[], int size){
		table = prime;
		this.numThreads = numThreads;
		this.size = size;
		iX = i;
		
	}
	
	public void run(){
		int limit = (int)Math.sqrt(size)+1;		
			for (int p = iX; p <= limit; p += numThreads){
				if(p>=2){
					if(table[p]==true){
					// Update all multiples of p
					for (int i = p*p; i <= size; i += p)
						table[i] = false;
					  }
					}
				}
			}
	
}
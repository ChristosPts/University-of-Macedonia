class ThreadParGroupSqrt
{
	public static void main(String[] args)
	{
        int size = 0;
        int numThreads = 0;
	        
	        
		if (args.length != 2) {
    		System.out.println("Usage: java ThreadParSqrt <vector size> <number of threads>");
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
		if (numThreads == 0) numThreads = Runtime.getRuntime().availableProcessors();
		
		double[] a = new double[size];

		for(int i = 0; i < size; i++)
			a[i] = i;
			//a[i] = Math.random()*size; 
  
		/* for debugging 
		for(int i = 0; i < size; i++) 
			System.out.println(a[i]); */
     
		// get current time
		long start = System.currentTimeMillis();

		// create threads
		SqrtGroupThread threads[] = new SqrtGroupThread[numThreads];
		
		// thread execution   
		for(int i = 0; i < numThreads; i++) 
		{
			threads[i] = new SqrtGroupThread(i, numThreads, a, size);
			threads[i].start();
		}

		// wait for threads to terminate            
		for(int i = 0; i < numThreads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {}
		}

		// get current time and calculate elapsed time
		long elapsedTimeMillis = System.currentTimeMillis()-start;
		System.out.println("time in ms = "+ elapsedTimeMillis);

		/* for debugging 
		for(int i = 0; i < size; i++) 
			System.out.println(a[i]); */

	}
}

class ThreadParArray
{
	public static void main(String[] args)
	{
        int size = 0;
        int numThreads = 0;
	        
	        
		if (args.length != 2) {
    		System.out.println("Usage: java ThreadParArray <vector size> <number of threads>");
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
     		
		double[] tsum = new double[numThreads];
		for(int i = 0; i < numThreads; i++)
			tsum[i] = 0.0;
     
		// get current time
		long start = System.currentTimeMillis();

		// create threads
		VecSumThread threads[] = new VecSumThread[numThreads];
		
		// thread execution   
		for (int i = 0; i < numThreads; i++) 
		{
			threads[i] = new VecSumThread(i, numThreads, tsum, size, a);
			threads[i].start();
		}

		// wait for threads to terminate            
		for (int i = 0; i < numThreads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {}
		}

		double sum = 0.0;
		for (int i = 0; i < numThreads; i++) {
			//System.out.println(tsum[i]);
			sum = sum + tsum[i];
		}

		// get current time and calculate elapsed time
		long elapsedTimeMillis = System.currentTimeMillis()-start;
		System.out.println("time in ms = "+ elapsedTimeMillis);

		System.out.println(sum);

	}
}

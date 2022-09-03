class ThreadParGroupSqrt
{
	public static void main(String[] args)
	{
        int size = 0;
        int numThreads = 0;
        int blockSize = 0;
	          
		if (args.length != 3) {
    		System.out.println("Usage: java ThreadParGroupSqrt <vector size> <block size> <number of threads>");
    		System.exit(1);
		}

		try {
			size = Integer.parseInt(args[0]);
    		blockSize = Integer.parseInt(args[1]);
    		numThreads = Integer.parseInt(args[2]);
		}
		catch (NumberFormatException nfe) {
	   		System.out.println("Integer argument expected");
    		System.exit(1);
		}
		if (numThreads == 0) numThreads = Runtime.getRuntime().availableProcessors();
		
		double[] a = new double[size];
		for(int i = 0; i < size; i++)
			a[i] = i; 
  
        // get current time
		long start = System.currentTimeMillis();
		
		SqrtGroupThread threads[] = new SqrtGroupThread[numThreads];
		
		for(int i = 0; i < numThreads; i++) 
		{
			threads[i] = new SqrtGroupThread(a, i, numThreads, blockSize, size);
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

	}
}

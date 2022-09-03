class SeqVecSumArgsTime
{
	public static void main(String[] args)
	{  
		
		int size = 0;
		if (args.length != 1) {
			System.out.println("Usage: java SeqVecSumArgsTime <vector size>");
			System.exit(1);
		}

		try {
			size = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException nfe) {
	   		System.out.println("Integer argument expected");
	    	System.exit(1);
		}
		if (size <= 0) {
				System.out.println("size should be positive integer");
		System.exit(1);
		}

		double[] a = new double[size];

		for(int i = 0; i < size; i++)
			a[i] = i; 
			//a[i] = Math.random()*size; 
		
         /* for debugging 
		for(int i = 0; i < size; i++) 
			System.out.println(a[i]); */

        double sum = 0.0;

		// get current time 
		long start = System.currentTimeMillis();

		for(int i = 0; i < size; i++) 
			sum = sum + a[i];
               
		// get current time and calculate elapsed time
		long elapsedTimeMillis = System.currentTimeMillis()-start;
		System.out.println("time in ms = "+ elapsedTimeMillis);

		/* for debugging
		System.out.println(sum); */
	}

}

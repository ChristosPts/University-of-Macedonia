class SqrtGroupThread extends Thread
{
	private double [] table;
	private int myrank;
	private int numThreads;
	private int blockSize;
	private int size;
	

	public SqrtGroupThread(double [] array, int rank, int nthreads, int block, int s)
	{
		table = array;
		myrank = rank;
		numThreads = nthreads;
		blockSize = block;
		size = s;
	}

	
	public void run()
	{
		int totalBlockSize = blockSize * numThreads;
		int iterations = size / totalBlockSize; 
		for(int i = 0; i < iterations; i++) {
		   int start = (myrank * blockSize) + (i * totalBlockSize);
		   int stop = start + blockSize;
		   if ((i == iterations - 1) && (myrank == numThreads - 1)) stop = size;
		   for (int j = start; j < stop; j++) {
				// for debugging
				System.out.println(myrank+" "+ start+" "+ stop+" "+j);
				table[j] = Math.sqrt(table[j]);
		   }
		}	
	}
}

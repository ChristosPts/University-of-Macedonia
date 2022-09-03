class SqrtGroupThread extends Thread
{
	private double [] table;
	private int myrank;
	private int numThreads;
	private int size;
	

	public SqrtGroupThread(double [] array, int rank, int nthreads, int s)
	{
		table = array;
		myrank = rank;
		numThreads = nthreads;
		size = s;
	}

	
	public void run()
	{
		for(int i = myrank; i < size; i += numThreads) {
			System.out.println(myrank+" index " + i);
			table[i] = Math.sqrt(table[i]);
		}	
	}
}

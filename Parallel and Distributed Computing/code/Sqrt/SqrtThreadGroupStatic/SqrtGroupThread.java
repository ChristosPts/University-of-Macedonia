class SqrtGroupThread extends Thread
{
	private double [] table;
	private int myStart;
	private int myStop;

	// constructor
	public SqrtGroupThread(int myId, int numThreads, double[] array, int size)
	{
		table = array;
		myStart = myId * (size / numThreads);
		myStop = myStart + (size / numThreads);
		if (myId == (numThreads - 1)) myStop = size;
	}

	// thread code
	public void run()
	{
		for(int i = myStart; i < myStop; i++) 
           	table[i] = Math.sqrt(table[i]);
	}
}

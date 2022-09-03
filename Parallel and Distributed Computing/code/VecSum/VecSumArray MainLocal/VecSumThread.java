class VecSumThread extends Thread
{
	private double [] sums;
	private double [] table;
	private double mySum;
	private int myId;
	private int myStart;
	private int myStop;

	// constructor
	public VecSumThread(int id, int numThreads, double[] ts, int size, double[] array)
	{
		sums = ts;
		table = array;
		mySum = 0.0;
		myId = id;
		myStart = myId * (size / numThreads);
		myStop = myStart + (size / numThreads);
		if (myId == (numThreads - 1)) myStop = size;
	}

	// thread code
	public void run()
	{
		for(int i = myStart; i < myStop; i++) 
			mySum = mySum + table[i];
			
		sums[myId] = mySum;
	}
}

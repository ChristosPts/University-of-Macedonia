class VecSumThread extends Thread
{
	private double [] table;
	private int myId;
	private int myStart;
	private int myStop;

	// constructor
	public VecSumThread(int id, int numThreads, int size, double[] array)
	{
		table = array;
		myId = id;
		myStart = myId * (size / numThreads);
		myStop = myStart + (size / numThreads);
		if (myId == (numThreads - 1)) myStop = size;
	}

	// thread code
	public void run()
	{
		for(int i = myStart; i < myStop; i++) {
			ThreadParArray.lock.lock();
			try {
			     ThreadParArray.sum = ThreadParArray.sum + table[i];
			} finally {
			     ThreadParArray.lock.unlock();
			}
		}
	}

}

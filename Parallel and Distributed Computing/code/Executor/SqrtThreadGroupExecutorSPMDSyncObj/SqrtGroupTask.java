class SqrtGroupTask implements Runnable
{
	private double [] table;
	private globalSum mytotal;
	private int myid;
	private int numThreads;
	private int tableSize;

	// constructor
	public SqrtGroupTask(double [] a, int id, int n, int s, globalSum mt)
	{
		this.table = a;
		this.myid = id;
		this.numThreads = n;
		this.tableSize = s;
		this.mytotal = mt;
	}

	// thread code
	public void run()
	{
        int blockSize = 0;
		int myfrom = 0;
		int myto = 0;
        double mysum = 0.0;
	        
		blockSize = tableSize / numThreads;
		myfrom = myid * blockSize;
		myto = myfrom + blockSize;
		if (myid == numThreads) myto = tableSize;

		for(int i=myfrom; i<myto; i++) {
			mysum += table[i];
			table[i] = Math.sqrt(table[i]);
		}
		mytotal.add(mysum);        
	}
}

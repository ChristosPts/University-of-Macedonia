class SqrtGroupTask implements Runnable
{
	private double [] table;
	private int myid;
	private int numTasks;
	private int tableSize;

	// constructor
	public SqrtGroupTask(double [] a, int id, int n, int s)
	{
		this.table = a;
		this.myid = id;
		this.numTasks = n;
		this.tableSize = s;
	}

	// thread code
	public void run()
	{
        int blockSize = 0;
        int myfrom = 0;
        int myto = 0;
	        
		blockSize = tableSize / numTasks;
		myfrom = myid * blockSize;
		myto = myfrom + blockSize;
		if (myid == numTasks) myto = tableSize;

		for(int i=myfrom; i<myto; i++) 
			table[i] = Math.sqrt(table[i]);
	}
}

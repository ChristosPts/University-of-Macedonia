class SqrtGroupTask implements Runnable
{
	private double [] table;
	private int myid;
	private int tableSize;
	private int blockSize;

	// constructor
	public SqrtGroupTask(double [] a, int id, int s, int block)
	{
		this.table = a;
		this.myid = id;
		this.tableSize = s;
		this.blockSize = block;
	}

	// thread code
	public void run()
	{
        int myfrom = 0;
		int myto = 0;
		
		myfrom = myid * blockSize;
		myto = myfrom + blockSize;
		if (myto > tableSize) myto = tableSize;

		for(int i=myfrom; i<myto; i++) 
			table[i] = Math.sqrt(table[i]);
	}
}

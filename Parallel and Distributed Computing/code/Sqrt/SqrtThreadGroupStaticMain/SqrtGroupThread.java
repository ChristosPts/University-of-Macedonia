class SqrtGroupThread extends Thread
{
	private double [] table;
	private int myfrom;
	private int myto;

	// constructor
	public SqrtGroupThread(double [] array, int from, int to)
	{
		table = array;
		myfrom = from;
		myto = to;
	}

	// thread code
	public void run()
	{
		for(int i=myfrom; i<myto; i++) 
			table[i] = Math.sqrt(table[i]);
	}
}

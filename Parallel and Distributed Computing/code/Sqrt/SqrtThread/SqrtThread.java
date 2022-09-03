class SqrtThread extends Thread
{
	private double [] table;
	private int index;

	// 
	public SqrtThread(double [] array, int ind)
	{
		table = array;
		index = ind;
	}

	//        
	public void run()
	{
		table[index] = Math.sqrt(table[index]);
	}
}
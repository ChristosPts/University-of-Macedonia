class globalSum 
{
	private double sum;

	public globalSum ()
	{
		sum = 0.0;
	}

	public synchronized void add (double partialSum)
	{
	 	sum += partialSum;
	}

	public void print ()
	{
		System.out.println(sum);
	}
}

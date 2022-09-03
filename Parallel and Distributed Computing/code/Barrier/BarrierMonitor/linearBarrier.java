class linearBarrier {
	private int arrived = 0;
	private int totalThreads;
	private boolean waiting = true;
	
	public linearBarrier (int total) {
		this.totalThreads = total;
	}		

	public synchronized void barrier()
	{
		arrived++;
		if (arrived == totalThreads) waiting = false;
		while (waiting)	{
			try  {
				wait();
			}
			catch (InterruptedException e) {};
		}
		arrived--;
		if (arrived == 0) waiting = true;
		notifyAll();
	}
}

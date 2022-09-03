class cyclicBarrier {
	private int arrived = 0;
	private int totalThreads;
	private boolean waiting = true;
	private boolean leaving = false;
	
	public cyclicBarrier (int total) {
		this.totalThreads = total;
	}		

	public synchronized void barrier()
	{
		arrived++;
		if (arrived == totalThreads) {
			waiting = false;
			leaving = true;
		}	
		while (waiting)	{
			try  {
				wait();
			}
			catch (InterruptedException e) {};
		}
		notifyAll();
		arrived--;
		if (arrived == 0) {
			waiting = true;
			leaving = false;
	        }		
	        while (leaving)	{
			try  {
				wait();
			}
			catch (InterruptedException e) {};
		}		
		notifyAll();
	}
}

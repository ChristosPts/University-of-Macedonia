import java.util.concurrent.Semaphore;

class cyclicBarrier {
	private int arrived = 0;
	private int totalThreads;
	private Semaphore mutex = new Semaphore(1);
	private Semaphore waiting = new Semaphore(0);
	private Semaphore leaving = new Semaphore(1);
	
	public cyclicBarrier (int total) {
		this.totalThreads = total;
	}		

	public void barrier() 
	{
        try { mutex.acquire(); } catch (InterruptedException e) {}
		arrived++;
		if (arrived == totalThreads) {
			waiting.release();
			try { leaving.acquire(); } catch (InterruptedException e) {}
		}
		mutex.release();	
		try { waiting.acquire(); } catch (InterruptedException e) {}
		waiting.release();
		try { mutex.acquire();  } catch (InterruptedException e) {}
		arrived--;
		if (arrived == 0) {
			try { waiting.acquire();  } catch (InterruptedException e) {}
			leaving.release();
		}
		mutex.release();
		try { leaving.acquire();  } catch (InterruptedException e) {}
		leaving.release();
	}
}

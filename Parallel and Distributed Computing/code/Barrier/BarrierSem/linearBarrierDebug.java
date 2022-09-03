import java.util.concurrent.Semaphore;

class linearBarrierDebug {
	private int arrived = 0;
	private int totalThreads;
	private Semaphore waiting = new Semaphore(1);
	private Semaphore leaving = new Semaphore(0);
	
	public linearBarrierDebug (int total) {
		this.totalThreads = total;
        }		

	public void barrier()
	{

		Thread currentThread = Thread.currentThread();

		System.out.println("Before **"+ currentThread.getName()) ;
		try {
			waiting.acquire();
			arrived++;
			System.out.println("Waiting -> 0 **"+ currentThread.getName()) ;
			if (arrived == totalThreads) {
				System.out.println("***** Leaving -> 1"+ currentThread.getName()) ;
				leaving.release();
                        }
		} catch (InterruptedException e) {};
		System.out.println("* Waiting -> 1 "+ currentThread.getName()) ;
		waiting.release();
		try {
			leaving.acquire();
			arrived--;
			System.out.println("**** Leaving -> 0 "+ currentThread.getName()) ;
			if (arrived == 0) { 
				System.out.println("* Waiting -> 1 **"+ currentThread.getName()) ;
				waiting.release();
			}
		} catch (InterruptedException e) {};
			System.out.println("***** Leaving -> 1"+ currentThread.getName()) ;
		leaving.release();
	}
}

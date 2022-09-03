import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class cyclicBarrierDebug {
	private int arrived = 0;
	private int totalThreads;
	private boolean waiting = true;
	private boolean leaving = false;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();	

	public cyclicBarrierDebug (int total) {
		this.totalThreads = total;
	}		

	public void barrier()
	{
		Thread currentThread = Thread.currentThread();

		System.out.println("Before **"+ currentThread.getName()) ;
		//waiting
		lock.lock();
		try {
			arrived++; 
			System.out.println("* Arrived **"+ currentThread.getName()) ;
			if (arrived == totalThreads) {
				System.out.println("** Last Arrived **"+ currentThread.getName()) ;
				waiting = false;
				leaving = true;
			}	
			while (waiting)	{
				try {
					System.out.println("*** Wait Arrive **"+ currentThread.getName()) ;
					cond.await();
				} catch (InterruptedException e) { }
			}
			System.out.println("**** Leave Arrived **"+ currentThread.getName()) ;
			cond.signalAll();
        } finally {
			lock.unlock() ;
        }
		// leaving
		lock.lock();
		try {
			arrived--;
			System.out.println("**** Leaving **"+ currentThread.getName()) ;
			if (arrived == 0) {
				System.out.println("***** Last Leaving **" + currentThread.getName()) ;
				waiting = true;
				leaving = false;
	        }		
        	while (leaving)	{
				try  {
					System.out.println("****** wait Leaving **"+ currentThread.getName()) ;
					cond.await();
				} catch (InterruptedException e) { }
			}
			System.out.println("******* Leave Leaving **"+ currentThread.getName()) ;
			cond.signalAll();
        } finally {
			lock.unlock() ;
        }
	}
}

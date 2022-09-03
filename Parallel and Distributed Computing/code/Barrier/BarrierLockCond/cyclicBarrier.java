import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class cyclicBarrier {
	private int arrived = 0;
	private int totalThreads;
	private boolean waiting = true;
	private boolean leaving = false;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();	

	public cyclicBarrier (int total) {
		this.totalThreads = total;
	}		

	public void barrier()
	{
		// waiting
		lock.lock();
		try {
			arrived++;
			if (arrived == totalThreads) {
				waiting = false;
				leaving = true;
			}	
			while (waiting)	{
				try {
					cond.await();
				} catch (InterruptedException e) { }
			}
			cond.signalAll();
        } finally {
			lock.unlock() ;
        }
		// leaving
		lock.lock();
		try {
			arrived--;
			if (arrived == 0) {
				waiting = true;
				leaving = false;
		        }		
        	while (leaving)	{
				try  {
					cond.await();
				} catch (InterruptedException e) { }
			}
			cond.signalAll();
        } finally {
			lock.unlock() ;
        }
	}
}

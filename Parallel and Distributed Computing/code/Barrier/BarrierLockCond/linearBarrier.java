import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class linearBarrier {
	private int arrived = 0;
	private int totalThreads;
	private boolean waiting = true;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
	public linearBarrier (int total) {
		this.totalThreads = total;
	}		

	public void barrier() {
		// waiting
		lock.lock();
		try {
			arrived++;
			if (arrived == totalThreads) waiting = false;
			while (waiting)	{
				try {
										cond.await();
				} catch (InterruptedException e) { }
			}
                
		// leaving
			arrived--;
			if (arrived == 0) waiting = true;
               	cond.signalAll();
		} finally {
			lock.unlock() ;
		}
	}
}

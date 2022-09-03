import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
public class ParkCond {

	int capacity = 4;
	int spaces = capacity;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	int waitscale = 1;
	int inscale = 1;
       
	void arrive () {
		//Car arrival
		try {
		   Thread.sleep((int)(Math.random()*waitscale));
		} catch (InterruptedException e) { }
		//System.out.println(Thread.currentThread().getName()+" --- wait");
		//Car waiting
		lock.lock();
		try {
			while (spaces == 0) {
				try {
					cond.await();
				} catch (InterruptedException e) { }
			}
			//Car entering
			//System.out.println(Thread.currentThread().getName()+" >>>     enter");
			//Decrement capacity
			spaces--;
			System.out.println(spaces);
			//Tell everybody
			//cond.signalAll();
		} finally {
			lock.unlock() ;
		}
	}
        
        void depart () {
            //Car departure
            lock.lock();
            try {
                /*while (spaces == capacity) 
                      try {
                       		cond.await();
		      } catch (InterruptedException e) { }*/
		//Car exiting
                //System.out.println(Thread.currentThread().getName()+" <<<         exit");
                //Increment capacity
                spaces++;
                System.out.println(spaces);
                //Tell everybody
                cond.signalAll();
            } finally {
               	lock.unlock() ;
            }    
        }
           
        void park() {    
            try {
                Thread.sleep((int)(Math.random()*inscale));
            } catch (InterruptedException e) { }
       }
}

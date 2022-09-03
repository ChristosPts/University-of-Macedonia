import java.util.concurrent.Semaphore;
public class ParkSem {

	int capacity = 4;
	private Semaphore sem = new Semaphore(capacity, true);
	int waitscale = 100;
	int inscale = 10000;
   
	void arrive () {
		//Car arrival
		try {
		   Thread.sleep((int)(Math.random()*waitscale));
		} catch (InterruptedException e) { }
		System.out.println(Thread.currentThread().getName()+" --- wait");
		//Car waiting
		try {
		  sem.acquire();
		} catch (InterruptedException e) { }
		//Car entering
		System.out.println(Thread.currentThread().getName()+" >>>     enter");
	}
        
	void depart () {
		//Car exiting
		System.out.println(Thread.currentThread().getName()+" <<<         exit");
		sem.release();   
	}
	   
	void park() {    
		try {
			Thread.sleep((int)(Math.random()*inscale));
		} catch (InterruptedException e) { }
   }
}

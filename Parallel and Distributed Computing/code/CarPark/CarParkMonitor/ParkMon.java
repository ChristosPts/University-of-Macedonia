
public class ParkMon {

	int capacity = 4;
	int spaces = capacity;
	int waitscale = 100;
	int inscale = 10000;
       
	synchronized void arrive () {
	   //Car arrival
		try {
		   Thread.sleep((int)(Math.random()*waitscale));
		} catch (InterruptedException e) { }
		System.out.println(Thread.currentThread().getName()+" --- wait");
		//Car waiting
		try {
		  while (spaces == 0) wait();
		} catch (InterruptedException e) { }
		//Car entering
		System.out.println(Thread.currentThread().getName()+" >>>     enter");
		//Decrement capacity
		spaces--;
		//Tell everybody
		notifyAll();
	}
        
	synchronized void depart () {
		//Car departure
		try {
		  while (spaces == capacity) wait();
		} catch (InterruptedException e) { }
		//Car exiting
		System.out.println(Thread.currentThread().getName()+" <<<         exit");
		//Increment capacity
		spaces++;
		//Tell everybody
		notifyAll();
	}
           
	void park() {    
		try {
			Thread.sleep((int)(Math.random()*inscale));
		} catch (InterruptedException e) { }
    }
}

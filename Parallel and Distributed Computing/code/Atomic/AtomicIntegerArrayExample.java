import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayExample {

	static AtomicIntegerArray at = new AtomicIntegerArray(10);

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("AtomicInteger array's initial values are : ");
		for (int i=0; i<at.length(); i++) {
			at.set(i, 1);
			System.out.println(i + "-" + at.get(i));
		}

		Thread t1 = new Thread(new AddFive());
		Thread t2 = new Thread(new Increment());
		Thread t3 = new Thread(new InsertArray());
		Thread t4 = new Thread(new Compare());
		
		t1.start(); t2.start();	t3.start(); t4.start();
		t1.join(); t2.join(); t3.join(); t4.join();

		System.out.println("All threads are finished. AtomicInteger array's values are : ");
		for (int i=0; i<at.length(); i++) {
			System.out.println(i + "-" + at.get(i));
		}
	}
	
	static class AddFive implements Runnable {

		public void run() {
			for(int i=0; i<at.length(); i++) {
				int addFive = at.addAndGet(i, 5);
				System.out.println(Thread.currentThread().getName() + 
                                       " / adding five, at " + i + " position value is "+ addFive);
				}
			System.out.println(Thread.currentThread().getName() + " / array now is : " + at);
			}
		}
	
	static class Increment implements Runnable {

		public void run() {
			for(int i=0; i<at.length(); i++) {
				int add = at.incrementAndGet(i);
				System.out.println(Thread.currentThread().getName() + 
                                      " / increasing, at " + i + " position value is "+ add);
				}
			System.out.println(Thread.currentThread().getName() + " / array now is " + at);
			}

		}
	
	static class InsertArray implements Runnable {

		public void run() {
			int[] myArray = new int[3];
			for(int i=0; i<3; i++) {
				myArray[i] = 5;
			}
			at = new AtomicIntegerArray(myArray);
			System.out.println(Thread.currentThread().getName() + " Inseting new array, array now is " + at);
			}
		}
	
	static class Compare implements Runnable {

		public void run() {
			for(int i=0; i<at.length(); i++) {
				boolean isFive = at.compareAndSet(i, 5, 3);
				System.out.println(Thread.currentThread().getName() + " / comparing value to 5, result is " + isFive
						+ ", so at " + i + " position value is "+ at.get(i));
			}
			System.out.println(Thread.currentThread().getName() + " / array now is " + at);
			}
		}
}

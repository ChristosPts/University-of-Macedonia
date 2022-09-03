import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Buffer{
	private int contents;
	//private int size;
	//private int front, back;
	private int counter = 0;
	private Lock lock = new ReentrantLock();
	private Condition bufferFull = lock.newCondition();
	private Condition bufferEmpty = lock.newCondition();

	// Constructor
	public Buffer() {
		//this.size = s; δεν χρειάζεται αφου το size ειναι 1
		contents = 0;
		//this.front = 0;
		//this.back = size - 1;
	}

	// Put an item into buffer
	public void put(int data) {

		lock.lock();
			try {
				while (counter == 1) {
				System.out.println("The buffer is full");
				try {
					bufferFull.await();
				} catch (InterruptedException e) { }
			}
			contents = data;
			counter++;
			System.out.println("Prod " + Thread.currentThread().getName() + " No "+ data + " Count = " + counter);
			//buffer was empty
			 bufferEmpty.signalAll();
		} finally {
			lock.unlock() ;
		}
	}

	// Get an item from bufffer
	public int get() {
		int data = 0;

		lock.lock();
		try {
			while (counter == 0) {
				System.out.println("The buffer is empty");
				try {
					bufferEmpty.await();
				} catch (InterruptedException e) { }
			}
			data = contents;
			System.out.println("  Cons " + Thread.currentThread().getName() + " No "+ data + " Count = " + (counter-1));
			counter--;
			//buffer was full
			bufferFull.signalAll();
		} finally {
			lock.unlock() ;
		}
		return data;
	}
}

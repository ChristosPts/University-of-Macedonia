import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
 class Buffer{
	private int[] contents;
	private final int unlimited;//private int size=1;  gia unlimited 
	private int front, back;
	private int counter = 0;
	private Lock lock = new ReentrantLock();
	private Condition buffer = lock.newCondition();

	// Constructor
	public Buffer(int s) {
	this.unlimited = s;
	contents = new int[unlimited];
	for (int i=0; i<unlimited; i++)
		contents[i] = 0;
		this.front = 0;
		this.back = unlimited - 1;
	}

	// Put an item into buffer
	public void put(int data) {

		lock.lock();
			try {
			back = (back + 1);
			contents[back] = data;
			counter++;
			System.out.println("Prod " + Thread.currentThread().getName() + " No "+ data + " Loc " + back + " Count = " + counter);
			//buffer was empty
		 buffer.signalAll();
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
			}
			data = contents[front];
			System.out.println("  Cons " + Thread.currentThread().getName() + " No "+ data + " Loc " + front + " Count = " + (counter-1));
			front = (front + 1);
			counter--;
		} finally {
			lock.unlock() ;
		}
		return data;
	}
}

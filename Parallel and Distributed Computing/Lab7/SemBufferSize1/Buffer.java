import java.util.concurrent.Semaphore;

public class Buffer{
	private int contents;
	private final int size;
	//private int front, back;
	private int counter = 0;
	private Semaphore mutexPut = new Semaphore(1);
	private Semaphore mutexGet = new Semaphore(0);
	

	// Constructor
	public Buffer() {
	contents = 0;		
	}

	// Put an item into buffer
	public void put(int data) {
		try {
			mutexPut.acquire();// δεν αφηνει αλλους παραγωγους να μπουν
		} catch (InterruptedException e) { }
		contents = data;
		System.out.println("Prod " + Thread.currentThread().getName() + " No "+ data + " Count = " + counter);
		counter++;
		mutexPut.release(); //δινει σημα σε καταναλωτες οτι εχει αντικειμενο να παρουν
	}

	// Get an item from bufffer
	public int get() {
		int data = 0;
		
		try {
			mutexGet.acquire();
		} catch (InterruptedException e) { }
		data = contents;
		System.out.println("  Cons " + Thread.currentThread().getName() + " No "+ data + " Count = " + (counter-1));
  		counter--;	
		mutexGet.release(); 
		return data;
	}
}
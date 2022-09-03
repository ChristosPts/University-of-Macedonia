import java.util.concurrent.Semaphore;
public class Buffer{
	private int[] contents;
	private final int unlimited;
	private int front, back;
	private int counter = 0;
	private Semaphore mutexPut = new Semaphore(1);
	private Semaphore mutexGet = new Semaphore(0);
	

	// Constructor
	public Buffer(int s) {
	this.unlimited = s;
	contents = new int[unlimited];
	for (int i=0; i<unlimited; i++)
		contents[i] = 0;
		this.front = 0;
		this.back = -1;	
		
	}

	// Put an item into buffer
	public void put(int data) {
		try {
			mutexPut.acquire();// δεν αφηνει αλλους παραγωγους να μπουν
		} catch (InterruptedException e) { }
		back = (back + 1);
		contents[back] = data;
		counter++;
		System.out.println("Prod " + Thread.currentThread().getName() + " No "+ data + " Loc " + back + " Count = " + counter);
		mutexGet.release(); //δινει σημα σε καταναλωτες οτι εχει αντικειμενο να παρουν
		mutexPut.release(); // τελιώνει ο παραγωγός μπορει τωρα να μπει ο επομενος
	}

	// Get an item from bufffer
	public int get() {
		int data = 0;
		
		try {
			mutexGet.acquire();
			try {
			mutexPut.acquire(); // κλειδωμα buffer ωστε να μην μπου αλλοι καταναλωτες
			} catch (InterruptedException e) { }
		} catch (InterruptedException e) { }
		data = contents[front];
		System.out.println("  Cons " + Thread.currentThread().getName() + " No "+ data + " Loc " + front + " Count = " + (counter-1));
        front = (front + 1);
		counter--;	
		return data;
	}
}
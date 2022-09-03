public class Buffer
{
	private int[] contents;
	private final int size;
	private volatile int front, back, counter = 0;

	// Constructor
	public Buffer(int s) {
	this.size = s;
	contents = new int[size];
	for (int i=0; i<size; i++)
		contents[i] = 0;
		this.front = 0;
		this.back = size-1;
	}

	// Put an item into buffer
	public void put(int data)
	{
		while (counter == size) {};
		back = (back + 1) % size;
		contents[back] = data;
		counter++;
		System.out.println("Item " + data + " added in loc " + back + ". Count = " + counter);
		if (counter == size)
			System.out.println("The buffer is full");
        }

	// Get an item from bufffer
	public int get()
	{
		int data = 0;
		while (counter == 0) {};
		data = contents[front];
		System.out.println("Item " + data + " removed from loc " + front + ". Count = " + (counter-1));
		front = (front + 1) % size;
		counter--;
		if (counter == 0) 
			System.out.println("The buffer is empty");
		return data;
	}
}

	
			
	

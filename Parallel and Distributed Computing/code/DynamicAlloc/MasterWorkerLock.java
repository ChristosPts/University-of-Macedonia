import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MasterWorkerLock {
	
	static int totalTasks; // αριθμός εργασιών
	static int nThreads; // αριθμός νημάτων  
	static int tasksAssigned = -1; // διαμοιραζόμενη μεταβλητή μετρητή εργασιών   
	static Lock lock = new ReentrantLock();

	public static void main(String[] args)
	{
		totalTasks = 20; 
		nThreads = 10; 
		
		// Δημιουργία και αρχικοποίηση πίνακα    
		double[] a = new double[totalTasks]; 
		for(int i=0; i<totalTasks; i++)
		{
			a[i] = i + 3;
			System.out.println(a[i]);   
		} 

		// Δημιουργία νημάτων εργαζομένων
		Thread[] threads = new Thread[nThreads];
		for (int i = 0; i < threads.length; ++i)
		{
			threads[i] = new Thread(new Worker(a,i));
		}		

		// Εκκίνηση νημάτων εργαζομένων 
		for (int i = 0; i < threads.length; ++i)
		{
			threads[i].start();
		}

		// Αναμονή τερματισμού νημάτων εργαζομένων 
		for (int i = 0; i < threads.length; ++i)
		{
			try {
				threads[i].join();
			}
			catch (InterruptedException e) {
				System.err.println("this should not happen");
			}
		}
		
		// Εμφάνιση στοιχείων πίνακα
		for(int i = 0; i < totalTasks; i++)
			System.out.println(a[i]);
	}

	//  Κρίσιμo τμήμα για την διανομή εργασιών
	private static int getTask()
	{
        lock.lock();
        try {
			// Διανέμει μια εργασία (στοιχείο πίνακα) 
			if (++tasksAssigned < totalTasks) 
				return tasksAssigned;
			else
				return -1;
        } finally {
        	lock.unlock() ;
        }			
	}

	// Κώδικας που εκτελεί το κάθε νήμα - εργαζόμενος 
	private static class Worker implements Runnable
	{

		private int myID;
		private double[] table;

		// 
		public Worker(double[] array, int myID)
		{
			this.myID = myID;
			table = array;
		}

		public void run()
		{
			int element;
			// Λαμβάνει εργασία (ή στοιχείο πίνακα) αν υπάρχει
			while ((element = getTask()) >= 0)
			{
				System.out.println("worker " + myID + " received " + element);
				// Υπολογίζει την τετραγωνική ρίζα του στοιχείου που έλαβε        
				table[element]= Math.sqrt(table[element]);    
			}
			System.out.println("worker " + myID + " done");
		}
	}
}

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MasterWorkerPutLockUnlimited {
	
	static int initialTasks; //number of initial tasks
	static int totalTasks; //number of total tasks
	static int nThreads; // number of threads
	static int tasksAssigned = 0; // shared variable for the number of tasks 
	static int putReps; 
	static int tasksAdded;
	static Lock lock = new ReentrantLock();

	public static void main(String[] args)
	{
		initialTasks = 20;
		nThreads = 5; 
		int[] waiting = new int[nThreads];
		for(int i=0; i<nThreads; i++)
		{
			waiting[i] = 0;               
		} 
                
		//putReps = 10;
		totalTasks = 1000; //initialTasks + putReps * nThreads; 
		tasksAdded = initialTasks;

		//Create and initialize table
		double[] a = new double[totalTasks]; 
		for(int i=0; i<initialTasks; i++)
		{
			a[i] = i+1;
			System.out.println(a[i]); 
                        
		} 
		
		for(int i=initialTasks; i<totalTasks; i++)
		{
			a[i] = 0;
			System.out.println(a[i]);   
		} 
		
		//Create threads
		Thread[] threads = new Thread[nThreads];
		for (int i = 0; i < nThreads; ++i)
		{
			threads[i] = new Thread(new Worker(a, i, waiting));
		}		

		//Start worker threads
		for (int i = 0; i < nThreads; ++i)
		{
			threads[i].start();
		}

		//Wait threads to terminate and collect result
		for (int i = 0; i < nThreads; ++i)
		{
			try {
				threads[i].join();
			}
			catch (InterruptedException e) {
				System.err.println("this should not happen");
			}
		}
		
		//Print table
		/*for(int i = 0; i < totalTasks; i++)
			System.out.println(a[i]);*/
	}
	
	//Critical section of tasks distribution
	private static int getTask(int waiting[], int id)
	{
        lock.lock();
        try {
			int w = 0; 
			for(int i=0; i<nThreads; i++) 
				w += waiting[i];
			if (w == nThreads -1)
				return -2;
			else if (tasksAssigned == tasksAdded) {
		        waiting[id] = 1;
				return -1;
				}		
				else {	
					tasksAssigned++;
					waiting[id] = 0;
					return (tasksAssigned-1);
                }
		} finally {
        	lock.unlock() ;
        }           
	}
	
	private static void putTask(double[] table, double item)
	{
        lock.lock();
        try {
			if (tasksAdded < totalTasks) {
				table[tasksAdded] = item;
				tasksAdded++;	
			}			 
		} finally {
        	lock.unlock() ;
        }
	}
	

	//Worker threads code
	private static class Worker implements Runnable
	{
		private int myID;
		private double[] table;
		private int[] waiting;

		//Constructor
		public Worker(double[] array, int myID, int[] w)
		{
			this.myID = myID;
			table = array;
			waiting = w;          
		}

		public void run()
		{
			int element;
			int step = 3;
			//Get task(or table element) if it exists
			while ((element = getTask(waiting, myID)) > -2) 
			{
				if (element == -1) {
					System.out.println("worker " + myID + " waiting");		
					
				}
				else {
					System.out.println("worker " + myID + " receives table[" + element+ "] = " + table[element]);
					//Calculates the square root of the received element   
					table[element]= Math.sqrt(table[element]);    
					System.out.println("worker " + myID + " calculates " +  Math.sqrt(table[element]) + " in " + element);	
				}
				//Put elements as long as there is space in the table
				double newItem = (myID+1)*(step++);
				System.out.println("worker " + myID + " tries to put " + newItem  + " in array");
				putTask(table, newItem);
				try {
					Thread.sleep((int)(Math.random()*10));
				} catch (InterruptedException e) {} 
			}
		}
	}
}

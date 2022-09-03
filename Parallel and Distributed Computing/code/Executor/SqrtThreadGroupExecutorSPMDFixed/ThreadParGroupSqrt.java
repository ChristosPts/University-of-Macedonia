import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.*;
import java.util.*;
class ThreadParGroupSqrt
{
	public static void main(String[] args)
	{
		int size = 0;
        int blockSize = 0;
	        
	        
		if (args.length != 2) {
    		System.out.println("Usage: java ThreadGroupSqrt <vector size> <block size>");
    		System.exit(1);
		}

		try {
			size = Integer.parseInt(args[0]);
    		blockSize = Integer.parseInt(args[1]);
		}
		catch (NumberFormatException nfe) {
	   		System.out.println("Integer argument expected");
    		System.exit(1);
		}
		// number of cpus
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("cores = " + cores);
		
		if (blockSize == 0) blockSize = 1;
		
		int numTasks = size / blockSize;
		if ((size % blockSize) != 0) numTasks++;
                
		// shared data structure initialization   
		double[] a = new double[size];
		for(int i = 0; i < size; i++)
			a[i] = i; 

		// for debugging 
		/*for(int i = 0; i < size; i++) 
			System.out.println(a[i]);*/
  
		// get current time
                long start = System.currentTimeMillis();

		// task creation 
		SqrtGroupTask tasks[] = new SqrtGroupTask[numTasks];
		
		ExecutorService executor = Executors.newFixedThreadPool(cores);
		for (int i = 0; i < numTasks; i++) {
    		tasks[i] = new SqrtGroupTask(a, i, size, blockSize);
				//System.out.println("A new task has been added in the queue: " + i);
				executor.execute(tasks[i]);
		}
		try {
			executor.shutdown();
			executor.awaitTermination(20, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
    			System.err.println("tasks interrupted");
		}
		finally {
			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}	
			executor.shutdownNow();
		}

		// get current time and calculate elapsed time
		long elapsedTimeMillis = System.currentTimeMillis()-start;
		System.out.println("time in ms = "+ elapsedTimeMillis);

		// for debugging  
		/*for(int i = 0; i < size; i++) 
			System.out.println(a[i]);*/

	}
}

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.*;
import java.util.*;
class ThreadParGroupSqrt
{
	public static void main(String[] args)
	{
		int size = 0;
        int numTasks = 0;
	           
		if (args.length != 2) {
    		System.out.println("Usage: java ThreadGroupSqrt <vector size> <number of tasks>");
    		System.exit(1);
		}

		try {
			size = Integer.parseInt(args[0]);
    		numTasks = Integer.parseInt(args[1]);
		}
		catch (NumberFormatException nfe) {
	   		System.out.println("Integer argument expected");
    		System.exit(1);
		}
		// number of cpus
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("cores = " + cores);
		
		// numTasks should be larger than number of cores
		if (numTasks == 0) numTasks = Runtime.getRuntime().availableProcessors();
                
		// shared data structure initialization   
		double[] a = new double[size];
		for(int i = 0; i < size; i++)
			a[i] = i; 

		// for debugging 
		/*for(int i = 0; i < size; i++) 
			System.out.println(a[i]);*/
  
		// result
		globalSum sum = new globalSum();
                
		// get current time
		long start = System.currentTimeMillis();

		// task creation 
		SqrtGroupTask tasks[] = new SqrtGroupTask[numTasks];
		
		ExecutorService executor = Executors.newFixedThreadPool(cores);
		for (int i = 0; i < numTasks; i++) {
    		tasks[i] = new SqrtGroupTask(a, i, numTasks, size, sum);
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
	
        // result
			sum.print();		

	}
}

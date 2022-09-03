import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.ArrayList;

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
  
		// get current time
		long start = System.currentTimeMillis();

		// callable task creation 
		ExecutorService executor = Executors.newFixedThreadPool(cores);
		ArrayList<Future<Double>> results = new ArrayList<Future<Double>>();

		for (int i = 0; i < numTasks; i++) {
    		Callable<Double> callable = new SqrtGroupTask(a, i, numTasks, size);
			Future<Double> future =  executor.submit(callable);
			//System.out.println("A new task has been added : " + i);
			results.add(future);
		}

		double sum = 0.0;

		executor.shutdown();
		for (Future<Double> future : results) {
			try {
				sum = sum + future.get();
			}
			catch (ExecutionException e) {
				System.err.println("should not happen");
			}
			catch (InterruptedException e) {
				System.err.println("should not happen");
			}
		}
        	
		// get current time and calculate elapsed time
		long elapsedTimeMillis = System.currentTimeMillis()-start;
		System.out.println("time in ms = "+ elapsedTimeMillis);

		// for debugging  
		/*for(int i = 0; i < size; i++) 
			System.out.println(a[i]);*/
	
        // result
		System.out.println("Sum : "+sum);		

	}
}

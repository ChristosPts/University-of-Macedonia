import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NumIntExecutor {
	public static double sum;
	public static Lock lock = new ReentrantLock();
    
  public static void main(String[] args) {

        long numSteps = 0;
		int blockSize = 0;
	
        /* parse command line */
        if (args.length != 2) {
		System.out.println("arguments: <mumber of steps> <block size>");
                System.exit(1);
        }
        try {
			numSteps = Long.parseLong(args[0]);
			blockSize = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
			System.out.println("argument "+ args[0] +" must be long int");
			System.exit(1);
        }	
		
		// number of cpus
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("cores = " + cores);
			
			long numTasks = numSteps / blockSize;
			if ((numSteps % blockSize) != 0) 
				numTasks++;
		
        /* start timing */
        long startTime = System.currentTimeMillis();

		
		// task creation 
		piTask tasks[] = new piTask[(int)numTasks];
		
		ExecutorService executor = Executors.newFixedThreadPool(cores);
		for (int i = 0; i < numTasks; i++) {
	    		tasks[i] = new piTask(i, numSteps,blockSize);
            		//System.out.println("A new task has been added in the queue: " + i);
            		executor.execute(tasks[i]);
				}
			try {
				executor.shutdown();
				executor.awaitTermination(20, TimeUnit.SECONDS);
			}catch (InterruptedException e) {
					System.err.println("tasks interrupted");
			}
			finally {
					if (!executor.isTerminated()) {
						System.err.println("cancel non-finished tasks");
					}	
					executor.shutdownNow();
				}
       
	    double step = 1.0/(double)numSteps;
	    double pi = sum * step;
		
        /* end timing and print result */
        long endTime = System.currentTimeMillis();
        System.out.printf("sequential program results with %d steps\n", numSteps);
        System.out.printf("computed pi = %22.20f\n" , pi);
        System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
        System.out.printf("time to compute = %f seconds\n", (double) (endTime - startTime) / 1000);
    }
}


class piTask implements Runnable{
	private int iX;
	private double sumX;
	private long numSteps;
	private int bSize;
	

	// constructor
	public piTask(int i, long numSteps,int blockSize){
		this.iX = i;
		this.numSteps = numSteps;
		this.bSize = blockSize;
	}

	// thread code
	public void run(){
		
		int myfrom = 0;
		int myto = 0;
		
		myfrom = iX*bSize;
		myto = myfrom*bSize;
		if(myto>numSteps) 
			myto = (int)numSteps;
		
	     double step = 1.0 / (double)numSteps;
        /* do computation */
        for (int i = myfrom; i < myto; i++) {
            double x = ((double)i+0.5)*step;
            sumX += 4.0/(1.0+x*x);
        }
		 
		NumIntExecutor.lock.lock();
       try{
		   NumIntExecutor.sum=NumIntExecutor.sum + sumX;
	   }finally{
		   NumIntExecutor.lock.unlock();
	   }
	   
	   
	}
}
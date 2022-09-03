import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumIntSeqInnerLock{
		
	 static double pi;
	 static  Lock lock = new ReentrantLock();
	
    public static void main(String[] args) {
			
        int numSteps = 0;
		int numThreads = 0;
       
			/* parse command line */
			if (args.length != 2) {
				System.out.println("arguments needed:  number_of_steps and number_of_Threads");
				System.exit(1);
			}
			try {
				numSteps = Integer.parseInt(args[0]);
				numThreads = Integer.parseInt(args[1]);
			} catch (NumberFormatException e) {
				System.out.println("argument "+ args[0] +" must be long int");
				System.exit(1);
			}
							
        /* start timing */
        long startTime = System.currentTimeMillis();
		
		SeqThreadInner threads[] = new SeqThreadInner[numSteps];
		for(int i=0; i< numThreads; i++){
			threads[i] = new SeqThreadInner(i,numThreads,numSteps);
			threads[i].start();
		}

		for(int i=0; i< numThreads; i++){
			try{
				threads[i].join();
			}catch(InterruptedException e){}
		}		
		
        

        /* end timing and print result */
        long endTime = System.currentTimeMillis();
        
        System.out.printf("sequential program results with %d steps\n", numSteps);
        System.out.printf("computed pi = %22.20f\n" , pi);
        System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
        System.out.printf("time to compute = %f seconds\n", (double) (endTime - startTime) / 1000);
    }



 private static class SeqThreadInner extends Thread {
	private int myId;
	private int myStart,myStop, block;
	private double step;
	
	public SeqThreadInner(int i, int nThreads, int nSteps){
		myId = i;
		block = nSteps/nThreads;
		
		step =  1.0/nSteps;
		myStart = block*myId;
		myStop = myStart+block;
		if(myId == (nThreads-1))
			myStop = (int)nSteps;
	}
	
	public void run (){
		double Sum = 0.0;
	    double x = ((double)myId+0.5)*step;
		
		NumIntSeqInnerLock.lock.lock();
			for(int i = myStart; i<myStop; i++){
				Sum += 4.0/(1.0+x*x);
			}
			try {
				NumIntSeqInnerLock.pi += Sum*step;
			  }finally {				
			    NumIntSeqInnerLock.lock.unlock();
				}
			}

	}


}
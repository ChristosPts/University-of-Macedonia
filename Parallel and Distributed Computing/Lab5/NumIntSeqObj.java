import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumIntSeqObj{

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
		
		SeqObj tSum = new SeqObj();
		double step = 1.0 / (double)numSteps;	
        		
		// create thread
		SeqThreadObj threads[] = new SeqThreadObj[numSteps];
		// thread execution
		for(int i=0; i< numThreads; i++){
			threads[i] = new SeqThreadObj(i,numThreads, numSteps, step, tSum);
			threads[i].start();
		}

		
		for(int i=0; i< numThreads; i++){
			try{
				threads[i].join();
			}catch(InterruptedException e){}
		}		
		
        double pi = tSum.getSum() * step;

        /* end timing and print result */
        long endTime = System.currentTimeMillis();
        
        System.out.printf("sequential program results with %d steps\n", numSteps);
        System.out.printf("computed pi = %22.20f\n" , pi);
        System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
        System.out.printf("time to compute = %f seconds\n", (double) (endTime - startTime) / 1000);
    }
}

 class SeqObj{
	 
	 double sum;
	 
	 public SeqObj(){
		sum = 0;
	 }
	 
	 public void equation(double num){
		sum+=num;
	 }
	 
	 public double getSum(){
		return sum;
	 }
	 
 } 

class SeqThreadObj extends Thread {
	private int myID;
	private double step;
	private long numSteps;
	private int myStart,myStop, block;
	private SeqObj tSum;
	
	public SeqThreadObj(int id, int nThreads, int nSteps, double step,SeqObj tSum ){
		myID = id;
		this.tSum=tSum;
		numSteps = nSteps;
		this.step = step;
		
		block  = ((int)nSteps/nThreads);
		myStart = block*myID;
		myStop = myStart+block;
		if(myID == (nThreads-1))
			myStop = (int)nSteps;
	}
	
	public void run (){
		double LSum =0.0;
		step = 1.0/numSteps;
		
		for(int i = myStart; i<myStop; i++){
			double x = ((double)myID+0.5)*step;
			LSum += 4.0/(1.0+x*x);
		}
         
	   tSum.equation(LSum);
		
	}
	
}
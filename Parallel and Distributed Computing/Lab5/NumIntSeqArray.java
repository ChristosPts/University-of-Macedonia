import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumIntSeqArray{
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
			
		// δημιουργία πίνακα που αποθηκεύονται οι τιμές
		double tsum[] = new double [numThreads ] ;
		for (int i = 0; i< numThreads ; i++)
				tsum[i]=0.0;
		
        /* start timing */
        long startTime = System.currentTimeMillis();
		double step = 1.0 / (double)numSteps;
		
		SeqThread threads[] = new SeqThread[numThreads];
		for(int i=0; i< numThreads; i++){
			threads[i] = new SeqThread(i,numThreads, tsum, numSteps);
			threads[i].start();
		}

  		for(int i=0; i< numThreads; i++){
			try{
				threads[i].join();
			}catch(InterruptedException e){}
		}		
		
		double sumX=0;
		for(int i = 0; i<numThreads; i++){
			sumX += tsum[i];
		}
		   double pi = sumX*step;

        /* end timing and print result */
        long endTime = System.currentTimeMillis();
        
        System.out.printf("sequential program results with %d steps\n", numSteps);
        System.out.printf("computed pi = %22.20f\n" , pi);
        System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
        System.out.printf("time to compute = %f seconds\n", (double) (endTime - startTime) / 1000);
    }
}


class SeqThread extends Thread {
	private int myID;
	private double step, array[];
	private long numSteps;
	private int myStart,myStop, block;
	
	public SeqThread(int id, int nThreads, double tsum[], long nSteps){
		myID = id;
		array=tsum;
		numSteps = nSteps;
		block  = ((int)nSteps/nThreads);
		myStart = block*myID;
		myStop = myStart*myID;
		if(myID == (nThreads-1))
			myStop = (int)nSteps;
	}
	
	public void run (){
		double sum =0.0;
		step = 1.0/numSteps;
		for(int i = myStart; i<myStop; i++){
			double x = ((double)myID+0.5)*step;
			sum += 4.0/(1.0+x*x);
		}
		array[myID]=sum;
	}
	
}
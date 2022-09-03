/* Simple matrix vector multiplication ax = y       */
/* Use javac -Xmx1024m for larger matrices          */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Askisi2MatVec{
  public static void main(String args[]){
	  
    int size = 0;
	int numThreads = 0; 

		if (args.length != 2) {
			System.out.println("Usage: java MatVecMulTimeArgs <size> <number of threads>");
			System.exit(1);
		}

		try {
			size = Integer.parseInt(args[0]);
			numThreads = Integer.parseInt(args[1]);
		}
		
		catch (NumberFormatException nfe) {
			System.out.println("Integer argument expected");
			System.exit(1);
		}
		
		if (size <= 0) {
			System.out.println("Attention: <size> and <number of threads> should be >0");
			System.exit(1);
		}
	   
	   if (numThreads == 0) numThreads = Runtime.getRuntime().availableProcessors();
		
		
				
		double[][] a = new double[size][size];
			for(int i = 0; i < size; i++)
				for(int j = 0; j < size; j++)
					a[i][j] = 1;
		
		double[] x = new double[size];
		double[] y = new double[size];
			for(int i = 0; i < size; i++){
				x[i] = 1;
				y[i] = 0;
			}
			
		long start = System.currentTimeMillis();
			
		Thread threads[] = new Thread[numThreads];	
			
			for(int i = 0; i< numThreads; i++){
			threads[i] = new MathThread(i,size,a,x,y,numThreads);
			threads[i].start();
		}		
		
		for(int i = 0; i< numThreads; i++){
			try{
				threads[i].join();
			} catch (InterruptedException e){}
		}
		
		
		long elapsedTimeMillis = System.currentTimeMillis()-start;
		System.out.println("time in ms = "+ elapsedTimeMillis);

		/* for debugging 
		for(int i = 0; i < size; i++) 
			System.out.println(y[i]); */
	  }


static class MathThread extends Thread{
	
	private int myStart, myStop;
	private double [][] array;
	private double [] xi ;
	private double [] yi ;
	Lock lock = new ReentrantLock();
	
	public MathThread (int myId,int siz,double [][] array,double [] xi,double [] yi,int nThreads){
		this.array = array;
		this.xi = xi;
		this.yi = yi;
		
		myStart = myId * (siz / nThreads);
		myStop = myStart + (siz / nThreads);
		if (myId == (nThreads - 1)) 
			myStop = siz;
	}
	
	public void run (){
			for (int i= myStart; i < myStop; i++){
				double sum = 0;
				
				
				for (int j = myStart; j < myStop; j++) {
					
					
					sum = sum + array[i][j]*xi[j];
					
				}
				yi[i] = sum;
			}	
		}
	
}

}
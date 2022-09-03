import java.util.concurrent.*;
import java.util.*;
import java.text.*;

public class CyclicBarrierExample {
    static int numThreads = 4;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = 
	        new CyclicBarrier(numThreads, new Runnable() {
				int count = 0;
	
				public void run() {
					   System.out.printf("Cyclic Barrier Finished %d\n", ++count);
				}
			});
    
        for(int i=0;i<numThreads;i++) {
            Thread t = new Thread(new WorkerThread(cyclicBarrier,i));
            t.start();
        }
    }
    
    static void delay (int scale) {
    	try {
        	 Thread.sleep((int) (Math.random() * scale));
        } catch (InterruptedException e) {}
    }
       	 
    static class WorkerThread implements Runnable {
        private CyclicBarrier cyclicBarrier;
        private int id;
        
        public WorkerThread(CyclicBarrier cyclicBarrier, int id) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }
        
        public void run() {
            int scale = 500;
            int c = 0;
            while (true) {     	           
                //System.out.printf("Doing Work on Thread %d\n", id);
                delay(scale);
                
                // Await returns an int which is the arrival index
                // 1 means first 0 means last
                try { 
                	c = cyclicBarrier.await(); 
                } catch (InterruptedException | BrokenBarrierException e) {}	
                System.out.printf("Barrier count of Step 1 on %d is %d\n", id, c);
                
                //if(c == 0) cyclicBarrier.reset();
                
                delay(scale);
                try {
                	c = cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {}	
                System.out.printf("Barrier count of Step 2 on %d is %d\n", id, c);
            }
        }
    }
}

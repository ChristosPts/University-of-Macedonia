import java.util.concurrent.*;
import java.util.*;
import java.text.*;

public class CountDownLatchExample {

    static int numThreads = 4;
    
    public static void main(String[] args) {
    
        
        CountDownLatch countDownLatch = new CountDownLatch(numThreads);
    
        
        for(int i=0;i<numThreads;i++) {
            Thread t = new Thread(new WorkerThread(countDownLatch, i));
            t.start();
        }
        
        System.out.println("Waiting All Threads to Finish");

        try {
        	countDownLatch.await(); 
        } catch (InterruptedException e) {}

        System.out.println("All Threads are Finished");
    }
    
    static void delay (int scale) {
    	try {
        	 Thread.sleep((int) (Math.random() * scale));
        } catch (InterruptedException e) {}
    }
    
    static class WorkerThread implements Runnable {
        private CountDownLatch countDownLatch;
        private int id;
        
        public WorkerThread(CountDownLatch countDownLatch, int id) {
          this.id = id;
          this.countDownLatch = countDownLatch;
        }
        
        public void run() {                             
			System.out.printf("Doing Some Work on Thread %d\n", id);
			delay(500);
								  
			countDownLatch.countDown(); 
			System.out.printf("CountDownLatch count on Thread %d is %d\n", 
										id, countDownLatch.getCount());
			
			System.out.printf("Doing Some More Work on Thread %d\n", id);
			delay(
        }
        
    }
}

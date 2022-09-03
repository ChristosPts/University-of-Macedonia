import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {
				
       	int numThreads = 4;
		CyclicBarrier cb = new CyclicBarrier(numThreads);
		
		for (int i=0; i<numThreads; i++) {
			CyclicBarrierRunnable r= new CyclicBarrierRunnable(cb);
			new Thread(r).start();
		}
	}
        
	static class CyclicBarrierRunnable implements Runnable{
	
		private CyclicBarrier cb = null;
		
		public CyclicBarrierRunnable(CyclicBarrier cb) {
			this.cb = cb;
		}

		public void run() {
        	int scale = 500;
        	while (true) {
				try {
		          	System.out.println("Starting"+Thread.currentThread().getName()); 
					Thread.sleep((int)(Math.random()*scale));
					this.cb.await();	  
		          	System.out.println("Passing Barrier"+Thread.currentThread().getName());
					Thread.sleep((int)(Math.random()*scale));
		          	System.out.println("Finishing"+Thread.currentThread().getName());                       
				}
				catch(Exception e) {}
			}
		}
	}
}

public class Askisi3Inner{

    public static void main(String[] args) {
	
	int numThreads = 20;
        
	/* create and start threads */
		Thread thread1[] = new Thread[numThreads];
		Thread thread2[] = new Thread[numThreads];
		
		for (int i = 0; i < numThreads; ++i) {
        System.out.println("In main: create and start thread type 1 num: " +i);
		thread1[i] = new MyThread1(i);
        thread1[i].start();
	
		System.out.println("In main: create and start thread type 2 num: " +i);
		thread2[i] = new MyThread2(i);
            thread2[i].start();
		}		
		
		for (int i = 0; i < numThreads; ++i) {
        try {
				thread1[i].join();
                thread2[i].join();
               
            }
            catch (InterruptedException e) {
                System.err.println("this should not happen");
          }
		}
        System.out.println("In main: threads all done");
    }

/* class containing code for each thread to execute */
	private static class MyThread1 extends Thread {
	
		private int i2;
		
		
		public MyThread1(int i2){
			this.i2 = i2;
	}

		/* thread code */
		public void run() {
				System.out.println("Hello from thread type 1: " +i2);
		} 

	}


	private static class MyThread2 extends Thread {
	
	 private int i2;
		
		public MyThread2(int i2){
			this.i2 = i2;
			
		}

		/* thread code */
		public void run() {
				System.out.println("Hello from thread type 2: " +i2);
		} 

	}

}





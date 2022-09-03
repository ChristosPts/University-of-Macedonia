public class Askisi3Inner{

    public static void main(String[] args) {
	
	int numThreads = 20;
        
	/* create and start threads */
	//	Thread thread1[] = new Thread[numThreads];
		//Thread thread2[] = new Thread[numThreads];
		
		for (int i = 0; i < numThreads; ++i) {
        System.out.println("In main: create and start thread type 1 num: " +i);
        	Thread thread1 = new Thread(){
			public void run(){
				for (int i=0; i<50; i+=5)
			System.out.println("Hello from thread type 1: " +i  );
			}
		};
		System.out.println("In main: create and start thread type 2 num: " +i);
			Thread thread2 = new Thread(){
				public void run(){
					for (int i=0; i<20; i++)
			System.out.println("Hello from thread type 2: " +i  );
			}
		};
		
		thread1.start();
		thread2.start();
		
		try {
				thread1.join();
                thread2.join();
               
            }
            catch (InterruptedException e) {
                System.err.println("this should not happen");
          }
		
		}
		
        System.out.println("In main: threads all done");
   

	}	

}
public class HelloThreadSingle {

    public static void main(String[] args) {
        
	/* create and start threads */
        System.out.println("In main: create and start thread type 1 ");
		Thread thread1 = new MyThread1();
        thread1.start();
	
		System.out.println("In main: create and start thread type 2 " );
		Thread thread2 = new MyThread2();
        thread2.start();
				
		
        try {
				thread1.join();
                thread2.join();
               
            }
            catch (InterruptedException e) {
                System.err.println("this should not happen");
          }
		
        System.out.println("In main: threads all done");
    }
}

/* class containing code for each thread to execute */
class MyThread1 extends Thread {
	
    /* thread code */
    public void run() {
        for (int i=0; i<50; i=i+5)
        	System.out.println("Hello from thread type 1 number: " +i);
    } 

}



class MyThread2 extends Thread {


    /* thread code */
    public void run() {
       for (int i=0; i<20; i++)
        	System.out.println("Hello from thread type 2 number: " +i );
    } 

}


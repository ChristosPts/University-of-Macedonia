/*
 * HelloRuntimeProcsArgs.java
 *
 * creates threads using static inner class implementing Runnable. 
 * uses Command Line Arguments and Runtime to get number of system's cpus
 *
 */
public class HelloRuntimeProcsArgs {

    
    public static void main(String[] args) {

        /* get number of threads from command line and number logical cores from runtime */

        int numThreads = 0;
        int size = 0;
	             
		if (args.length != 1) {
	    		System.out.println("Usage: java HelloRuntimeProcsArgs <number of threads>");
	    		System.exit(1);
		}
	
		try {
		  	numThreads = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException nfe) {
	   		 System.out.println("Integer argument expected");
	    		System.exit(1);
		}
        if (numThreads <= 0) numThreads = Runtime.getRuntime().availableProcessors();
        
        /* create threads */
        
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; ++i) {
            threads[i] = new Thread(new Inner(i, numThreads-1));
        }

        /* start them up */

        System.out.println("starting threads");

        for (int i = 0; i < numThreads; ++i) {
            threads[i].start();
        }

        /* wait for them to finish */

        for (int i = 0; i < numThreads; ++i) {
            try {
                threads[i].join();
            }
            catch (InterruptedException e) {
                System.err.println("this should not happen");
            }
        }

        System.out.println("threads all done");
    }

    /* inner class containing code for each thread to execute */

    private static class Inner implements Runnable {

        private int myID;
        private int mytotal;

        public Inner(int ID, int total) {
            this.myID = ID;
            this.mytotal = total;
        }

        public void run() {
            System.out.println("hello from " + myID + " of " + mytotal);
        }

    }
}

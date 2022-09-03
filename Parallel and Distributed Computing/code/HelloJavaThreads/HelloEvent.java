/*
 * HelloEvent.java
 *
 * Event driven thread creation and termination
 * Use of interrupts
 *
 */
public class HelloEvent {

    public static void main(String[] args) {

        /* get number of logical cores from runtime */

        int numCores = Runtime.getRuntime().availableProcessors();
        int numThreads = 2*numCores;

        /* create and start threads */

        Thread[] threads = new Thread[numThreads];

        int i = 0;
        while (i < numThreads) {
            
            pressAnyKeyToContinue();
            System.out.println("Starting thread " + i);
            threads[i] = new Thread(new Inner(i));
            threads[i].start();
            i++;
        }
        System.out.println("Done starting threads");

        /* stop threads */

        i = 0;
        while (i < numThreads) {
            
            pressAnyKeyToContinue();
            System.out.println("Stopping thread " + i);
            threads[i].interrupt();
            try {
                threads[i].join();
            }
            catch (InterruptedException e) {
                System.out.println("This should not happen");
            }
            i++;
        }

        System.out.println("Threads all done");
    }

    private static void pressAnyKeyToContinue() { 
        System.out.println("Press Enter to start/stop a thread");
        try {
            System.in.read();
        }  catch(Exception e) {}  
    }
    
    /* inner class containing code for each thread to execute */

    private static class Inner implements Runnable {

        private int myID;

        public Inner(int myID) {
            this.myID = myID;
        }

        public void run() {
            while (true) {
                System.out.println("**** hello from " + myID);
                
                /* do something while waiting interrupt */
                try {
                      Thread.sleep(5000);
                } catch (InterruptedException e) {
                      System.out.println("**** good bye from " +myID );
                      break;     
                }
            }
       }

    }
}

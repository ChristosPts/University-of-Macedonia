/*
 * HelloIO.java
 *
 * Thread blocks to read from keyboard
 *
 */
public class HelloIO {

   public static void main(String[] args) {

    /* allocate array of thread objects */
    int numThreads = 20;
    Thread[] threads = new Thread[numThreads];

    /* create and start threads */
    for (int i = 0; i < numThreads; ++i) {
        System.out.println("In main: create and start thread " + i);
        threads[i] = new MyThread(i);
        threads[i].start();
        }
        
        /* wait for threads to finish */
        for (int i = 0; i < numThreads; ++i) {
            try {
                threads[i].join();
            }
            catch (InterruptedException e) {
                System.err.println("this should not happen");
            }
        }

        System.out.println("In main: threads all done");
    }
    
    /* inner class containing code for each thread to execute */
    
    private static class MyThread extends Thread {

        private int myID;

        public MyThread(int myID) {
            this.myID = myID;
        }

        public void run() {
            System.out.println("Thread "+myID+" Press Enter to continue");
            try {
                System.in.read();
            }  catch(Exception e) {}  
            System.out.println("Thread "+myID+" Exits");
       }
    }
}

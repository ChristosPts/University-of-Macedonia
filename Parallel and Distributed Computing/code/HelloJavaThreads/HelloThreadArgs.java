/*
 * HelloThreadArgs.java
 *
 * creates threads using a class extending Thread, with arguments.
 * 
 */
public class HelloThreadArgs {

    public static void main(String[] args) {

        /* allocate array of thread objecst */
        int numThreads = 20;
        Thread[] threads = new Thread[numThreads];

        /* create and start threads */
        for (int i = 0; i < numThreads; ++i) {
            System.out.println("In main: create and start thread " + i);
            threads[i] = new MyThread(i, numThreads);
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
}

/* class containing code for each thread to execute */
class MyThread extends Thread {

    /* instance variables */
    private int myID;
    private int totalThreads;

    /* constructor */
    public MyThread(int myID, int totalThreads) {
        this.myID = myID;
        this.totalThreads = totalThreads;
    }

    /* thread code */
    public void run() {
        System.out.println("Hello from thread " + myID + " out of " + totalThreads);
        System.out.println("Thread " + myID + " exits");
    } 

}


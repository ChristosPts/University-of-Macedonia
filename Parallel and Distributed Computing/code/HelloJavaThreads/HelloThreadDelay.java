/*
 * HelloThreadDelay.java
 *
 * creates threads using a class extending Thread. 
 * add some delay to create non-deterministic output
 *
 */
public class HelloThreadDelay {

        public static void main(String[] args) {

        /* allocate array of thread references*/
        int numThreads = 10;
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
        RandomDelay();
        System.out.println("hello from thread " + myID + " out of " + totalThreads);
        RandomDelay();
        System.out.println("thread " + myID + " exits");
    } 

    void RandomDelay() {
        int scale = 1000;
        try {
            sleep((int)(Math.random()*scale));
        } catch (InterruptedException e) { }
    }

}


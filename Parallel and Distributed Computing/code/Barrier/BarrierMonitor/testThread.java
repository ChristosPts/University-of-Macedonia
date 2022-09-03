class testThread extends Thread {
  	
    private int threadID;
   //private linearBarrier myBarrier;
    private cyclicBarrier myBarrier;
    
    
    //public testThread(int tid, linearBarrier bar) {
    public testThread(int tid, cyclicBarrier bar) {
    	this.threadID = tid;
    	this.myBarrier = bar;
    }
  	
    public void run() {
  
        for (;;) {
            System.out.println("Thread"+ threadID+ " started");
            myBarrier.barrier();
            try {
				sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {}
            System.out.println("Thread"+ threadID+ " reached barrier"); 
            myBarrier.barrier();
            System.out.println("Thread"+ threadID+ " passed barrier");
            myBarrier.barrier();
        } 
    }
}

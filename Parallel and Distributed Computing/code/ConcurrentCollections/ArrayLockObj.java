

public class ArrayLockObj {
 
	public static void main (String[] args) {
	 
		int[] list = new int[5];
		Object[] locklist = new Object[5];

		list[0]=0;
		list[1]=1;
		list[2]=2;
		list[3]=3;
		list[4]=4;
		locklist[0]=new Object();
		locklist[1]=new Object();
		locklist[2]=new Object();
		locklist[3]=new Object();
		locklist[4]=new Object();

		new AddThread(list, locklist).start();
		new ReadThread(list, locklist).start();
        	
	} 

	
	public static void delay (int d) {

	  	try {
			Thread.sleep((int)(Math.random()*d));
		} catch (InterruptedException e) { }
	}
	 
	 
	static class AddThread extends Thread {
	 
	    private int[] list;
	    private Object[] locklist;
	 
	    public AddThread(int[] list, Object[] locklist) {
	        this.list = list;
	        this.locklist = locklist;
	    }
	 
	    public void run() {
	        
	        int counter = 0;
	        while (true) {
	            delay(5000);
	            synchronized(locklist[counter]) {
			    	list[counter]++;
			        System.out.println("Add done");
			        counter = (counter+1)%5;
				}    	
	        }
	    }
	}
	 
	
	static class ReadThread extends Thread {
	    private int[] list;
	    private Object[] locklist;
	 
	    public ReadThread(int[] list, Object[] locklist) {
	        this.list = list;
	        this.locklist = locklist;
	    }
	 
	    public void run() {
	 
	        while (true) {
	            delay(100);
	            System.out.println("List :");
				for (int i=0; i<5; i++) {
					synchronized(locklist[i]) { 
						System.out.print(list[i]+" ");
						delay(100);
					}
				}	
	            System.out.println();	
	        }
	    }	
	} 
}

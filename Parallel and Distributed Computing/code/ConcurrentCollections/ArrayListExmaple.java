import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExmaple {
 
	public static void main (String[] args) {
	 
		ArrayList<Integer> list = new ArrayList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		new AddThread(list).start();
		new RemoveThread(list).start();
		new ReadThread(list).start();
		new UpdateThread(list).start();
        	
	} 

	
	public static void delay (int d) {

	  	try {
			Thread.sleep((int)(Math.random()*d));
		} catch (InterruptedException e) { }
	}
	 
	 
	static class AddThread extends Thread {
	 
	    private ArrayList<Integer> list;
	 
	    public AddThread(ArrayList<Integer> list) {
	        this.list = list;
	    }
	 
	    public void run() {
	       
	        while (true) {
	            delay(5000);
	            synchronized(list) {
	            	list.add(1);
	            	System.out.println("Add done");
	            }	
	        }
	    }
	}
	 
	static class RemoveThread extends Thread {
	 
	    private ArrayList<Integer> list;
	 
	    public RemoveThread(ArrayList<Integer> list) {
	        this.list = list;
	    }
	 
	    public void run() {
	        
	        while (true) {
	            delay(4000);
	            synchronized(list) {
	            	list.remove(1);
	            	System.out.println("Remove done");
	            }	
	        }
	    }
	} 

	static class UpdateThread extends Thread {
	 
	    private ArrayList<Integer> list;
	 
	    public UpdateThread(ArrayList<Integer> list) {
	        this.list = list;
	    }
	 
	    public void run() {
	        
	        while (true) {
	            delay(3000);
	            synchronized(list) {
	            	list.set(1, list.get(1)+1);
	            	System.out.println("Update done");
	            }	
	        }
	    }
	} 
	 
	static class ReadThread extends Thread {
	    private ArrayList<Integer> list;
	 
	    public ReadThread(ArrayList<Integer> list) {
	        this.list = list;
	    }
	 
	    public void run() {
	 
	        while (true) {
	            delay(100);
	            synchronized(list) { 
					String output = "\n Current ArrayList :";
					// must be in synchronized block 
					Iterator<Integer> iterator = list.iterator(); 
					Integer next;
					while (iterator.hasNext()) {
						next = iterator.next();
						output += " " + next;
						delay(100);
					}	
	            	System.out.println(output);
	            }	
	        }
	    }	
	} 
}

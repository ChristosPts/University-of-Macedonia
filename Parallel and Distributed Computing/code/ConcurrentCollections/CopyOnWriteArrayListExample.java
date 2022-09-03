import java.util.*;
import java.util.concurrent.*;
 
/**
 *
 * Based on www.codejava.net exmaple
 */
public class CopyOnWriteArrayListExample {
 
    public static void main(String[] args) {
 
        List<Integer> list = new CopyOnWriteArrayList<>();
        //List<Integer> list = new ArrayList<>();
 
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
	 
	    private List<Integer> list;
	 
	    public AddThread(List<Integer> list) {
	        this.list = list;
	    }
	 
	    public void run() {
	       
	        while (true) {
	            delay(5000);
	            list.add(1);
	            System.out.println("Add done");
	        }
	    }
	}
	 
	static class RemoveThread extends Thread {
	 
	    private List<Integer> list;
	 
	    public RemoveThread(List<Integer> list) {
	        this.list = list;
	    }
	 
	    public void run() {
	        
	        while (true) {
	            delay(4000);
	            list.remove(1);
	            System.out.println("Remove done");
	        }
	    }
	} 

	static class UpdateThread extends Thread {
	 
	    private List<Integer> list;
	 
	    public UpdateThread(List<Integer> list) {
	        this.list = list;
	    }
	 
	    public void run() {
	        
	        while (true) {
	            delay(3000);
	            list.set(1, list.get(1)+1);
	            System.out.println("Update done");
	        }
	    }
	} 
	 
	static class ReadThread extends Thread {
	    private List<Integer> list;
	 
	    public ReadThread(List<Integer> list) {
	        this.list = list;
	    }
	 
	    public void run() {
	 
	        while (true) {
	            String output = "\n Current List :";
	            Iterator<Integer> iterator = list.iterator();
	            while (iterator.hasNext()) {
	                Integer next = iterator.next();
	                output += " " + next;
			 		delay(100);
	            }
	            System.out.println(output);
	        }
	    }
	}
}	

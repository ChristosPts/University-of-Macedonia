import java.util.concurrent.*;
import java.util.*;
 
public class ExchangerExample {  
 
   public static void main(String[] args) {
 
      Exchanger<String> exchanger = new Exchanger<String>();
 
      Thread t1 = new MyThread(exchanger, "I like coffee.");
      Thread t2 = new MyThread(exchanger, "I like tea");
      t1.start();
      t2.start();
   }
}

class MyThread extends Thread {
 
   Exchanger<String> exchanger;
   String message;
 
   MyThread(Exchanger<String> exchanger, String message) {
      this.exchanger = exchanger;
      this.message = message;
   }
 
   public void run() {
      int scale = 500;
      while (true) {
	      try {
	         System.out.println(this.getName() + " sendig message: "+ message);
	         sleep((int)(Math.random() * scale));
	         message = exchanger.exchange(message);
	         System.out.println(this.getName() + " received message: "+ message);
	      } catch (Exception e) {}
      }
   }
}
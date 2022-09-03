import java.util.concurrent.BlockingQueue;
public class Consumer implements Runnable{

private BlockingQueue<Message> queue;
    
    public Consumer(BlockingQueue<Message> q){
        this.queue=q;
    }

    public void run() {
        try{
            Message msg=null;
            while(true){
				Thread.sleep(10);
				msg=queue.take();
				System.out.println("Consumed "+msg.getMsg());
            }
        } catch(InterruptedException e) {}
    }
}


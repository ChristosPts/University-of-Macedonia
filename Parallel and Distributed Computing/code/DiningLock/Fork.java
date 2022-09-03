import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Fork {

  private int identity;
  private Lock lock = new ReentrantLock();

  Fork(int id)
    {identity = id;}

  void get() {
  	lock.lock();
  }

  void put() {
       lock.unlock();
  }
}

import java.util.concurrent.Semaphore;

public class BankAccountSemaphore {
  private final Semaphore sem = new Semaphore(1);
  private long balance;

  public BankAccountReentrantLock(long balance) {
    this.balance = balance;
  }

  public void deposit(long amount) {
      try {
	    sem.acquire();
      } catch (InterruptedException e) { }
      balance += amount;
    sem.release();
  }

  public void withdraw(long amount) {
      try {
	    sem.acquire();
      } catch (InterruptedException e) { }
      balance -= amount;
      sem.release();
  }

  public long getBalance() {
      try {
    	    sem.acquire();
            return balance;
      } finally {      
      	    sem.release()
      } catch (InterruptedException e) { }
  }
}

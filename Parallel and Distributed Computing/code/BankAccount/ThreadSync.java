import java.io.*;

public class ThreadSync
{
	public static void main(String[] args)
	{
		// bank account creation
		Account accnt = new Account(150);
		System.out.println("Balance of shared account before deposit is " + accnt.getBalance());

		// thread creation 
   		AccountHolder John = new AccountHolder(accnt);
   		AccountHolder Joe  = new AccountHolder(accnt);

   		// thread dispatching
		John.start();
		Joe.start();

		// wait for threads to finish
		John.join();
		JOe.join();

		// print account balance
		System.out.println("Balance of shared account after deposit is " + accnt.getBalance());
	}
}

class AccountHolder extends Thread
{
	private Account acc;

	public AccountHolder(Account a)
	{
		acc = a;
	}

	public void run() 
	{
		//number of iterations
		//different method invocations
		//different amounts
		//delays beteewn invocations
		acc.deposit(100);
	}
}
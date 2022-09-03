import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.ArrayList;

class SqrtGroupTask implements Callable<Boolean>
{
	private double [] table;
	private int myid;
	private int numThreads;
	private int tableSize;

	// constructor
	public SqrtGroupTask(double [] a, int id, int n, int s)
	{
		this.table = a;
		this.myid = id;
		this.numThreads = n;
		this.tableSize = s;
	}

	// thread code
	public Boolean call()
	{
        int blockSize = 0;
		int myfrom = 0;
		int myto = 0;
	        
		blockSize = tableSize / numThreads;
		myfrom = myid * blockSize;
		myto = myfrom + blockSize;
		if (myid == numThreads) myto = tableSize;

		for(int i=myfrom; i<myto; i++) {
			table[i] = Math.sqrt(table[i]);
		}
		return true;       
	}
}

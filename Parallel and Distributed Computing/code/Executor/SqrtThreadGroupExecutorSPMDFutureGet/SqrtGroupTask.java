import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.ArrayList;

class SqrtGroupTask implements Callable<Double>
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
	public Double call()
	{
        int blockSize = 0;
		int myfrom = 0;
		int myto = 0;
        double mysum = 0.0;
	        
		blockSize = tableSize / numThreads;
		myfrom = myid * blockSize;
		myto = myfrom + blockSize;
		if (myid == numThreads) myto = tableSize;

		for(int i=myfrom; i<myto; i++) {
			mysum += table[i];
			table[i] = Math.sqrt(table[i]);
		}
		return Double.valueOf(mysum);       
	}
}

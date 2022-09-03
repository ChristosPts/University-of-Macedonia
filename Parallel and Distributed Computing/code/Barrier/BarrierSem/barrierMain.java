
public class barrierMain {

    public static void main(String[] args) {

        int numThreads = 2;  

        if (args.length != 1) {
		    System.out.println("Usage: java barrierMain <number of threads>");
		    System.exit(1);
		}

		try {
		    numThreads = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException nfe) {
		    System.out.println("Integer argument expected");
		    System.exit(1);
		}
	
        linearBarrier testBarrier = new linearBarrier(numThreads);
        //cyclicBarrier testBarrier = new cyclicBarrier(numThreads);
        
        
		testThread testThreads[] = new testThread[numThreads];
		for (int i = 0; i < numThreads; i++) {
		    testThreads[i] = new testThread(i, testBarrier);
		    testThreads[i].start();
		}
    }

}

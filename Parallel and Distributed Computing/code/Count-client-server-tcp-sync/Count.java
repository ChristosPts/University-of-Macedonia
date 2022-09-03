public class Count {
	private static int anum;
	
	public Count () {
		anum = 0;
	}

	public synchronized void increment() {
    	int temp;
		temp = anum;
		// Some delay
		System.out.println("Thread is "+ Thread.currentThread().getName()+" n <=" +temp);
		try {
			Thread.sleep((int)(Math.random()*100));
		} catch (InterruptedException e) { }
		temp = temp + 1;
		// More delay
		try {
			Thread.sleep((int)(Math.random()*100));
		} catch (InterruptedException e) { }
		anum = temp;
		System.out.println("Thread is "+ Thread. currentThread().getName()+" n =>" +temp);
        }

        public synchronized String print () {
		    return String.valueOf(anum);
        }
}

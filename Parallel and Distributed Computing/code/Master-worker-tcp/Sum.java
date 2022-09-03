public class Sum {
	private static int anum;
	private static int result;
	
	public Sum (int init) {
		anum = init;
		result = 0;
	}

	public synchronized void addTo(int toAdd) {
		result += toAdd;
	}

	public synchronized void printResult () {
	    System.out.println("Result =" + result);
	}
	
	public synchronized String printInit () {
	    return String.valueOf(anum);
	}
        
}

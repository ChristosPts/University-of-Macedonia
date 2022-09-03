/* Simple matrix vector multiplication ax = y       */
/* Use javac -Xmx1024m for larger matrices          */

class MatVecMulTimeArgs
{
  public static void main(String args[])
  {
    int size = 0;

    if (args.length != 1) {
		System.out.println("Usage: java MatVecMulTimeArgs <size>");
		System.exit(1);
    }

    try {
		size = Integer.parseInt(args[0]);
    }
    catch (NumberFormatException nfe) {
		System.out.println("Integer argument expected");
		System.exit(1);
    }
    if (size <= 0) {
		System.out.println("Attention: <size> should be >0");
		System.exit(1);
    }
 
    double[][] a = new double[size][size];
    for(int i = 0; i < size; i++)
    	for(int j = 0; j < size; j++)
		    a[i][j] = 1;
    
    double[] x = new double[size];
    double[] y = new double[size];
    for(int i = 0; i < size; i++) {
		x[i] = 1;
        y[i] = 0;
    }

    long start = System.currentTimeMillis();
		
    for (int i= 0; i < size; i++) {
        double sum = 0;
        for (int j = 0; j < size; j++) {
            sum = sum + a[i][j]*x[j];
        }
        y[i] = sum;
    }

    long elapsedTimeMillis = System.currentTimeMillis()-start;
    System.out.println("time in ms = "+ elapsedTimeMillis);

    /* for debugging 
    for(int i = 0; i < size; i++) 
        System.out.println(y[i]); */
  }
}

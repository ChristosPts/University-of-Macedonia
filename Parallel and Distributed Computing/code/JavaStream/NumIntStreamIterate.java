
import java.util.stream.Stream;
import java.util.*; 

public class NumIntStreamIterate {
 
	public static void main(String[] args) {
		int numSteps = 0;

        /* parse command line */
        if (args.length != 1) {
			System.out.println("arguments:  number_of_steps");
			System.exit(1);
        }
        try {
			numSteps = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
		System.out.println("argument "+ args[0] +" must be long int");
		System.exit(1);
        }
        /* start timing */
        long runTime = System.currentTimeMillis();
       	
		double step = 1.0 / (double)numSteps;	
	
		double sum = Stream
		             .iterate(0, i -> i+1)
					 .limit(numSteps)	             
					 .parallel()      
		             .mapToDouble(i -> mapFunction(i,step))
		     	     .reduce(0.0, Double::sum);
	
		double pi = sum*step;
		runTime = System.currentTimeMillis() - runTime;
		
		System.out.printf("computed pi = %22.20f\n" , pi);
		System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
		System.out.println("Time taken to complete: "+ runTime +" ms");
		
	}
	
	public static double mapFunction(int i, double step)
	{
		double x = ((double)i+0.5)*step;
		return 4.0/(1.0+x*x);
	}
}
 

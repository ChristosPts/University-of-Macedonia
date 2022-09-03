import java.util.ArrayList;
import java.util.List;
import java.util.*; 

public class VectorSqrtSumArray {
 
	public static void main(String[] args) {
		
		int size = 1000000;
        int sign = 1;
		double[] a = new double[size];
		for(int i = 0; i < size; i++) {
			//a[i] = i; 
			a[i] = sign*Math.random()*10; 
			sign = -sign;
		} 
                
		long runTime=System.currentTimeMillis();		
		double sum = Arrays.
		             stream(a).
					 parallel().       
				     map(number -> mapFunction(number)).
				     filter(number -> filterFunction(number)).
				     reduce(0.0, Double::sum);
		
		System.out.println(sum);
		runTime = System.currentTimeMillis() - runTime;
		System.out.println("Time taken to complete: "+ runTime +" ms");
		
	}
	
	public static double mapFunction(double number)
	{
		double sum = 0;
		for (int i = 1; i < 1000; i++) {
			sum += Math.sqrt(number);
		}
		return sum;
	}
	
	public static boolean filterFunction(double number)
	{
		return ((number < 2.0));
	}
}
 

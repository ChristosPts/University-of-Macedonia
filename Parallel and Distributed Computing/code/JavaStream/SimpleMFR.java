
import java.util.*; 

class SimpleMFR { 
	public static void main(String[] args) 
	{ 
        int size = 1000000;
        int sign = 1;
		double[] a = new double[size];
		for(int i = 0; i < size; i++) {
			//a[i] = i; 
			a[i] = sign*Math.random()*10; 
			//sign = -sign;
		}        
		
		System.out.println(sum(a)); 
	} 

	public static double sum(double a[]) 
	{ 
		return Arrays.
		       stream(a).
		       parallel().
		       filter(i -> i > 0).
		       map(i -> Math.sqrt(i)).
		       sum(); 
	} 
} 

class SeqVecSum
{
	public static void main(String[] args)
	{  
		double[] a = new double[1000];
		double sum;

		for(int i = 0; i < 1000; i++)
			a[i] = i; 
			//a[i] = Math.random()*1000; 

		sum = 0.0; 
		for(int i = 0; i < 1000; i++) 
			sum = sum + a[i];

		System.out.println(sum);
	}
}

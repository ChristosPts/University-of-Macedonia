class SeqSqrt
{
	public static void main(String[] args)
	{  
		double[] a = new double[1000];

		for(int i = 0; i < 1000; i++)
			a[i] = i; 
                        //a[i] = Math.random()*1000; 
		 
		for(int i = 0; i < 1000; i++) 
			a[i] = Math.sqrt(a[i]);

		for(int i = 0; i < 1000; i++) 
			System.out.println(a[i]);
	}

}

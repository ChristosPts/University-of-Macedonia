import java.lang.Math;

class SimpleSat {
	
	static int counter = 0;
    public static void main(String[] args) {  
        
        int size = 0;
        if (args.length != 1) {
            System.out.println("Usage: java SimpleSat <vector size>");
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
			System.out.println("size should be positive integer");
			System.exit(1);
        }
        int iterations = (int) Math.pow(2, size);
        // Saves Results
        String[] output = new String[iterations];
        
        long start = System.currentTimeMillis();
                
        for (int i = 0; i < iterations; i++)
            check_circuit (i, size, output);
           
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        
        for (int i = 0; i < counter; i++)
			System.out.println(output[i]); 
        
        System.out.println ("All done\n");
        System.out.println("time in ms = "+ elapsedTimeMillis);
        
    }
        
    static void check_circuit (int z, int size, String[] output) {
        
		boolean[] v = new boolean[size];  /* Each element is a bit of z */
    
		for (int i = size-1; i >= 0; i--) 
			v[i] = (z & (1 << i)) != 0;
    
       
       boolean value = 
           (  v[0]  ||  v[1]  )
        && ( !v[1]  || !v[3]  )
        && (  v[2]  ||  v[3]  )
        && ( !v[3]  || !v[4]  )
        && (  v[4]  || !v[5]  )
        && (  v[5]  || !v[6]  )
        && (  v[5]  ||  v[6]  )
        && (  v[6]  || !v[15] )
        && (  v[7]  || !v[8]  )
        && ( !v[7]  || !v[13] )
        && (  v[8]  ||  v[9]  )
        && (  v[8]  || !v[9]  )
        && ( !v[9]  || !v[10] )
        && (  v[9]  ||  v[11] )
        && (  v[10] ||  v[11] )
        && (  v[12] ||  v[13] )
        && (  v[13] || !v[14] )
        && (  v[14] ||  v[15] )
        && (  v[14] ||  v[16] )
        && (  v[17] ||  v[1]  )
        && (  v[18] || !v[0]  )
        && (  v[19] ||  v[1]  )
        && (  v[19] || !v[18] )
        && ( !v[19] || !v[9]  )
        && (  v[0]  ||  v[17] )
        && ( !v[1]  ||  v[20] )
        && ( !v[21] ||  v[20] )
        && ( !v[22] ||  v[20] )
        && ( !v[21] || !v[20] )
        && (  v[22] || !v[20] );
        
        
        if (value) {
			printResult(v, size, z, output, counter);
			counter++;
		}	
    }
    
    static void printResult (boolean[] v, int size, int z, String[] output, int counter) {
		
		String result = null;
		result = String.valueOf(z);

		for (int i=0; i< size; i++)
			if (v[i]) result += " 1";
			else result += " 0";
			
		//System.out.println(result);
		output[counter] = result;
	}	
    
}

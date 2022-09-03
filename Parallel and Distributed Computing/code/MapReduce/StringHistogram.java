import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class StringHistogram {

    public static void main(String args[]) throws IOException {

        if (args.length != 1) {
			System.out.println("StringHistogram <file name>");
			System.exit(1);
        }
        
        String fileString = new String(Files.readAllBytes(Paths.get(args[0])));//, StandardCharsets.UTF_8);
        char[] text = new char[fileString.length()]; 
        int n = fileString.length();
        for (int i = 0; i < n; i++) { 
            text[i] = fileString.charAt(i); 
        } 
 
        int alphabetSize = 256;
        int[] histogram = new int[alphabetSize]; 
        for (int i = 0; i < alphabetSize; i++) { 
            histogram[i] = 0; 
        }
        
        for (int i = 0; i < n; i++) {
			histogram[(int)text[i]] ++;
        }

        for (int i = 0; i < alphabetSize; i++) { 
            System.out.println((char)i+": "+histogram[i]);
        }
   }
}




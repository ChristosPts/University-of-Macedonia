import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class SetPixels {
   public static void main(String args[]) {
		//Reading the image
		String fileNameR = null;
		String fileNameW = null;
		
		if (args.length != 2) {
			System.out.println("Usage: java SetPixel <file to read > <file to write");
			System.exit(1);
		}
		fileNameR = args[0];
		fileNameW = args[1];
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(fileNameR));
		} catch (IOException e) {}

		long start = System.currentTimeMillis(); 
		
		int redShift = 100;
		int greenShift = 100;
		int blueShift = 100;
      
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				//Retrieving contents of a pixel
				int pixel = img.getRGB(x,y);
				//Creating a Color object from pixel value
				Color color = new Color(pixel, true);
				//Retrieving the R G B values, 8 bits per r,g,b
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				//Modifying the RGB values
				red = (red + redShift)%256;
				green = (green + greenShift)%256;
				blue = (blue + blueShift)%256;
				//Creating new Color object
				color = new Color(red, green, blue);
				//Setting new Color object to the image
				img.setRGB(x, y, color.getRGB());
			}
		}
	
	    long elapsedTimeMillis = System.currentTimeMillis()-start;
       
		//Saving the modified image
		try {
		  File file = new File(fileNameW);
		  ImageIO.write(img, "jpg", file);
		} catch (IOException e) {}
      
		System.out.println("Done...");
		System.out.println("time in ms = "+ elapsedTimeMillis);
   }
}

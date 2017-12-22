import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageEditor {

	public static void main(String[] args)
		throws IOException
	{
		ImageEditor a = new ImageEditor();
	    if (!a.checkValidArgs(args))
	      return;
	    Image in = new Image();    
	    try{in= a.loadImage();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    if (a.task.equals("motionblur"))
	    {
	    	a.blurImage(in);
	    }
	    else if(a.task.equals("grayscale"))
	    {
	    	a.grayImage(in);
	    }
	    else if (a.task.equals("emboss"))
	    {
	    	a.embossImage(in);
	    }
	    else if (a.task.equals("invert"))
	    {
	    	a.invertImage(in);
	    }
	  }

	private String infilename;
	private String outfilename;
	private String task;
	private Integer bluramount;
	public boolean checkValidArgs(String[] args)
	{
	      if (!(args.length==3||args.length==4))
	      {
	    	  System.out.println("USAGE: java ImageEditor in-file out-file (grayscale|invert|emboss|motionblur motion-blur-length)");
	    	  return false;
	      }
	      infilename =args[0];
	      outfilename=args[1];
	      task=args[2];
	      if (task.equals("motionblur"))
	      {
	    	  if (args.length!=4)
	    	  {
	    		  System.out.println("USAGE: java ImageEditor in-file out-file (grayscale|invert|emboss|motionblur motion-blur-length)");
		    	  return false;
	    	  }
	    	  else
	    	  {  
	    		  bluramount=new Integer(args[3]);
	    	   }
	      }
	      else if (args.length!=3)
	      {
	    	  System.out.println("USAGE: java ImageEditor in-file out-file (grayscale|invert|emboss|motionblur motion-blur-length)");
		   	  return false;
	      }
	      return true;
	}
	
	public void grayImage(Image inImage)
		throws IOException
	{
		Image outImage = new Image(inImage.getWidth(), inImage.getHeight());
		for (int i=0; i<inImage.getHeight(); i++)
		{
			for (int j=0; j<inImage.getWidth(); j++)
			{
				int pixelAverage = inImage.getPixelAverage(j, i);
				outImage.makeGrayPixel(j, i, pixelAverage);
			}
		}
		outImage.writeImage(outfilename);
	}
	
	
	public Image loadImage()
		throws FileNotFoundException
	{
	    Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream(infilename)));
	    sc.useDelimiter("\\s*#[^\\n]*\\n|\\s");
	    sc.next();
	    int width=sc.nextInt();
	    int height=sc.nextInt();
	    //System.out.println(width);
	    //System.out.println(height);

	    Image inImage=new Image(width, height);
	    if (sc.nextInt()!=255)
	    	System.out.println("Error, not 255");
	    for (int i=0; i<height; i++)
	    {
	    	for (int j=0; j<width; j++)
	    	{
	    		inImage.setPixel(j, i, sc.nextInt(), sc.nextInt(), sc.nextInt());
	    	}
	    }
	    if (sc.hasNext())
		    System.out.println("There is more information in the file");

	    //if (!sc.hasNext())
	    	return inImage;
	    	//else
	    //{System.out.println(sc.next());
	    //System.out.println("Image failed to load");
	    //return null;}
	}
	public void invertImage(Image inImage)
	throws IOException
	{
		Image outImage = new Image(inImage.getWidth(), inImage.getHeight());
		inImage.invertImage(outImage);
		outImage.writeImage(outfilename);
		
	}
	
	public void embossImage(Image inImage)
	throws IOException
	{
		inImage.emboss(outfilename);
		return;
	}
	
	public void blurImage(Image inImage)
	throws IOException
	{
		inImage.blur(bluramount, outfilename);
	}
}


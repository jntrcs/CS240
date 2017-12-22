import java.io.FileWriter;
import java.io.IOException;

public class Image {
	
	private Pixel[][] image;
	private int width;
	private int height;
	public Image(){}
	
	public Image(int width, int height)
	{
		this.width=width;
		this.height=height;
		image=new Pixel[width][height];
		for (int i=0; i<height; i++)
		{
			for (int j=0; j<width; j++)
			{
				image[j][i]=new Pixel();
			}
		}
	}
	
	public void emboss(String outname)
	throws IOException
	{
		Image outImage = new Image(width, height);
		for (int i=0; i<height; i++)
		{
			for (int j=0; j<width; j++)
			{
				Pixel topleft;
				if (i==0 ||j==0)
					topleft=null;
				else
					topleft=image[j-1][i-1];
				image[j][i].calculateV(topleft);
				outImage.makeGrayPixel(j, i, image[j][i].getV());
			}
		}
		outImage.writeImage(outname);
	}
	
	public int getWidth()
	{return width;}
	
	public int getHeight()
	{return height;}
	
	public void setPixel(int j, int i, int red, int green, int blue)
	{
		image[j][i].setRed(red);
		image[j][i].setGreen(green);
		image[j][i].setBlue(blue);
		return;
	}
	
	public void makeGrayPixel(int j, int i, int color)
	{
		image[j][i] = new Pixel(color);
		return;
	}
	
	public int getPixelAverage(int j, int i)
	{
		return image[j][i].getAverage();
	}
	
	public void invertImage(Image outImage)
	{
		for (int i=0; i<height; i++)
		{
			for (int j=0; j<width; j++)
			{
				Pixel invertedPixel= image[j][i].invertColors();
				outImage.setPixelInvert(j, i, invertedPixel);
				
			}
		}
	}
	
	public void setPixelInvert(int j, int i, Pixel p)
	{
		image[j][i] = p;
	}
	
	public void writeImage(String outfilename)
	throws IOException
	{
		StringBuilder s = new StringBuilder();
		s.append("P3 \n");
		s.append(width);
		s.append("\n");
		s.append(height);
		s.append("\n");
		s.append(255);
		s.append("\n");
		for (int i=0; i<height; i++)
		{
			for (int j=0; j<width; j++)
			{
				s.append(image[j][i].toString());
				s.append("\n");
			}
		}
		FileWriter f = new FileWriter(outfilename);
		
		f.write(s.toString());
		f.close();

		
		return;
	}
	
	public void blur(int n, String outname)
	throws IOException
	{
		Image outImage = new Image(width, height);

		for (int i=0; i<height; i++)
		{
			for (int j=0; j<width; j++)
			{
				int numpix;
				//Determine range
				if (j+n>width)
					numpix=width-j;
				else
					numpix=n;
				//sum color values
				int sumred=0;
				int sumblue=0;
				int sumgreen=0;
				for (int t=0; t<numpix; t++)
				{
					sumred+=image[j+t][i].getRed();
					sumblue+=image[j+t][i].getBlue();
					sumgreen+=image[j+t][i].getGreen();					
				}
				int finalred=sumred/numpix;
				int finalblue=sumblue/numpix;
				int finalgreen=sumgreen/numpix;
				outImage.setPixelInvert(j, i, new Pixel(finalred, finalgreen, finalblue));
			}
		}
		outImage.writeImage(outname);
	}
	
}

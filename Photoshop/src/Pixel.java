
public class Pixel {

	private int red;
	private int blue;
	private int green;
	private int v;
	
	public Pixel()
	{
	}
	
	public Pixel(int greynum)
	{
		red=greynum;
		blue=greynum;
		green=greynum;
	}
	
	public Pixel(int red, int green, int blue)
	{
		this.red=red;
		this.green=green;
		this.blue=blue;
	}
	
	public void calculateV(Pixel upperleft)
	{
		if (upperleft==null)
		{v = 128;
		return;
		}
		int reddif=red-upperleft.getRed();
		int greendif=green-upperleft.getGreen();
		int bluedif=blue-upperleft.getBlue();
		v=128+findabsmax(reddif, greendif,bluedif);
		if (v<0)
			v=0;
		else if (v>255)
			v=255;
		return;
	}
	
	public int getV()
	{
		return v;
	}
	
	public int findabsmax(int r, int g, int b)
	{
		if (Math.abs(r)>= Math.abs(g) && Math.abs(r)>=Math.abs(b))
			return r;
		else if (Math.abs(g)>=Math.abs(r) && Math.abs(g)>=Math.abs(b))
			return g;
		else if (Math.abs(b)>=Math.abs(r) && Math.abs(b)>Math.abs(g))
			return b;
		else return 5000;
	}
	
	public int getRed()
	{
		return red;
	}
	
	public int getAverage()
	{
		return (red+blue+green)/3;
	}
	
	public int getBlue()
	{
		return blue;
	}
	
	public int getGreen()
	{
		return green;
	}
	
	public void setRed(int newred)
	{
		red=newred;
		return;
	}
	
	public void setBlue(int newblue)
	{
		blue=newblue;
		return;
	}
	
	public void setGreen(int newgreen)
	{
		green = newgreen;
		return;
	}
	
	public Pixel invertColors()
	{
		int newred=255-red;
		int newgreen=255-green;
		int newblue = 255-blue;
		return new Pixel(newred, newgreen, newblue);
	}
	
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append(red);
		s.append(" ");
		s.append(green);
		s.append(" ");
		s.append(blue);
		return s.toString();
	}
	
	
}

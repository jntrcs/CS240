package edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects;

/**
 * Inherited class that defines all definitions with image
 * Created by jntrcs on 2/5/16.
 */
public class ImageObject {

    public ImageObject()
    {
        pathname=null;
        height=0;
        width=0;
    }
    public ImageObject(String path)
    {
        pathname=path;
        width=0;
        height=0;
    }
    /**
     * Contains the image path, it's height and width
     */

    public ImageObject(String path, int width, int height)
    {
        pathname=path;
        this.height=height;
        this.width=width;
    }
    private String pathname;
    private int height;
    private int width;

    public static int[] parsePos(String pos)
    {
        StringBuilder p = new StringBuilder(pos);
        int comma=pos.indexOf(',');
        int[] result = new int[2];
        result[0] = Integer.parseInt(p.substring(0,comma));
        result[1] = Integer.parseInt(p.substring(comma+1, p.length()));
        return result;
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getPathname() {
        return pathname;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }
}

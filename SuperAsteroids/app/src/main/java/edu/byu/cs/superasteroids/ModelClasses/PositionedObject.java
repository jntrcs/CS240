package edu.byu.cs.superasteroids.ModelClasses;

/**
 * Inherited class that models all objects that are positioned in the world
 * Created by jntrcs on 2/5/16.
 */
public class PositionedObject extends VisibleObjects {

    private int xpos;
    private int ypos;
    private int xsize;
    private int ysize;

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public void update()
    {

    }

    public void draw()
    {

    }
    /**
     * Determines if it intersects with the viewfinder
     * @returns true if should be drawn
     */
    public boolean determineIfDraw()
    {
        return false;
    }
}

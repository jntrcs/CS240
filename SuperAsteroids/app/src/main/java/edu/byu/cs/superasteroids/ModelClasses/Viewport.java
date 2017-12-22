package edu.byu.cs.superasteroids.ModelClasses;

/**
 * Tracks the location of the viewport
 * Created by jntrcs on 2/8/16.
 */
public class Viewport {
    /**
     * tracks the position of the top left corner
     */
    private int topleftx;
    private int toplefty;
    private int widthx;
    private int heighty;

    /**
     * Update function for the viewfinder
     */
    public void update()
    {

    }

    public int getTopleftx() {
        return topleftx;
    }

    public void setTopleftx(int topleftx) {
        this.topleftx = topleftx;
    }

    public int getToplefty() {
        return toplefty;
    }

    public void setToplefty(int toplefty) {
        this.toplefty = toplefty;
    }
}

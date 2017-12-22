package edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects;

/**
 * Created by jntrcs on 2/15/16.
 */
public class LevelBackgroundDefinitions {
    double scale;
    int xpos;
    int ypos;
    int level;
    int bgID;

    public LevelBackgroundDefinitions(int level, String position, int bgID, double scale)
    {
        this.level=level;
        this.bgID=bgID;
        this.scale=scale;
        int[] parsed=ImageObject.parsePos(position);
        xpos=parsed[0];
        ypos=parsed[1];
    }

    public LevelBackgroundDefinitions(int level, int xpos, int ypos, int bgID, double scale)
    {
        this.level=level;
        this.xpos=xpos;
        this.ypos=ypos;
        this.bgID=bgID;
        this.scale=scale;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBgID() {
        return bgID;
    }

    public void setBgID(int bgID) {
        this.bgID = bgID;
    }


}

package edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects;

import edu.byu.cs.superasteroids.ModelClasses.Body;

/**
 * Defines a ship body
 * Created by jntrcs on 2/10/16.
 */
public class BodyDef extends ImageObject {

    private int engineAttachx;
    private int engineAttachy;
    private int cannonAttachx;

    public BodyDef(int engineAttachx, int engineAttachy, int cannonAttachx, int cannonAttachy, int extraAttachx, int extraAttachy, String path, int width, int height) {
        super(path, height, width);
        this.engineAttachx = engineAttachx;
        this.engineAttachy = engineAttachy;
        this.cannonAttachx = cannonAttachx;
        this.cannonAttachy = cannonAttachy;
        this.extraAttachx = extraAttachx;
        this.extraAttachy = extraAttachy;
    }

    public BodyDef(String cannon, String engine, String extra,String image, int width, int height)
    {
        super(image,width,height);
        int[] eparse=ImageObject.parsePos(engine);
        engineAttachx=eparse[0];
        engineAttachy=eparse[1];
        int[] cparse = ImageObject.parsePos(cannon);
        cannonAttachx=cparse[0];
        cannonAttachy=cparse[1];
        int[] exparse=ImageObject.parsePos(extra);
        extraAttachx=exparse[0];
        extraAttachy=exparse[1];
    }

    private int cannonAttachy;
    private int extraAttachx;
    private int extraAttachy;

    public void setEngineAttachx(int engineAttachx) {
        this.engineAttachx = engineAttachx;
    }

    public void setEngineAttachy(int engineAttachy) {
        this.engineAttachy = engineAttachy;
    }

    public void setCannonAttachx(int cannonAttachx) {
        this.cannonAttachx = cannonAttachx;
    }

    public void setCannonAttachy(int cannonAttachy) {
        this.cannonAttachy = cannonAttachy;
    }

    public void setExtraAttachx(int extraAttachx) {
        this.extraAttachx = extraAttachx;
    }

    public void setExtraAttachy(int extraAttachy) {
        this.extraAttachy = extraAttachy;
    }

    public int getExtraAttachy() {

        return extraAttachy;
    }

    public int getEngineAttachy() {
        return engineAttachy;
    }

    public int getCannonAttachx() {
        return cannonAttachx;
    }

    public int getCannonAttachy() {
        return cannonAttachy;
    }

    public int getExtraAttachx() {
        return extraAttachx;
    }

    public int getEngineAttachx() {
        return engineAttachx;
    }

}

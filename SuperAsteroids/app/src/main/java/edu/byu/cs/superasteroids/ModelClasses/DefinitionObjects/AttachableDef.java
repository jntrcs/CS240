package edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects;

/**
 * Inherited class that defines all attachable objects
 * Created by jntrcs on 2/10/16.
 */
public class AttachableDef extends ImageObject {


    private int attachpointx;
    private int attachpointy;

    public AttachableDef(int atptx, int atpty, String path, int width, int height)
    {
        super(path, width, height);
        attachpointx=atptx;
        attachpointy=atpty;
    }
    public int getAttachpointy() {
        return attachpointy;
    }

    public void setAttachpointy(int attachpointy) {
        this.attachpointy = attachpointy;
    }

    public int getAttachpointx() {
        return attachpointx;
    }

    public void setAttachpointx(int attachpointx) {
        this.attachpointx = attachpointx;
    }
}

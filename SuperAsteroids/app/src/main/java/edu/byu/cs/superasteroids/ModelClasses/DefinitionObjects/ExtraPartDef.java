package edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects;

import edu.byu.cs.superasteroids.ModelClasses.ExtraPart;

/**
 * Defines an extra part
 * Created by jntrcs on 2/10/16.
 */
public class ExtraPartDef extends AttachableDef {
    public ExtraPartDef(int atx, int aty, String im, int iw, int ih)
    {
        super(atx, aty, im, iw, ih);
    }

    public ExtraPartDef(String attach, String i, int iw, int ih)
    {
        super(parsePos(attach)[0], parsePos(attach)[1], i, iw, ih);
    }

}

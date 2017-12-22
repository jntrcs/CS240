package edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects;

import edu.byu.cs.superasteroids.ModelClasses.PowerCore;

/**
 * Defines the powercore with it's boosting power
 * Created by jntrcs on 2/10/16.
 */
public class PowercoreDef extends ImageObject {

    public PowercoreDef(int cboost, int eboost, String i)
    {
        super(i);
        cannonboost=cboost;
        engineboost=eboost;
    }

    public int getEngineboost() {
        return engineboost;
    }

    public void setEngineboost(int engineboost) {
        this.engineboost = engineboost;
    }

    public int getCannonboost() {
        return cannonboost;
    }

    public void setCannonboost(int cannonboost) {
        this.cannonboost = cannonboost;
    }

    private int cannonboost;
    private int engineboost;
}

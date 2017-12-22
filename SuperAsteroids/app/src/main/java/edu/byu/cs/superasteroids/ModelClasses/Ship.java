package edu.byu.cs.superasteroids.ModelClasses;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.PowercoreDef;

/**
 * Models the ship object
 * Created by jntrcs on 2/5/16.
 */
public class Ship extends MovingObject {

    private Body body;
    private Engine engine;
    private Cannon cannon;
    private ExtraPart extrapart;
    private PowercoreDef powercore;

    private int rotationangle;

    /**
     * Turns the ship when finger is detected
     */
    public void turn()
    {

    }

    /**
     * Will accelerate the ship toward the direction of the finger
     */
    public void accelerate()
    {

    }
    /**
     * Fires a projectile from the gun
     */
    public void fireProjectile(Space s)
    {
        cannon.fire(s);
    }
}

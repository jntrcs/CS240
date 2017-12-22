package edu.byu.cs.superasteroids.ModelClasses;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.AsteroidDefinition;

/**
 *Inherited class for all types of asteroids
 * Created by jntrcs on 2/5/16.
 */
public abstract class Asteroid extends MovingObject {

    private int livesleft;

    Asteroid()
    {
        livesleft=4;
    }

    /**
     * Deals with a collision with a ship or a projectile
     */
    @Override
    public void touch()
    {

    }

    /**
     * Splits an asteroid when hit and adds the new asteroids to the map
     * @param s--The space object
     */
    public abstract void split(Space s);

    public int getLivesleft() {
        return livesleft;
    }

    public void decrementLives()
    {
        livesleft--;
    }

    public void setLivesleft(int livesleft) {
        this.livesleft = livesleft;
    }
}

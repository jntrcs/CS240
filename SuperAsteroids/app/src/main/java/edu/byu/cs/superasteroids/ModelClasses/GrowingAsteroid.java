package edu.byu.cs.superasteroids.ModelClasses;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.AsteroidDefinition;
//import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.GrowingAsteroidDef;

/**
 * Models a growing asteroid
 * Created by jntrcs on 2/5/16.
 */
public class GrowingAsteroid extends Asteroid {
    private AsteroidDefinition GA;

    /**
     * Splits the asteroids and makes them bigger
     * @param s
     */
    @Override
    public void split(Space s)
    {
    }
}

package edu.byu.cs.superasteroids.ModelClasses;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.AsteroidDefinition;
//import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.NormalAsteroidDef;

/**
 * Models an asteroid of normal type
 * Created by jntrcs on 2/5/16.
 */
public class NormalAsteroid extends Asteroid {

    private AsteroidDefinition def;

    NormalAsteroid(AsteroidDefinition def)
    {
        super();
        this.def=def;
    }

    public void split(Space s)
    {

    }
}

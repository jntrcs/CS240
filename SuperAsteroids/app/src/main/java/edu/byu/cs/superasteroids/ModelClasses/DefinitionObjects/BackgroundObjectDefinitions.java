package edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects;

import edu.byu.cs.superasteroids.ModelClasses.BackgroundObject;

/**
 * defines a background object
 * Created by jntrcs on 2/8/16.
 */
public class BackgroundObjectDefinitions extends ImageObject{
    int id;
    public BackgroundObjectDefinitions(String path, int id)
    {
        super(path);
        this.id=id;
    }

    public BackgroundObjectDefinitions(String path)
    {
        super(path);
    }

}

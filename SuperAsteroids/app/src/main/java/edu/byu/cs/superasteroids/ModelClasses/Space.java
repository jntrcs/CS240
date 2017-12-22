package edu.byu.cs.superasteroids.ModelClasses;

import java.util.Set;

/**
 * Contains all objects that are a part of the current world.
 * Created by jntrcs on 2/8/16.
 */
public class Space {
    /**
     * All objects that are a part of the current level
     */
    private Set<MovingObject> allmoving;
    private Set<PositionedObject> allobjects;
    private Viewport v;
    private MiniMap map;
    /**
     * Aids in cascading of all drawing, will call the draw function on allobjects
     */
    public void draw()
    {

    }

    /**
     * will update allobjects, map and viewfinder
     */
    public void update()
    {

    }

    /**
     * Allows you to add a moving object to space, like a projectile or asteroid
     */
    public void addObject(MovingObject mo)
    {

    }

    /**
     * Removes an object from space
     * @param mo the object to be removed
     */
    public void destroy(MovingObject mo)
    {

    }

    /**
     * Will detect collisions between any moving objects and call the necessary collision functions
     */
    public void detectCollisions()
    {

    }
}

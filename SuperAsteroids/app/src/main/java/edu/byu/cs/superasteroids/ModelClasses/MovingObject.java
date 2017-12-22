package edu.byu.cs.superasteroids.ModelClasses;

/**
 * Inherited class for any object that moves and collides
 * Created by jntrcs on 2/5/16.
 */
public class MovingObject extends PositionedObject {

    int speed;
    int direction;

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    /**
     * Overrides the update function to move any moving object
     */
    @Override
    public void update()
    {

    }

    /**
     * Call if hit the edge of level, will change direction
     */
    public void bounce()
    {

    }

    public void touch()
    {

    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}

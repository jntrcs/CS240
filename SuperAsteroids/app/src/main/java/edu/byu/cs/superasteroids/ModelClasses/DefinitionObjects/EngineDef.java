package edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects;

/**
 * Defines an engine
 * Created by jntrcs on 2/10/16.
 */
public class EngineDef extends AttachableDef {
    private int speed;

    public int getTurnrate() {
        return turnrate;
    }

    public void setTurnrate(int turnrate) {
        this.turnrate = turnrate;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private int turnrate;

    public EngineDef(int atx, int aty, String im, int iw,int ih, int speed, int turn)
    {
        super(atx, aty, im, iw, ih);
        this.speed=speed;
        turnrate=turn;
    }

    public EngineDef(String attach, String i, int iw, int ih, int speed, int turn)
    {
        super(parsePos(attach)[0], parsePos(attach)[1], i, iw, ih);
        this.speed=speed;
        turnrate=turn;
    }

}

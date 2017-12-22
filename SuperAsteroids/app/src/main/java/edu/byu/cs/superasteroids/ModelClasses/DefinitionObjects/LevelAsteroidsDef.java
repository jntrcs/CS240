package edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects;

/**
 * Created by jntrcs on 2/16/16.
 */
public class LevelAsteroidsDef {
    private int asteroidType;
    private int amount;
    private int level;

    public LevelAsteroidsDef(int at, int am, int l)
    {
        asteroidType=at;
        amount = am;
        level = l;
    }

    public int getAsteroidType() {
        return asteroidType;
    }

    public void setAsteroidType(int asteroidType) {
        this.asteroidType = asteroidType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

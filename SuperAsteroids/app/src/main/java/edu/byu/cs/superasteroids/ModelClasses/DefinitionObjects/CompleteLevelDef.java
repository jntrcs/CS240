package edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects;

import java.util.List;

/**
 * Created by jntrcs on 2/19/16.
 */
public class CompleteLevelDef {
    private LevelDefinition thelevel;
    private List<LevelAsteroidsDef> asteroids;
    private List<LevelBackgroundDefinitions> bgObjects;

    public LevelDefinition getThelevel() {
        return thelevel;
    }

    public void setThelevel(LevelDefinition thelevel) {
        this.thelevel = thelevel;
    }
}

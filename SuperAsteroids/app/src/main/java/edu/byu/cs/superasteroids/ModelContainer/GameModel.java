package edu.byu.cs.superasteroids.ModelContainer;

import java.util.List;

import edu.byu.cs.superasteroids.DataAccessPackage.Database;
import edu.byu.cs.superasteroids.ModelClasses.Cannon;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.AsteroidDefinition;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.BackgroundObjectDefinitions;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.BodyDef;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.CannonDef;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.CompleteLevelDef;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.ExtraPartDef;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.LevelAsteroidsDef;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.PowercoreDef;
import edu.byu.cs.superasteroids.ModelClasses.Engine;
import edu.byu.cs.superasteroids.ModelClasses.PowerCore;

/**
 * Created by jntrcs on 2/19/16.
 */
public class GameModel {

    private static List<BodyDef> bods;
    private static List<CannonDef> cans;
    private static List<AsteroidDefinition> astdefs;
    private static List<BackgroundObjectDefinitions> bgDefs;
    private static List<Engine> engines;
    private static List<ExtraPartDef> eps;
    private static List<PowercoreDef> pcs;
    private static List<CompleteLevelDef> allLevels;


    /**
     * This loads all the data from the Database into the model objects
     */
    public static void loadData(Database db)
    {
        bods=db.getShipbodiesDAO().read();
        cans=db.getCannonDAO().read();
    }
}

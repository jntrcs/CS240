package edu.byu.cs.superasteroids.ModelContainer;

import edu.byu.cs.superasteroids.DataAccessPackage.Database;
import edu.byu.cs.superasteroids.DataAccessPackage.DbOpenHelper;

/**
 * Created by jntrcs on 2/19/16.
 */
public class AsteroidCore {

    private static Database db;
    private static GameModel gm;


    public static void reload()
    {
        gm.loadData(db);
    }

    public static Database getDb() {
        return db;
    }

    public static GameModel getGm() {
        return gm;
    }
}

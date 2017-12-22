package edu.byu.cs.superasteroids.importer;

import android.content.Context;

import java.io.InputStreamReader;

import edu.byu.cs.superasteroids.DataAccessPackage.Database;
import edu.byu.cs.superasteroids.ModelContainer.AsteroidCore;
import edu.byu.cs.superasteroids.ModelContainer.GameModel;

/**
 * Created by jntrcs on 2/4/16.
 */
public class GameDataImporter implements IGameDataImporter {
    private Context context;
    private Database dbManager;
    public GameDataImporter(Context c)
    {
        context=c;
        dbManager = new Database(context);
    }
    /**
     * Imports data from the provided JSON file into the SQL Database
     * @param dataInputReader The InputStreamReader connected to the .json file needing to be imported.
     * @return true if successful
     */
    @Override
    public boolean importData(InputStreamReader dataInputReader) {
        dbManager.parseJSON(dataInputReader);
        AsteroidCore.reload();
        return true;
    }
}

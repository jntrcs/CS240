package edu.byu.cs.superasteroids.DataAccessPackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.AsteroidDefinition;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.BodyDef;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.CannonDef;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.EngineDef;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.ExtraPartDef;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.LevelAsteroidsDef;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.LevelBackgroundDefinitions;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.LevelDefinition;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.PowercoreDef;

/**
 * The Database management class
 * Created by jntrcs on 2/9/16.
 */
public class Database {
private DbOpenHelper dbOpenHelper;
    private SQLiteDatabase db;
    private Context context;
    /**
     * a particular instance of all my DAO objects.
     */
    public AsteroidTypesAO AsttypeDAO;
    public BackgroundObjectsAO BgObDAO;
    public LevelAsteroidsAO levelAsteroidsDAO;
    public LevelBackgroundAO levelBgDAO;
    public LevelDefinitionAO levelDAO;
    public ExtraPartAO extrapartDAO;
    public EngineAO engineDAO;
    public CannonsAO cannonDAO;
    public PowercoreAO powercoreDAO;
    public ShipBodiesAO shipbodiesDAO;

    /**
     * Creates the database
     * @param baseContext
     */
    public Database(Context baseContext)
    {
        this.context=baseContext;
        dbOpenHelper = new DbOpenHelper(context);
        db = dbOpenHelper.getWritableDatabase();
        AsttypeDAO = new AsteroidTypesAO(db);
        BgObDAO = new BackgroundObjectsAO(db);
        levelBgDAO=new LevelBackgroundAO(db);
        levelAsteroidsDAO = new LevelAsteroidsAO(db);
        levelDAO=new LevelDefinitionAO(db);
        extrapartDAO=new ExtraPartAO(db);
        engineDAO = new EngineAO(db);
        cannonDAO= new CannonsAO(db);
        powercoreDAO = new PowercoreAO(db);
        shipbodiesDAO = new ShipBodiesAO(db);
    }


    public BackgroundObjectsAO getBgObDAO() {
        return BgObDAO;
    }

    public AsteroidTypesAO getAsttypeDAO() {
        return AsttypeDAO;
    }

    public LevelAsteroidsAO getLevelAsteroidsdAO() {
        return levelAsteroidsDAO;
    }

    public LevelBackgroundAO getLevelBgDAO() {
        return levelBgDAO;
    }

    public LevelDefinitionAO getLevelDAO() {
        return levelDAO;
    }

    public ExtraPartAO getExtrapartDAO() {
        return extrapartDAO;
    }

    public EngineAO getEngineDAO() {
        return engineDAO;
    }

    public CannonsAO getCannonDAO() {
        return cannonDAO;
    }

    public PowercoreAO getPowercoreDAO() {
        return powercoreDAO;
    }

    public ShipBodiesAO getShipbodiesDAO() {
        return shipbodiesDAO;
    }

    private static String makeString(Reader reader) throws IOException {

        StringBuilder sb = new StringBuilder();
        char[] buf = new char[512];

        int n = 0;
        while ((n = reader.read(buf)) > 0) {
            sb.append(buf, 0, n);
        }

        return sb.toString();
    }
    /**
     * Will parse the JSON file and insert into database
     */
    public void parseJSON(InputStreamReader file)
    {
        dbOpenHelper.onCreate(db);
        AssetManager manager = context.getAssets();
        Reader reader;
        try {
            //InputStream input = manager.open(filename);
            reader = file;

            JSONObject rootObject = new JSONObject(makeString(reader));
            JSONObject game = rootObject.getJSONObject("asteroidsGame");
            JSONArray asteroidArr = null;
            JSONArray bgArr=game.getJSONArray("objects");
            for (int i = 0; i<bgArr.length(); ++i)
            {
                BgObDAO.insert(bgArr.getString(i));
            }
            asteroidArr = game.getJSONArray("asteroids");
            for (int i=0; i<asteroidArr.length(); i++)
            {
                JSONObject ast = asteroidArr.getJSONObject(i);
                AsttypeDAO.insert(new AsteroidDefinition(ast.getString("name"), ast.getString("image"), ast.getInt("imageHeight"), ast.getInt("imageWidth")));
            }

            JSONArray levelArray = game.getJSONArray("levels");
            for (int i = 0; i<levelArray.length(); i++)
            {
                JSONObject level = levelArray.getJSONObject(i);
                levelDAO.insert(new LevelDefinition(level.getInt("number"), level.getString("title"), level.getString("hint"), level.getInt("width"), level.getInt("height"), level.getString("music")));
                JSONArray objects = level.getJSONArray("levelObjects");
                JSONArray ast=level.getJSONArray("levelAsteroids");
                for (int s = 0; s<ast.length(); s++)
                {
                    JSONObject asteroid = ast.getJSONObject(s);
                    levelAsteroidsDAO.insert(new LevelAsteroidsDef(asteroid.getInt("asteroidId"), asteroid.getInt("number"), level.getInt("number")));
                }
                for (int j = 0; j<objects.length(); j++)
                {
                    JSONObject object = objects.getJSONObject(j);
                    levelBgDAO.insert(new LevelBackgroundDefinitions(level.getInt("number"), object.getString("position"), object.getInt("objectId"), object.getDouble("scale")));
                }
            }

            JSONArray ships = game.getJSONArray("mainBodies");
            for (int i = 0; i<ships.length(); i++)
            {
                JSONObject ship = ships.getJSONObject(i);
                shipbodiesDAO.insert(new BodyDef(ship.getString("cannonAttach"), ship.getString("engineAttach"), ship.getString("extraAttach"), ship.getString("image"), ship.getInt("imageWidth"), ship.getInt("imageHeight")));
            }

            JSONArray cannons = game.getJSONArray("cannons");
            for (int i = 0; i<cannons.length(); i++)
            {
                JSONObject cannon = cannons.getJSONObject(i);
                cannonDAO.insert(new CannonDef(cannon.getString("attachPoint"), cannon.getString("emitPoint"), cannon.getString("image"), cannon.getInt("imageWidth"),
                        cannon.getInt("imageHeight"), cannon.getString("attackImage"), cannon.getInt("attackImageWidth"),
                        cannon.getInt("attackImageHeight"), cannon.getInt("damage"),cannon.getString("attackSound")));
            }
            JSONArray exparts = game.getJSONArray("extraParts");
            for (int i =0; i<exparts.length(); i++)
            {
                JSONObject expart = exparts.getJSONObject(i);
                extrapartDAO.insert(new ExtraPartDef(expart.getString("attachPoint"), expart.getString("image"),
                        expart.getInt("imageWidth"), expart.getInt("imageHeight")));
            }
            JSONArray engines = game.getJSONArray("engines");
            for (int i = 0; i<engines.length(); i++)
            {
                JSONObject eng = engines.getJSONObject(i);
                engineDAO.insert(new EngineDef(eng.getString("attachPoint"), eng.getString("image"), eng.getInt("imageWidth"),
                        eng.getInt("imageHeight"),eng.getInt("baseSpeed"), eng.getInt("baseTurnRate")));
            }

            JSONArray pcs = game.getJSONArray("powerCores");
            for (int i = 0; i<pcs.length();i++)
            {
                JSONObject pc = pcs.getJSONObject(i);
                powercoreDAO.insert(new PowercoreDef(pc.getInt("cannonBoost"), pc.getInt("engineBoost"), pc.getString("image")));
            }

            file.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

        public static final class AsteroidTypeTable
        {
            public static final String name = "AsteroidTypes";

            public static final class Cols{
                public static final String col1="TypeID";
                public static final String col2="Name";
                public static final String col3="Image";
                public static final String col4="ImageHeight";
                public static final String col5="ImageWidth";
            }
        }

    public static final class BackgroundObjectTable
    {
        public static final String name="BackGroundObjects";
        public static final class Cols{
            public static final String col1 = "ID";
            public static final String col2 ="ImagePath";
        }
    }

    public static final class LevelBackgroundTable
    {
        public static final String name = "LevelBackground";
        public static final class Cols{
            public static final String col1 = "LevelID";
            public static final String col2 ="XPosition";
            public static final String col3 = "YPosition";
            public static final String col4 ="BgObjectsID";
            public static final String col5 = "Scale";
        }
    }

    public static final class LevelTable
    {
        public static final String name = "Levels";
        public static final class Cols{
            public static final String col1 = "Number";
            public static final String col2="Title";
            public static final String col3="Hint";
            public static final String col4= "Width";
            public static final String col5="Height";
            public static final String col6="Music";
        }
    }

    public static final class LevelAsteroids
    {
        public static final String name = "LevelAsteroidTable";
        public static final class Cols {
            public static final String col1="AsteroidType";
            public static final String col2="Amount";
            public static final String col3="Level";

        }
    }

    public static final class shipBodies
    {
        public static final String name ="ShipBodiesTable";
        public static final class Cols
        {
            public static final String col1="CannonAttachx";
            public static final String col2="CannonAttachy";
            public static final String col3="EngineAttachx";
            public static final String col4="EngineAttachy";
            public static final String col5="ExtraAttachx";
            public static final String col6="ExtraAttachy";
            public static final String col7="ImagePath";
            public static final String col8="ImageWidth";
            public static final String col9 = "ImageHeight";
        }
    }

    public static final class cannonsTable
    {
        public static final String name = "CannonTable";
        public static final class Cols
        {
            public static final String cols1="AttachPointX";
            public static final String cols2="AttachPointY";
            public static final String cols3 = "EmitX";
            public static final String cols4="EmitY";
            public static final String cols5="Image";
            public static final String cols6="ImageWidth";
            public static final String cols7="ImageHeight";
            public static final String cols8="AttackImage";
            public static final String cols9="AttackImageWidth";
            public static final String cols10="AttackImageHeight";
            public static final String cols11="AttackSound";
            public static final String cols12="Damage";

        }
    }

    public static final class ExtraParts
    {
        public static final String name="ExtraPartsTable";
        public static final class Cols
        {
            public static final String col1="AttachPointX";
            public static final String col2="AttachPointY";
            public static final String col3="ImagePath";
            public static final String col4="ImageWidth";
            public static final String col5="ImageHeight";
        }
    }

    public static final class Engines
    {
        public static final String name="EnginesTable";
        public static final class Cols
        {
            public static final String col1="AttachPointX";
            public static final String col2="AttachPointY";
            public static final String col3="ImagePath";
            public static final String col4="ImageWidth";
            public static final String col5="ImageHeight";
            public static final String col6="BaseSpeed";
            public static final String col7="TurnRate";
        }
    }

    public static final class PowerCores
    {
        public static final String name="PowerCoreTable";
        public static final class Cols
        {
            public static final String col1="CannonBoost";
            public static final String col2="EngineBoost";
            public static final String col3="ImagePath";
        }
    }

    public static Cursor queryAll(String table, SQLiteDatabase base)
    {
        String query = "Select * from " + table;
        Cursor c= base.rawQuery(query, null);
        c.moveToFirst();
        return c;
    }
}


/*
public class Database {
    private DbOpenHelper dbOpenHelper;
    private SQLiteDatabase database;
    private Context baseContext;

    public CD_DAO cdDAO;

    //Constructor
    public Database(Context baseContext) {
        this.baseContext = baseContext;
        dbOpenHelper = new DbOpenHelper(baseContext);
        database = dbOpenHelper.getWritableDatabase();
        cdDAO = new CD_DAO(database);
    }
    //Queries
    public CD_DAO getCD_DAO() {
        return cdDAO;
    }

    public void open(String fileName) {

    }

    //Commands
    //See if you can follow the traversal of our JSON tree.
    //The root of our tree is a JSONObject with a single member named "CATALOG".
    //The CATALOG object is a JSONArray
    //Each element in the CATALOG array is JSONObject with a single member named "CD"
    //The CD Object is a JSONObject with keys: id, title, artist, country, company, price, and year
    //along with their corresponding atomic values represented as strings.
    public void importData(String jsonFileName)
        throws org.json.JSONException, IOException
    {
        AssetManager manager = baseContext.getAssets();
        InputStream input = manager.open(jsonFileName);
        Reader reader = new InputStreamReader(input);

        JSONObject rootObject = new JSONObject(makeString(reader));
        JSONArray cdArr = null;
        try {
            cdArr = rootObject.getJSONArray("CATALOG");
            for (int i = 0; i < cdArr.length(); ++i) {
                JSONObject elemObj = cdArr.getJSONObject(i);
                JSONObject cdObj = elemObj.getJSONObject("CD");
                CD cd = new CD(cdObj);
                cdDAO.addCD(cd);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private static final String DB_FILE_NAME = "cd_catalog.json";
}
 */
package edu.byu.cs.superasteroids.DataAccessPackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.LevelAsteroidsDef;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.LevelDefinition;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.AsteroidDefinition;

/**
 * Accesses the table that contains asteroid info for each level
 * Created by jntrcs on 2/9/16.
 */
public class LevelAsteroidsAO {

    private SQLiteDatabase db;

    public LevelAsteroidsAO(SQLiteDatabase d) {
        db = d;
    }

    /**
     * Inserts into table
     *
     * @param l takes a level defintion object
     * @return true if successful
     */
    public boolean insert(LevelAsteroidsDef l) {
        if (l == null)
            return false;
        ContentValues values = new ContentValues();
        values.put(Database.LevelAsteroids.Cols.col1, l.getAsteroidType());
        values.put(Database.LevelAsteroids.Cols.col2, l.getAmount());
        values.put(Database.LevelAsteroids.Cols.col3, l.getLevel());
        if (db.insert(Database.LevelAsteroids.name, null, values) > -1)
            return true;
        return false;
    }

    /**
     * Queries the table for all asteroids in a given level and returns a set of definitions. (max set size 3--Normal, octeroid, growing)
     *
     * @param level
     * @return Set of Asteroids
     */
    public Set<LevelAsteroidsDef> read(int level) {
        Cursor c;
        String query = "select *, from " + Database.LevelAsteroids.name + " , where " + Database.LevelAsteroids.Cols.col3 + " = " + level;
        c = db.rawQuery(query, null);
        Set<LevelAsteroidsDef> all = new HashSet<LevelAsteroidsDef>();
        while (!c.isAfterLast()) {
            all.add(parseCursor(c));

        }
        return all;
    }

    public LevelAsteroidsDef parseCursor(Cursor c)
    {
        int type = c.getInt(c.getColumnIndex(Database.LevelAsteroids.Cols.col1));
        int amount = c.getInt(c.getColumnIndex(Database.LevelAsteroids.Cols.col2));
        int level = c.getInt(c.getColumnIndex(Database.LevelAsteroids.Cols.col2));
        return new LevelAsteroidsDef(type, amount,level);
    }
}

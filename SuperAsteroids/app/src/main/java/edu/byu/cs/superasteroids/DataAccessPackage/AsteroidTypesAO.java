package edu.byu.cs.superasteroids.DataAccessPackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.AsteroidDefinition;

/**
 *Data Access class for Asteroid Types Table
 * Created by jntrcs on 2/5/16.
 */
public class AsteroidTypesAO {

    private SQLiteDatabase db;

    public AsteroidTypesAO(SQLiteDatabase db)
    {
        this.db=db;
    }
    /**
     *Inserts a new asteroid into the table
     * @param def Definition of an asteroid object to be inserted
     */
    public boolean insert(AsteroidDefinition def)
    {
        if (def==null)
            return false;
        ContentValues values = new ContentValues();
        values.put(Database.AsteroidTypeTable.Cols.col1, def.getTypeID());
        values.put(Database.AsteroidTypeTable.Cols.col2, def.getName());
        values.put(Database.AsteroidTypeTable.Cols.col3, def.getPathname());
        values.put(Database.AsteroidTypeTable.Cols.col4, def.getHeight());
        values.put(Database.AsteroidTypeTable.Cols.col5, def.getWidth());
        if (db.insert(Database.AsteroidTypeTable.name, null,values)<0)
            return false;
        return true;

    }

    public AsteroidDefinition parseCursor(Cursor c)
    {
        if (c==null)
            return null;
        c.moveToFirst();
        int typeID = c.getInt(c.getColumnIndex(Database.AsteroidTypeTable.Cols.col1));
        String name = c.getString((c.getColumnIndex((Database.AsteroidTypeTable.Cols.col2))));
        String path = c.getString(c.getColumnIndex(Database.AsteroidTypeTable.Cols.col3));
        int height = c.getInt((c.getColumnIndex(Database.AsteroidTypeTable.Cols.col4)));
        int width=c.getInt(c.getColumnIndex(Database.AsteroidTypeTable.Cols.col5));
        return new AsteroidDefinition(name, path, height, width);
    }

    public AsteroidDefinition read(int typeID)
    {
        String whereclause=Database.AsteroidTypeTable.Cols.col1+ " = "+ typeID;
        Cursor cursor = db.query(Database.AsteroidTypeTable.name, null, whereclause, null, null, null, null);
        return parseCursor(cursor);

    }



}

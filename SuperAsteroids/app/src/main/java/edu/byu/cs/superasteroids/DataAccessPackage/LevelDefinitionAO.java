 package edu.byu.cs.superasteroids.DataAccessPackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.LevelDefinition;

/**
 * Accesses the table with each levels definition
 * Created by jntrcs on 2/9/16.
 */
public class LevelDefinitionAO {

    private SQLiteDatabase db;

    public LevelDefinitionAO(SQLiteDatabase d)
    {
        db=d;
    }

    /**
     * Inserts rows into table
     * @param level
     */

    public boolean insert(LevelDefinition level)
    {
        if (level==null)
            {return false;}
        ContentValues values = new ContentValues();
        values.put(Database.LevelTable.Cols.col1, level.getLevelnumber());
        values.put(Database.LevelTable.Cols.col2, level.getTitle());
        values.put(Database.LevelTable.Cols.col3, level.getHint());
        values.put(Database.LevelTable.Cols.col4, level.getWidth());
        values.put(Database.LevelTable.Cols.col5, level.getHeight());
        values.put(Database.LevelTable.Cols.col6, level.getMusic());
        if (db.insert(Database.LevelTable.name, null, values)>0)
            return true;
        return false;



    }

    /**
     * Returns all associated information in a single row of the table given which level to query
     * @param level
     * @return
     */
    public LevelDefinition read(int level)
    {
        Cursor c;
        String whereclause = "where " +Database.LevelTable.Cols.col1+" = " +level;
        c = db.query(Database.LevelTable.name, null, whereclause, null,null,null,null);
        String Title = c.getString(c.getColumnIndex(Database.LevelTable.Cols.col2));
        String Hint = c.getString(c.getColumnIndex(Database.LevelTable.Cols.col3));
        int width = c.getInt(c.getColumnIndex(Database.LevelTable.Cols.col4));
        int height = c.getInt(c.getColumnIndex(Database.LevelTable.Cols.col5));
        String music = c.getString(c.getColumnIndex(Database.LevelTable.Cols.col6));
        return new LevelDefinition(level, Title,Hint,width,height,music);

    }

}

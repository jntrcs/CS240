package edu.byu.cs.superasteroids.DataAccessPackage;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.BackgroundObjectDefinitions;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.LevelBackgroundDefinitions;

/**
 * Accesses the table containing all background objects
 * Created by jntrcs on 2/8/16.
 */
public class LevelBackgroundAO {

    private SQLiteDatabase db;

    public LevelBackgroundAO(SQLiteDatabase db)
    {
        this.db=db;
    }

    /**
     * Inserts data into table
     * @return true if successful
     */
    public boolean insert(LevelBackgroundDefinitions l)
    {
        if (l==null)
            return false;
        ContentValues values = new ContentValues();
        values.put(Database.LevelBackgroundTable.Cols.col1, l.getLevel());
        values.put(Database.LevelBackgroundTable.Cols.col2, l.getXpos());
        values.put(Database.LevelBackgroundTable.Cols.col3, l.getYpos());
        values.put(Database.LevelBackgroundTable.Cols.col4, l.getBgID());
        values.put(Database.LevelBackgroundTable.Cols.col5, l.getScale());
        if (db.insert(Database.LevelBackgroundTable.name, null, values)>-1)
            return true;
        else
            return false;
    }

    /**
     * Returns a set of all background objects for a given level number
     * @param levelnumber
     * @return
     */
    public Set<LevelBackgroundDefinitions> readTable(int levelnumber)
    {
        Set<LevelBackgroundDefinitions> allobjects = new HashSet<LevelBackgroundDefinitions>();
        String whereclause="where "+ Database.LevelBackgroundTable.Cols.col1+"="+levelnumber;
        Cursor c =db.query(Database.LevelBackgroundTable.name, null, whereclause, null, null, null, null);
        while (!c.isAfterLast())
        {
            allobjects.add(parseCursor(c));
        }
        return allobjects;
    }

    public LevelBackgroundDefinitions parseCursor(Cursor c)
    {
        int level= c.getInt(c.getColumnIndex(Database.LevelBackgroundTable.Cols.col1));
        int xpos = c.getInt(c.getColumnIndex(Database.LevelBackgroundTable.Cols.col2));
        int ypos = c.getInt(c.getColumnIndex(Database.LevelBackgroundTable.Cols.col3));
        int bgID= c.getInt(c.getColumnIndex(Database.LevelBackgroundTable.Cols.col4));
        double scale=c.getDouble(c.getColumnIndex(Database.LevelBackgroundTable.Cols.col5));
        return new LevelBackgroundDefinitions(level,xpos,ypos,bgID,scale);
    }

}

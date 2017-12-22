package edu.byu.cs.superasteroids.DataAccessPackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.EngineDef;
import edu.byu.cs.superasteroids.ModelClasses.Engine;

/**
 * Accesses the Engine Definition Table
 * Created by jntrcs on 2/10/16.
 */
public class EngineAO {
    private SQLiteDatabase db;


    public EngineAO(SQLiteDatabase d)
    {
        db=d;
    }

    /**
     * Inserts an engine definition
     * @param eng
     * @return
     */
    public boolean insert(EngineDef eng)
    {
        if (eng==null)
            return false;
        ContentValues v=new ContentValues();
        v.put(Database.Engines.Cols.col1, eng.getAttachpointx());
        v.put(Database.Engines.Cols.col2, eng.getAttachpointy());
        v.put(Database.Engines.Cols.col3, eng.getPathname());
        v.put(Database.Engines.Cols.col4, eng.getWidth());
        v.put(Database.Engines.Cols.col5, eng.getHeight());
        v.put(Database.Engines.Cols.col6, eng.getSpeed());
        v.put(Database.Engines.Cols.col7, eng.getTurnrate());
        if (db.insert(Database.Engines.name, null, v)>-1)
            return true;
        return false;
    }

    /**
     * Fetches all engine Def
     * @return
     */
    public EngineDef parseCursor(Cursor c)
    {
        int attachx = c.getInt(c.getColumnIndex(Database.Engines.Cols.col1));
        int attachy = c.getInt(c.getColumnIndex(Database.Engines.Cols.col2));
        String image =  c.getString(c.getColumnIndex(Database.Engines.Cols.col3));
        int iw = c.getInt(c.getColumnIndex(Database.Engines.Cols.col4));
        int ih = c.getInt(c.getColumnIndex(Database.Engines.Cols.col5));
        int speed = c.getInt(c.getColumnIndex(Database.Engines.Cols.col6));
        int turn = c.getInt(c.getColumnIndex(Database.Engines.Cols.col7));
        return new EngineDef(attachx,attachy,image,iw,ih, speed, turn);
    }
    /**
     * retrieves extra parts
     * @return
     */
    public Set<EngineDef> read()
    {
        Set<EngineDef> all = new HashSet<EngineDef>();
        Cursor c;
        String query = "select *, from "+Database.Engines.name+";";
        c= db.rawQuery(query,null);
        while (!c.isAfterLast())
        {
            all.add(parseCursor(c));
        }
        return all;
    }

}

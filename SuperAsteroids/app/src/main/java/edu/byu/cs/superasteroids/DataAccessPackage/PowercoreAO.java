package edu.byu.cs.superasteroids.DataAccessPackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.PowercoreDef;

/**
 * Accesses the powercore definition table
 * Created by jntrcs on 2/10/16.
 */
public class PowercoreAO {
    private SQLiteDatabase db;

    public PowercoreAO(SQLiteDatabase d)
    {
        db=d;
    }
    /**
     * Inserts specific definition
     * @param pc
     * @return
     */
    public boolean insert(PowercoreDef pc)
    {
        if (pc==null)
            return false;
        ContentValues v = new ContentValues();
        v.put(Database.PowerCores.Cols.col1, pc.getCannonboost());
        v.put(Database.PowerCores.Cols.col2, pc.getEngineboost());
        v.put(Database.PowerCores.Cols.col3, pc.getPathname());
        if (db.insert(Database.PowerCores.name, null, v)>-1)
            return true;
        return false;
    }

    /**
     * Returns definition of PowerCores
     */
    public PowercoreDef parseCursor(Cursor c)
    {
        int cb = c.getInt(c.getColumnIndex(Database.PowerCores.Cols.col1));
        int eb = c.getInt(c.getColumnIndex(Database.PowerCores.Cols.col2));
        String image =  c.getString(c.getColumnIndex(Database.PowerCores.Cols.col3));
        return new PowercoreDef(cb,eb,image);
    }
    /**
     * retrieves extra parts
     * @return
     */
    public Set<PowercoreDef> read()
    {
        Set<PowercoreDef> all = new HashSet<PowercoreDef>();
        Cursor c;
        String query = "select *, from "+Database.PowerCores.name+";";
        c= db.rawQuery(query,null);
        while (!c.isAfterLast())
        {
            all.add(parseCursor(c));
        }
        return all;
    }
}

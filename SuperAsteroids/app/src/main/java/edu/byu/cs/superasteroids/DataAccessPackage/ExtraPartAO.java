package edu.byu.cs.superasteroids.DataAccessPackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.ExtraPartDef;
import edu.byu.cs.superasteroids.ModelClasses.ExtraPart;

/**
 * Manages the extra part table
 * Created by jntrcs on 2/10/16.
 */
public class ExtraPartAO {

    private SQLiteDatabase db;

    public ExtraPartAO(SQLiteDatabase d)
    {
        db=d;
    }
    /**
     * Inserts an extra part definition into the table
     * @param ep
     * @return true if successful
     */
    public boolean insert(ExtraPartDef ep) {
        if (ep == null)
            return false;
        ContentValues values = new ContentValues();
        values.put(Database.ExtraParts.Cols.col1, ep.getAttachpointx());
        values.put(Database.ExtraParts.Cols.col2, ep.getAttachpointy());
        values.put(Database.ExtraParts.Cols.col4, ep.getWidth());
        values.put(Database.ExtraParts.Cols.col3, ep.getPathname());
        values.put(Database.ExtraParts.Cols.col5, ep.getHeight());
       if( db.insert(Database.ExtraParts.name, null, values)>-1)
           return true;
        return false;
    }

    public ExtraPartDef parseCursor(Cursor c)
    {
        int attachx = c.getInt(c.getColumnIndex(Database.ExtraParts.Cols.col1));
        int attachy = c.getInt(c.getColumnIndex(Database.ExtraParts.Cols.col2));
        String image =  c.getString(c.getColumnIndex(Database.ExtraParts.Cols.col3));
        int iw = c.getInt(c.getColumnIndex(Database.ExtraParts.Cols.col4));
        int ih = c.getInt(c.getColumnIndex(Database.ExtraParts.Cols.col5));
        return new ExtraPartDef(attachx,attachy,image,iw,ih);
    }
    /**
     * retrieves extra parts
     * @return
     */
    public Set<ExtraPartDef> read()
    {
        Set<ExtraPartDef> all = new HashSet<ExtraPartDef>();
        Cursor c;
        String query = "select *, from "+Database.ExtraParts.name+";";
        c= db.rawQuery(query,null);
        while (!c.isAfterLast())
        {
            all.add(parseCursor(c));
        }
        return all;
    }
}

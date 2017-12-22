package edu.byu.cs.superasteroids.DataAccessPackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.BodyDef;

/**
 * Accesses the table that contains different ship body definitions
 * Created by jntrcs on 2/10/16.
 */
public class ShipBodiesAO {
    private SQLiteDatabase db;

    public ShipBodiesAO(SQLiteDatabase d)
    {
        db=d;
    }

    /**
     *
     * @param bod--a body definition object to insert
     * @return true if successful
     */
    public boolean insert(BodyDef bod)
    {
        if (bod==null)
            return false;
        ContentValues values = new ContentValues();
        values.put(Database.shipBodies.Cols.col1, bod.getCannonAttachx());
        values.put(Database.shipBodies.Cols.col2, bod.getCannonAttachy());
        values.put(Database.shipBodies.Cols.col3, bod.getEngineAttachx());
        values.put(Database.shipBodies.Cols.col4, bod.getEngineAttachy());
        values.put(Database.shipBodies.Cols.col5, bod.getExtraAttachx());
        values.put(Database.shipBodies.Cols.col6, bod.getExtraAttachy());
        values.put(Database.shipBodies.Cols.col7, bod.getPathname());
        values.put(Database.shipBodies.Cols.col8, bod.getWidth());
        values.put(Database.shipBodies.Cols.col9, bod.getHeight());
        if (db.insert(Database.shipBodies.name, null, values)>-1)
            return true;
        return false;
    }

    public BodyDef parseCursor(Cursor c)
    {
        int cx = c.getInt(c.getColumnIndex(Database.shipBodies.Cols.col1));
        int cy = c.getInt(c.getColumnIndex(Database.shipBodies.Cols.col2));
        int ex = c.getInt(c.getColumnIndex(Database.shipBodies.Cols.col3));
        int ey = c.getInt(c.getColumnIndex(Database.shipBodies.Cols.col4));
        int exx = c.getInt(c.getColumnIndex(Database.shipBodies.Cols.col5));
        int exy = c.getInt(c.getColumnIndex(Database.shipBodies.Cols.col6));
        String image = c.getString(c.getColumnIndex(Database.shipBodies.Cols.col7));
        int width = c.getInt(c.getColumnIndex(Database.shipBodies.Cols.col8));
        int height = c.getInt(c.getColumnIndex(Database.shipBodies.Cols.col9));
        return new BodyDef(cx, cy, ex,ey,exx,exy,image,width,height);


    }
    /**
     * Reads all of the table
     */
    public List<BodyDef> read()
    {
        List<BodyDef> all = new ArrayList<>();
        Cursor c = Database.queryAll(Database.shipBodies.name, db);
        while (!c.isAfterLast())
        {
            all.add(parseCursor(c));
        }
        return all;
    }
}

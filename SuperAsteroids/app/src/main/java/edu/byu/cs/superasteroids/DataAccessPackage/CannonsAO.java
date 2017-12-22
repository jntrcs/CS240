package edu.byu.cs.superasteroids.DataAccessPackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.byu.cs.superasteroids.ModelClasses.Cannon;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.CannonDef;

/**
 * Accesses the table with cannon definitions
 * Created by jntrcs on 2/10/16.
 */
public class CannonsAO {

    private SQLiteDatabase db;

    public CannonsAO(SQLiteDatabase d)
    {
        db=d;
    }
    /**
     * inserts a cannon definition into the table
     * @param can a definition of a cannon
     */
    public boolean insert(CannonDef can)
    {
        if (can==null)
            return false;
        ContentValues values = new ContentValues();
        values.put(Database.cannonsTable.Cols.cols1, can.getAttachpointx());
        values.put(Database.cannonsTable.Cols.cols2, can.getAttachpointy());
        values.put(Database.cannonsTable.Cols.cols3, can.getEmitptx());
        values.put(Database.cannonsTable.Cols.cols4, can.getEmitpty());
        values.put(Database.cannonsTable.Cols.cols5, can.getPathname());
        values.put(Database.cannonsTable.Cols.cols6, can.getWidth());
        values.put(Database.cannonsTable.Cols.cols7, can.getHeight());
        values.put(Database.cannonsTable.Cols.cols8, can.getAttack().getPathname());
        values.put(Database.cannonsTable.Cols.cols9, can.getAttack().getWidth());
        values.put(Database.cannonsTable.Cols.cols10, can.getAttack().getHeight());
        values.put(Database.cannonsTable.Cols.cols11, can.getAttackSound());
        values.put(Database.cannonsTable.Cols.cols12, can.getDamage());
       if( db.insert(Database.cannonsTable.name, null, values)>-1)
           return true;
        return false;

    }

    public CannonDef parseCursor(Cursor c)
    {
        c.moveToFirst();
        int atpx = c.getInt(c.getColumnIndex(Database.cannonsTable.Cols.cols1));
        int atpy = c.getInt(c.getColumnIndex(Database.cannonsTable.Cols.cols2));
        int etpx = c.getInt(c.getColumnIndex(Database.cannonsTable.Cols.cols3));
        int etpy = c.getInt(c.getColumnIndex(Database.cannonsTable.Cols.cols4));
        String image =c.getString(c.getColumnIndex(Database.cannonsTable.Cols.cols5));
        int iw = c.getInt(c.getColumnIndex(Database.cannonsTable.Cols.cols6));
        int ih = c.getInt(c.getColumnIndex(Database.cannonsTable.Cols.cols7));
        String aimage =c.getString(c.getColumnIndex(Database.cannonsTable.Cols.cols8));
        int aiw = c.getInt(c.getColumnIndex(Database.cannonsTable.Cols.cols9));
        int aih = c.getInt(c.getColumnIndex(Database.cannonsTable.Cols.cols10));
        String sound =c.getString(c.getColumnIndex(Database.cannonsTable.Cols.cols11));
        int dam = c.getInt(c.getColumnIndex(Database.cannonsTable.Cols.cols12));

        return new CannonDef(atpx, atpy, etpx, etpy, image, iw, ih ,aimage, aiw, aih, dam, sound);



    }
    /**
     * Fetches  cannon definitions
     * @return
     */
    public List<CannonDef> read() {
        List<CannonDef> all = new ArrayList<>();
        Cursor c = Database.queryAll(Database.cannonsTable.name, db);
        while (!c.isAfterLast())
        {
            all.add(parseCursor(c));
        }
        return all;
    }


}

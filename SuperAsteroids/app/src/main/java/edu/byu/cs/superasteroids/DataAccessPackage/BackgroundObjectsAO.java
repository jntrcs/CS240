package edu.byu.cs.superasteroids.DataAccessPackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.byu.cs.superasteroids.ModelClasses.BackgroundObject;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.BackgroundObjectDefinitions;

/**
 * Accesses the table with Background Image Paths
 * Created by jntrcs on 2/4/16.
 */
public class BackgroundObjectsAO {

    private SQLiteDatabase db;

    public BackgroundObjectsAO(SQLiteDatabase db)
    {
        this.db=db;
    }
    /**
     * Inserts an imagepath into the table
     * @param image the image path name to be inserted.
     * @return true if successful
     */
    public boolean insert(String image)
    {
        if (image==null)
            return false;
        ContentValues values = new ContentValues();
        values.put(Database.BackgroundObjectTable.Cols.col2, image);

        if (db.insert(Database.BackgroundObjectTable.name, null,values)>0) return true;
        else return false;
    }

    public BackgroundObjectDefinitions parseCursor(Cursor c)
    {
        int id = c.getInt(c.getColumnIndex(Database.BackgroundObjectTable.Cols.col1));
        String path = c.getString((c.getColumnIndex((Database.BackgroundObjectTable.Cols.col2))));
        return new BackgroundObjectDefinitions(path, id);
    }

    /**
     * Fetches....all?? image file paths from the table
     * @return string with all the paths??
     */
    public Set<BackgroundObjectDefinitions> read()
    {
        Set<BackgroundObjectDefinitions> allobjects = new HashSet<BackgroundObjectDefinitions>();
        Cursor cursor =db.query(Database.BackgroundObjectTable.name, null, null, null, null, null, null);
        cursor.moveToFirst();
    while (!cursor.isAfterLast())
    {
        allobjects.add(parseCursor(cursor));
        cursor.moveToNext();
    }
        return allobjects;
    }

    /**
     * Fetches image of background object specified with id
     * @param id--ID of image wanted
     * @return imagefilepath
     */
}

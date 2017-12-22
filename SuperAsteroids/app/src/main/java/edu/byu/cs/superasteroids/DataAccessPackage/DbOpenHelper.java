package edu.byu.cs.superasteroids.DataAccessPackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Extends SQLiteOpenHelper to open database for the game
 * Created by jntrcs on 2/9/16.
 */
public class DbOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="asteroids.sqlite";
    private static final int DB_VERSION=1;
    public DbOpenHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * This will have the create table statements for all my tables
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("drop table if exists "+ Database.BackgroundObjectTable.name+";\n");
                db.execSQL("create table " +Database.BackgroundObjectTable.name+"\n" +
                "(\n" +
                Database.BackgroundObjectTable.Cols.col1+ " INTEGER primary key autoincrement,\n" +
                Database.BackgroundObjectTable.Cols.col2+ " varchar(255) not null\n" +
                ");\n");

                db.execSQL("drop table if exists " +Database.AsteroidTypeTable.name+";\n");
                db.execSQL("create table "+ Database.AsteroidTypeTable.name +"\n" +
                "(\n" +
                Database.AsteroidTypeTable.Cols.col1 +" integer primary key not null,\n" +
                Database.AsteroidTypeTable.Cols.col2+" varchar(32) not null,\n" +
                Database.AsteroidTypeTable.Cols.col3+" varchar(255) not null,\n" +
                Database.AsteroidTypeTable.Cols.col4+" int not null,\n" +
                Database.AsteroidTypeTable.Cols.col5 +" int not null\n" +
                ");\n");
                db.execSQL("drop table if exists "+ Database.LevelBackgroundTable.name+";\n");
                db.execSQL("create table "+Database.LevelBackgroundTable.name+"\n" +
                "(\n" + Database.LevelBackgroundTable.Cols.col1+" integer not null,\n" +
                        Database.LevelBackgroundTable.Cols.col2+" int not null,\n" +
                        Database.LevelBackgroundTable.Cols.col3+" int not null,\n" +
                        Database.LevelBackgroundTable.Cols.col4+" int not null, \n" +
                        Database.LevelBackgroundTable.Cols.col5 +" real not null\n"  +
                ");\n");

               db.execSQL( "drop table if exists "+Database.LevelAsteroids.name+";\n");
                db.execSQL("create table "+ Database.LevelAsteroids.name+"\n" +
                "(\n" +
                Database.LevelAsteroids.Cols.col1+" int not null, \n" +
                Database.LevelAsteroids.Cols.col2 +" int not null,\n" +
                Database.LevelAsteroids.Cols.col3+" int not null \n" +
                ");\n");
                db.execSQL("drop table if exists "+Database.LevelTable.name+";\n");
                db.execSQL("create table "+Database.LevelTable.name+"\n" +
                "(\n" +
                        Database.LevelTable.Cols.col1+" integer primary key not null,\n" +
                        Database.LevelTable.Cols.col2+ " varchar(32) not null,\n" +
                        Database.LevelTable.Cols.col3+" varchar(255) not null,\n" +
                        Database.LevelTable.Cols.col4+" int not null,\n" +
                        Database.LevelTable.Cols.col5+" int not null,\n" +
                        Database.LevelTable.Cols.col6+" varchar(255)\n" +
                ");\n" +
                "\n");

                db.execSQL("drop table if exists "+Database.shipBodies.name+";\n");
                db.execSQL("create table "+ Database.shipBodies.name +
                "(\n" +
                Database.shipBodies.Cols.col1 +" int not null,\n" +
                                Database.shipBodies.Cols.col2 +" int not null,\n" +
                                Database.shipBodies.Cols.col3+" int not null,\n"+
                                Database.shipBodies.Cols.col4+" int not null, \n"+
                        Database.shipBodies.Cols.col5+" int not null,\n" +
                        Database.shipBodies.Cols.col6 +" attachy int not null,\n" +
                        Database.shipBodies.Cols.col7 +" varchar(255) not null,\n" +
                        Database.shipBodies.Cols.col8+" int not null, \n" +
                        Database.shipBodies.Cols.col9+" int not null\n" +
                ");\n" );
                db.execSQL("drop table if exists "+ Database.cannonsTable.name);
                db.execSQL("create table "+Database.cannonsTable.name+"\n" +
                "(\n" +
                Database.cannonsTable.Cols.cols1+" int not null,\n" +
                        Database.cannonsTable.Cols.cols2 +" int not null,\n" +
                        Database.cannonsTable.Cols.cols3+" int not null,\n" +
                        Database.cannonsTable.Cols.cols4+" int not null,\n" +
                        Database.cannonsTable.Cols.cols5 +" varchar(255) not null,\n" +
                        Database.cannonsTable.Cols.cols6 +" int not null,\n" +
                        Database.cannonsTable.Cols.cols7 +" int not null,\n" +
                        Database.cannonsTable.Cols.cols8+" varchar(255) not null,\n" +
                        Database.cannonsTable.Cols.cols9 +" int not null,\n" +
                        Database.cannonsTable.Cols.cols10+" int not null,\n" +
                        Database.cannonsTable.Cols.cols11+" varchar(255) not null,\n" +
                        Database.cannonsTable.Cols.cols12+" int not null\n" +
                ");");

               db.execSQL("drop table if exists "+Database.ExtraParts.name+";\n");
                db.execSQL("create table "+Database.ExtraParts.name+"\n" +
                "(\n" +
                        Database.ExtraParts.Cols.col1+" int not null,\n" +
                        Database.ExtraParts.Cols.col2+" int not null,\n" +
                        Database.ExtraParts.Cols.col3+" varchar(255) not null,\n" +
                        Database.ExtraParts.Cols.col4+ " integer not null,\n" +
                        Database.ExtraParts.Cols.col5+" integer not null\n" +
                ");\n");

                db.execSQL("drop table if exists "+Database.Engines.name+";\n");
                db.execSQL("create table "+ Database.Engines.name+"\n" +
                "(\n" +
                Database.Engines.Cols.col1 +" int not null,\n" +
                        Database.Engines.Cols.col2+" int not null,\n" +
                        Database.Engines.Cols.col3 +" varchar(255) not null,\n" +
                        Database.Engines.Cols.col4+" int not null,\n" +
                        Database.Engines.Cols.col5+" int not null,\n" +
                        Database.Engines.Cols.col6+" int not null,\n" +
                        Database.Engines.Cols.col7+" int not null\n" +
                ");\n");

               db.execSQL( "drop table if exists "+ Database.PowerCores.name+";\n");
                db.execSQL("create table "+ Database.PowerCores.name+"\n" +
                "(\n" +
                Database.PowerCores.Cols.col1 +" int not null,\n" +
                Database.PowerCores.Cols.col2+" int not null,\n" +
                Database.PowerCores.Cols.col3+" varchar(255) not null\n" +
                ");");

        //db.execSQL(CREATETABLES);

    }

    /**
     * This will do nothing
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        return;
    }
}


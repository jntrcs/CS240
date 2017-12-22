package edu.byu.cs.superasteroids.core;

import android.test.AndroidTestCase;

import edu.byu.cs.superasteroids.DataAccessPackage.AsteroidTypesAO;
import edu.byu.cs.superasteroids.DataAccessPackage.BackgroundObjectsAO;
import edu.byu.cs.superasteroids.DataAccessPackage.Database;
import edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects.AsteroidDefinition;

/**
 * Created by jntrcs on 2/17/16.
 */
public class ReadTablesTests extends AndroidTestCase {

    public void testAsteroidTable()
    {
        Database db = new Database(getContext());

        AsteroidTypesAO dao =db.getAsttypeDAO();
        assertEquals(1, dao.read(1).getTypeID());
        assertEquals(169, dao.read(1).getWidth());
        assertEquals(153,dao.read(1).getHeight());
    }

    public void testBack()
    {
        Database db = new Database(getContext());

        BackgroundObjectsAO dao = db.getBgObDAO();
        assertEquals(12, dao.read().size());
        //assertEquals("images/planet1.png", dao.read().iterator().next().getPathname());
        assertEquals(5, 6);
    }
}

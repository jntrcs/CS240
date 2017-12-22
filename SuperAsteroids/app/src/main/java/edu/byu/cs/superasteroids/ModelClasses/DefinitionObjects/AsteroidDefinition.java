package edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects;

/**
 * Inherited class that defines all asteroids
 * Created by jntrcs on 2/5/16.
 */
public class AsteroidDefinition extends ImageObject {

  public AsteroidDefinition(String name, String path, int height, int width)
  {
    super(path, height,width);
    this.name=name;
    if (name.equals("regular"))
        typeID=1;
      else if (name.equals("growing"))
        typeID=2;
      else
        typeID=3;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  private String name;
  private int typeID;


}

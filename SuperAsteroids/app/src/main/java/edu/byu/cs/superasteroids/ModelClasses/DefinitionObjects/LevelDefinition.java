package edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects;

/**
 * Defines each level
 * Created by jntrcs on 2/9/16.
 */
public class LevelDefinition {

    private int levelnumber;
    private String title;
    private String hint;
    private int height;
    private int width;
    private String music;

    public LevelDefinition(int n, String t, String h, int w, int height, String m)
    {
        levelnumber=n;
        title=t;
        hint=h;
        width = w;
        this.height=height;
        music = m;
    }

    public int getLevelnumber() {
        return levelnumber;
    }

    public void setLevelnumber(int levelnumber) {
        this.levelnumber = levelnumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }
    //Confused about what should go in here
}

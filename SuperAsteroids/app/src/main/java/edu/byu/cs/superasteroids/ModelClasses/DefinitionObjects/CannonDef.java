package edu.byu.cs.superasteroids.ModelClasses.DefinitionObjects;

/**
 * Defines a cannon
 * Created by jntrcs on 2/10/16.
 */
public class CannonDef extends AttachableDef {

    private int emitptx;
    private int emitpty;
    private ImageObject attack;
    private int damage;
    private String attackSound;

    public int getEmitptx() {
        return emitptx;
    }

    public void setEmitptx(int emitptx) {
        this.emitptx = emitptx;
    }

    public int getEmitpty() {
        return emitpty;
    }

    public void setEmitpty(int emitpty) {
        this.emitpty = emitpty;
    }

    public ImageObject getAttack() {
        return attack;
    }

    public void setAttack(ImageObject attack) {
        this.attack = attack;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public CannonDef(int atx, int aty, int emx, int ety,String image, int iw, int ih, String ai, int aiw, int aih, int dam, String s)
    {
        super(atx,aty,image,iw,ih);
        emitptx=emx;
        emitpty=ety;
        attack=new ImageObject(ai, aiw, aih);
        damage= dam;
        attackSound=s;
    }

    public CannonDef(String attach, String emit, String image, int iw, int ih, String ai, int aiw, int aih, int dam, String s)
    {
        super(parsePos(attach)[0], parsePos(attach)[1], image, iw, ih);
        int[] e = parsePos(emit);
        emitptx=e[0];
        emitpty=e[1];
        attack=new ImageObject(ai, aiw, aih);
        damage=dam;
        attackSound=s;
    }

    public String getAttackSound()
    {
        return attackSound;
    }
}

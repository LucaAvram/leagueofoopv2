package hero;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Hero {
    private char type;
    private int x;
    private int y;
    private int level;
    private int currentXP;
    private int currentHP;
    private int MaxHP;
    private int[] isParalysed; // 0 - yes/no, 1 - damage , 2- time left
    private int isSlammed ; // 0 - yes/no
    private int[] isIgnited ;  // 0 - yes/no , 1 - damage, 2 - time left
    private boolean isDead;


    public Hero(char type,int x,int y) {
        HeroFactory info = HeroFactory.getInstance();
        this.type=type;
        this.x=x;
        this.y=y;
        level=0;
        currentXP=0;
        MaxHP = info.getHeroHP(type);
        currentHP = MaxHP;
        isParalysed = new int[3];
        isSlammed = 0;
        isIgnited = new int[3];
        isDead= false;
    }

    public char getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    public int[] getIsParalysed() {
        return isParalysed;
    }

    public int getIsSlammed() {
        return isSlammed;
    }

    public int[] getIsIgnited() {
        return isIgnited;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setIsParalysed(int[] isParalysed) {
        this.isParalysed = isParalysed;
    }

    public void setIsSlammed(int isSlammed) {
        this.isSlammed = isSlammed;
    }

    public void setIsIgnited(int[] isIgnited) {
        this.isIgnited = isIgnited;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCurrentXP(int currentXP) {
        this.currentXP = currentXP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public void setMaxHP(int maxHP) {
        MaxHP = maxHP;
    }

    public void setDead(boolean isDead){
        this.isDead = isDead;
    }
    public abstract void isAttackedBy(Hero hero, char terrain);
    public abstract void attack(Wizard wizard, char terrain);
    public abstract void attack(Pyromancer pyromancer, char terrain);
    public abstract void attack(Knight knight, char terrain);
    public abstract void attack(Rogue rogue, char terrain);
    public abstract int BaseDamageCalculator(char terrain);
}

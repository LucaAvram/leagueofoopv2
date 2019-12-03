package hero;

public abstract class Hero {
    private static final int IGNITE_PARALYSIS_HELPER = 3;
    private char type;
    private int x;
    private int y;
    private int level;
    private int currentXP;
    private int currentHP;
    private int maxHP;
    private int[] isParalysed; // 0 - yes/no, 1 - damage , 2- time left
    private int isSlammed; // 0 - yes/no
    private int[] isIgnited;  // 0 - yes/no , 1 - damage, 2 - time left
    private boolean isDead;




    public Hero(final char type, final int x, final int y) {
        HeroFactory info = HeroFactory.getInstance();
        this.type = type;
        this.x = x;
        this.y = y;
        level = 0;
        currentXP = 0;
        maxHP = info.getHeroHP(type);
        currentHP = maxHP;
        isParalysed = new int[IGNITE_PARALYSIS_HELPER];
        isSlammed = 0;
        isIgnited = new int[IGNITE_PARALYSIS_HELPER];
        isDead = false;
    }

    public final char getType() {
        return type;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final int getLevel() {
        return level;
    }

    public final int getCurrentXP() {
        return currentXP;
    }

    public final int getCurrentHP() {
        return currentHP;
    }

    public final int getMaxHP() {
        return maxHP;
    }

    public final int[] getIsParalysed() {
        return isParalysed;
    }

    public final int getIsSlammed() {
        return isSlammed;
    }

    public final int[] getIsIgnited() {
        return isIgnited;
    }

    public final boolean isDead() {
        return isDead;
    }

    public final void setIsParalysed(final int[] isParalysed) {
        this.isParalysed = isParalysed;
    }

    public final void setIsSlammed(final int isSlammed) {
        this.isSlammed = isSlammed;
    }

    public final void setIsIgnited(final int[] isIgnited) {
        this.isIgnited = isIgnited;
    }

    public final void setType(final char type) {
        this.type = type;
    }

    public final void setX(final int x) {
        this.x = x;
    }

    public final void setY(final int y) {
        this.y = y;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }

    public final void setCurrentXP(final int currentXP) {
        this.currentXP = currentXP;
    }

    public final void setCurrentHP(final int currentHP) {
        this.currentHP = currentHP;
    }

    public final void setMaxHP(final int maxHP) {
        this.maxHP = maxHP;
    }

    public final void levelUP(final int lvl) {
        HeroFactory info = HeroFactory.getInstance();
        this.setLevel(this.getLevel() + lvl);
            this.setMaxHP(this.getMaxHP() + lvl * info.getHPperLevel(this.getType()));
        this.setCurrentHP(this.getMaxHP());

    }

    public final void setDead(final boolean dead) {
        this.isDead = dead;
    }
    public abstract void isAttackedBy(Hero hero, char terrain);
    public abstract void attack(Wizard wizard, char terrain);
    public abstract void attack(Pyromancer pyromancer, char terrain);
    public abstract void attack(Knight knight, char terrain);
    public abstract void attack(Rogue rogue, char terrain);
    public abstract int baseDamageCalculator(char terrain);
}

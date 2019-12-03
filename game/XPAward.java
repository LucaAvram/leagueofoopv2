package game;

import hero.Hero;

public class XPAward {
    private final int BasicXP = 200;
    private final int BASICMULTIPLIER = 40;
    public final int giveXP(Hero survivor, Hero dead) {
        return Math.max(0, BASICXP - (survivor.getLevel() - dead.getLevel()) * 40);
    }
}

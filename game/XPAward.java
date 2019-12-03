package game;

import hero.Hero;

public class XPAward {
    private final int basicxp = 200;
    private final int basicMultiplier = 40;
    public final int giveXP(final Hero survivor, final Hero dead) {
        return Math.max(0, basicxp - (survivor.getLevel() - dead.getLevel()) * basicMultiplier);
    }
}

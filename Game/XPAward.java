package Game;

import hero.Hero;

public class XPAward {
    public int giveXP(Hero survivor, Hero dead) {
        return Math.max(0, 200 - (survivor.getLevel() - dead.getLevel()) * 40);
    }
}

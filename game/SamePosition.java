package game;

import hero.Hero;

public class SamePosition {
    public final int same(final Hero hero1, final Hero hero2) {
        if (hero1.getX() == hero2.getX() && hero1.getY() == hero2.getY()) {
            return 1;
        } else {
            return 0;
        }
    }
}

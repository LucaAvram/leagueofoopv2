package hero;

import game.XPAward;

public class Wizard extends Hero {
    private static final float DR_BASEPERCENT = 0.2f;
    private static final float DR_PERLVL = 0.05f;
    private static final float DEF_BASE = 0.35f;
    private static final float DEF_PERLEVEL = 0.02f;
    private static final float BASEHP_DEFAULT = 0.3f;
    private static final float IFWIZARD_DR = 1.05f;
    private static final float IFROGUE_DR = 0.8f;
    private static final float IFPYRO_DR = 0.9f;
    private static final float IFKNIGHT_DR = 1.2f;
    private static final float IFROGUE_DEF = 1.2f;
    private static final float IFKNIGHT_DEF = 1.4f;
    private static final float IFPYRO_DEF = 1.3f;
    private static final float TERRAIN_BONUS = 1.1f;
    private static final int XPTOBEAT = 250;
    private static final int XPDIV = 50;
    private int level;

    public Wizard(final char type, final int x, final int y) {
        super(type, x, y);
    }

    public final int drain(final Hero hero, final char terrain) {
        float startingTotalPercent =  DR_BASEPERCENT + DR_PERLVL * this.getLevel();
        float totalPercent = 0;
        if (hero.getType() == 'W') {
            totalPercent = startingTotalPercent * IFWIZARD_DR;
        }
        if (hero.getType() == 'R') {
            totalPercent = startingTotalPercent * IFROGUE_DR;
        }
        if (hero.getType() == 'P') {
            totalPercent = startingTotalPercent * IFPYRO_DR;
        }
        if (hero.getType() == 'K') {
            totalPercent = startingTotalPercent * IFKNIGHT_DR;
        }
        float damage = totalPercent * Math.min(BASEHP_DEFAULT * hero.getMaxHP(),
                hero.getCurrentHP());
        if (terrain == 'D') {
            damage = damage * TERRAIN_BONUS;
        }
        return Math.round(damage);

    }
    public final int deflect(final Hero hero, final char terrain) {
        float totalPercent = DEF_BASE + this.getLevel() * DEF_PERLEVEL;
        float damage = totalPercent * hero.baseDamageCalculator(terrain);

        if (hero.getType() == 'R') {
            damage = damage * IFROGUE_DEF;
        }
        if (hero.getType() == 'P') {
            damage = damage * IFPYRO_DEF;
        }
        if (hero.getType() == 'K') {
            damage = damage * IFKNIGHT_DEF;
        }
        if (terrain == 'D') {
            damage = damage * TERRAIN_BONUS;
        }

        return Math.round(damage);
    }

    public final void isAttackedBy(final Hero hero, final char terrain) {
        hero.attack(this, terrain);
    }

    public final void attack(final Wizard wizard, final char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = drain(wizard, terrain);
        if (damage > wizard.getCurrentHP()) {
            wizard.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, wizard));


        } else {
            wizard.setCurrentHP(wizard.getCurrentHP() - damage);
        }
    }
    public final void attack(final Rogue rogue, final char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = drain(rogue, terrain) + deflect(rogue, terrain);
        if (damage > rogue.getCurrentHP()) {
            rogue.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, rogue));

        } else {
            rogue.setCurrentHP(rogue.getCurrentHP() - damage);
        }
    }
    public final void attack(final Knight knight, final char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = drain(knight, terrain) + deflect(knight, terrain);
        if (damage > knight.getCurrentHP()) {
            knight.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, knight));

        } else {
            knight.setCurrentHP(knight.getCurrentHP() - damage);
        }
    }
    public final void attack(final Pyromancer pyromancer, final char terrain) {
        XPAward xpAward = new XPAward();
        int damage = 0;
        damage = drain(pyromancer, terrain) + deflect(pyromancer, terrain);
        if (damage > pyromancer.getCurrentHP()) {
            pyromancer.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, pyromancer));

        } else {
            pyromancer.setCurrentHP(pyromancer.getCurrentHP() - damage);
        }
    }
    public final int baseDamageCalculator(final char land) {
        return 0;
    }

}

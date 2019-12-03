package hero;

import game.XPAward;

public class Rogue extends Hero {
    private int backStabCounter = 0;
    private static final float BACKSTAB_BASE = 200;
    private static final float BACKSTAB_PERLVL = 20;
    private static final float BS_MULTIPLIER = 1.5f;
    private static final float IFROGUE_BS = 1.2f;
    private static final float IFKNIGHT_BS = 0.9f;
    private static final float IFPYROMANCER_BS = 1.25f;
    private static final float IFWIZARD_BS = 1.25f;
    private static final float PARALYSIS_INSTANT = 40;
    private static final float PARALYSIS_INSTLVL = 10;
    private static final float IFROGUE_PAR = 0.9f;
    private static final float IFKNIGHT_PAR = 0.8f;
    private static final float IFPYROMANCER_PAR = 1.2f;
    private static final float IFWIZARD_PAR = 1.25f;
    private static final float TERRAIN_BONUS = 1.15f;
    private static final int PARSET_LENGTH = 3;
    private static final int ROUNDS_WOODS = 6;
    private static final int ROUNDS_NORMAL = 3;
    private int recentCrit = 0;
    private static final int PARALYSIS_HELPER = 3;
    private static final int BACKSTAB_DIVIDER = 3;
    private static final int XPDIV = 50;
    private int level;
    public Rogue(final char type, final int x, final int y) {
        super(type, x, y);
    }

    public final int backStab(final Hero hero, final char terrain) {
        float startingDamage = BACKSTAB_BASE + BACKSTAB_PERLVL * this.getLevel();
        float finalDamage = 0;
        if (hero.getType() == 'W') {
            finalDamage = startingDamage * IFWIZARD_BS;
        }
        if (hero.getType() == 'K') {
            finalDamage = startingDamage * IFKNIGHT_BS;
        }
        if (hero.getType() == 'R') {
            finalDamage = startingDamage * IFROGUE_BS;
        }
        if (hero.getType() == 'P') {
            finalDamage = startingDamage * IFPYROMANCER_BS;
        }
        if (terrain == 'W') {
            finalDamage = finalDamage * TERRAIN_BONUS;
        }
        if (backStabCounter % BACKSTAB_DIVIDER == 0  && terrain == 'W') {
            finalDamage = finalDamage * BS_MULTIPLIER;
            backStabCounter = 1;
            recentCrit = 1;
            return Math.round(finalDamage);
        }
        recentCrit = 0;
        backStabCounter++;
        return Math.round(finalDamage);
    }
    public final int paralysis(final Hero hero, final char terrain) {
        float startingDamage = PARALYSIS_INSTANT + PARALYSIS_INSTLVL * this.getLevel();
        float finalDamage = 0;

        if (hero.getType() == 'W') {
            finalDamage = startingDamage * IFWIZARD_PAR;
        }
        if (hero.getType() == 'K') {
            finalDamage = startingDamage * IFKNIGHT_PAR;
        }
        if (hero.getType() == 'R') {
            finalDamage = startingDamage * IFROGUE_PAR;
        }
        if (hero.getType() == 'P') {
            finalDamage = startingDamage * IFPYROMANCER_PAR;
        }
        if (terrain == 'W') {
            finalDamage = finalDamage * TERRAIN_BONUS;
        }

        return Math.round(finalDamage);
    }
    public final void isAttackedBy(final Hero hero, final char terrain) {
        hero.attack(this, terrain);
    }
    public final void attack(final Wizard wizard, final char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = backStab(wizard, terrain) + paralysis(wizard, terrain);
        if (damage > wizard.getCurrentHP()) {
            wizard.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, wizard));


            return;
        } else {
            wizard.setCurrentHP(wizard.getCurrentHP() - damage);
        }
        int paralysisDamage = paralysis(wizard, terrain);
        int[] parSet = new int[PARALYSIS_HELPER];
        parSet[0] = 1;
        parSet[1] = paralysisDamage;
        if (terrain == 'W') {
            parSet[2] = ROUNDS_WOODS;
        } else {
            parSet[2] = ROUNDS_NORMAL;
        }
        wizard.setIsParalysed(parSet);

    }
    public final void attack(final Pyromancer pyromancer, final char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = backStab(pyromancer, terrain) + paralysis(pyromancer, terrain);
        if (damage > pyromancer.getCurrentHP()) {
            pyromancer.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, pyromancer));

            return;
        } else {
            pyromancer.setCurrentHP(pyromancer.getCurrentHP() - damage);
        }
        int paralysisDamage = paralysis(pyromancer, terrain);
        int[] parSet = new int[PARALYSIS_HELPER];
        parSet[0] = 1;
        parSet[1] = paralysisDamage;
        if (terrain == 'W') {
            parSet[2] = ROUNDS_WOODS;
        } else {
            parSet[2] = ROUNDS_NORMAL;
        }
        pyromancer.setIsParalysed(parSet);
    }
    public final void attack(final Knight knight, final char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = backStab(knight, terrain) + paralysis(knight, terrain);
        if (damage > knight.getCurrentHP()) {
            knight.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, knight));

            return;
        } else {
            knight.setCurrentHP(knight.getCurrentHP() - damage);
        }
        int paralysisDamage = paralysis(knight, terrain);
        int[] parSet = new int[PARALYSIS_HELPER];
        parSet[0] = 1;
        parSet[1] = paralysisDamage;
        if (terrain == 'W') {
            parSet[2] = ROUNDS_WOODS;
        } else {
            parSet[2] = ROUNDS_NORMAL;
        }
        knight.setIsParalysed(parSet);
    }
    public final void attack(final Rogue rogue, final char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = backStab(rogue, terrain) + paralysis(rogue, terrain);
        if (damage > rogue.getCurrentHP()) {
            rogue.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, rogue));

            return;
        } else {
            rogue.setCurrentHP(rogue.getCurrentHP() - damage);
        }
        int paralysisDamage = paralysis(rogue, terrain);
        int[] parSet = new int[PARALYSIS_HELPER];
        parSet[0] = 1;
        parSet[1] = paralysisDamage;
        if (terrain == 'W') {
            parSet[2] = ROUNDS_WOODS;
        } else {
            parSet[2] = ROUNDS_NORMAL;
        }
        rogue.setIsParalysed(parSet);

    }
    public final int baseDamageCalculator(final char terrain) {
        float baseDamage1 = BACKSTAB_BASE + BACKSTAB_PERLVL * this.getLevel();
        if (recentCrit == 1 && terrain == 'W') {
            baseDamage1 = BS_MULTIPLIER * baseDamage1;
        }
        if (terrain == 'W') {
            baseDamage1 = Math.round(baseDamage1 * TERRAIN_BONUS);
        }
        float baseDamage2 = PARALYSIS_INSTANT + PARALYSIS_INSTLVL * this.getLevel();
        if (terrain == 'W') {
            baseDamage2 = Math.round(baseDamage2 * TERRAIN_BONUS);
        }
        float totalDamage = baseDamage1 + baseDamage2;
        return Math.round(totalDamage);

    }


}

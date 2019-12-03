package hero;

import game.XPAward;

public class Pyromancer extends Hero {
    private static final float FIREBLAST_BASEDAMAGE = 350;
    private static final float FIREBLAST_DMGPERLVL = 50;
    private static final float IGNITE_BASEDAMAGE = 150;
    private static final float IGNITE_DMGPERLEVEL = 20;
    private static final float IGNITE_OVERTIME = 50;
    private static final float IGNITE_OVRPERLVL = 30;
    private static final float IFWIZARD_FB = 1.05f;
    private static final float IFROGUE_FB = 0.8f;
    private static final float IFPYRO_FB = 0.9f;
    private static final float IFKNIGHT_FB = 1.2f;
    private static final float IFWIZARD_IGN = 1.05f;
    private static final float IFROGUE_IGN = 0.8f;
    private static final float IFKNIGHT_IGN = 1.2f;
    private static final float IFPYRO_IGN = 0.9f;
    private static final float TERRAIN_BONUS = 1.25f;
    private static final int IGNITE_ROUNDS = 2;
    private static final int XPTOBEAT = 250;
    private static final int XPDIV = 50;
    private int level;
    private static final int IGNITEDETECTOR = 3;

    public Pyromancer(final char type, final int x, final int y) {
        super(type, x, y);
    }

    public final int fireBlast(final Hero hero, final char terrain) {
        float startingDamage;
        startingDamage = FIREBLAST_BASEDAMAGE + this.getLevel() * FIREBLAST_DMGPERLVL;
        float finalDamage = 0;
        if (hero.getType() == 'W') {
            finalDamage = startingDamage * IFWIZARD_FB;
        }
        if (hero.getType() == 'K') {
            finalDamage = startingDamage * IFKNIGHT_FB;
        }
        if (hero.getType() == 'R') {
            finalDamage = startingDamage * IFROGUE_FB;
        }
        if (hero.getType() == 'P') {
            finalDamage = startingDamage * IFPYRO_FB;
        }
        if (terrain == 'V') {
            finalDamage = finalDamage * TERRAIN_BONUS;
        }

        return Math.round(finalDamage);
    }
    public final int ignite(final Hero hero, final char terrain) {
        float startingDamage;
        startingDamage = IGNITE_BASEDAMAGE + this.getLevel() * IGNITE_DMGPERLEVEL;
        float finalDamage = 0;
        if (hero.getType() == 'W') {
            finalDamage = startingDamage * IFWIZARD_IGN;
        }
        if (hero.getType() == 'K') {
            finalDamage = startingDamage * IFKNIGHT_IGN;
        }
        if (hero.getType() == 'R') {
            finalDamage = startingDamage * IFROGUE_IGN;
        }
        if (hero.getType() == 'P') {
            finalDamage = startingDamage * IFPYRO_IGN;
        }
        if (terrain == 'V') {
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

        damage = fireBlast(wizard, terrain) + ignite(wizard, terrain);
        if (damage >= wizard.getCurrentHP()) {
            wizard.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, wizard));

        } else {
            wizard.setCurrentHP(wizard.getCurrentHP() - damage);
        }
        int igniteDamage = Math.round((IGNITE_OVERTIME + IGNITE_DMGPERLEVEL
                * this.getLevel()) * IFWIZARD_IGN);
        int[] igniteSet = new int[IGNITEDETECTOR];
        igniteSet[0] = 1;
        igniteSet[1] = igniteDamage;
        igniteSet[2] = IGNITE_ROUNDS;
        wizard.setIsIgnited(igniteSet);
    }
    public final void attack(final Rogue rogue, final char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = fireBlast(rogue, terrain) + ignite(rogue, terrain);
        if (damage >= rogue.getCurrentHP()) {
            rogue.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, rogue));

        } else {
            rogue.setCurrentHP(rogue.getCurrentHP() - damage);
        }
        int igniteDamage = Math.round((IGNITE_OVERTIME + IGNITE_DMGPERLEVEL
                * this.getLevel()) * IFROGUE_IGN);

        int[] igniteSet = new int[IGNITEDETECTOR];
        igniteSet[0] = 1;
        igniteSet[1] = igniteDamage;
        igniteSet[2] = IGNITE_ROUNDS;
        rogue.setIsIgnited(igniteSet);
    }
    public final void attack(final Knight knight, final char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = fireBlast(knight, terrain) + ignite(knight, terrain);
        if (damage >= knight.getCurrentHP()) {
            knight.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, knight));

        } else {
            knight.setCurrentHP(knight.getCurrentHP() - damage);
        }
        int igniteDamage = Math.round((IGNITE_OVERTIME + IGNITE_DMGPERLEVEL
                * this.getLevel()) * IFKNIGHT_IGN);
        int[] igniteSet = new int[IGNITEDETECTOR];
        igniteSet[0] = 1;
        igniteSet[1] = igniteDamage;
        igniteSet[2] = IGNITE_ROUNDS;
        knight.setIsIgnited(igniteSet);
    }
    public final void attack(final Pyromancer pyromancer, final char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = fireBlast(pyromancer, terrain) + ignite(pyromancer, terrain);
        if (damage >= pyromancer.getCurrentHP()) {
            pyromancer.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, pyromancer));


        } else {
            pyromancer.setCurrentHP(pyromancer.getCurrentHP() - damage);
        }
        int igniteDamage = Math.round((IGNITE_OVERTIME + IGNITE_DMGPERLEVEL
                * this.getLevel()) * IFPYRO_IGN);
        int[] igniteSet = new int[IGNITEDETECTOR];
        igniteSet[0] = 1;
        igniteSet[1] = igniteDamage;
        igniteSet[2] = IGNITE_ROUNDS;
        pyromancer.setIsIgnited(igniteSet);
    }
    public final int baseDamageCalculator(final char terrain) {
        float baseDamage1 = FIREBLAST_BASEDAMAGE + FIREBLAST_DMGPERLVL * this.getLevel();
        if (terrain == 'V') {
            baseDamage1 = baseDamage1 * TERRAIN_BONUS;
        }
        baseDamage1 = Math.round(baseDamage1);
        float baseDamage2 = IGNITE_BASEDAMAGE + IGNITE_DMGPERLEVEL * this.getLevel();
        if (terrain == 'V') {
            baseDamage2 = baseDamage2 * TERRAIN_BONUS;
        }
        baseDamage2 = Math.round(baseDamage2);
        float totalDamage = baseDamage1 + baseDamage2;

        return Math.round(totalDamage);
    }



}

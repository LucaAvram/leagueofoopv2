package hero;

import game.XPAward;

public class Knight extends Hero {
    private static final float HP_LIMIT = 0.2f;
    private static final float LEVEL_MULTIPIER = 0.01f;
    private static final float EXECUTE_BASEDAMAGE = 200;
    private static final float EXECUTEDMGPERLVL = 30;
    private static final float SLAM_BASEDAMAGE = 100;
    private static final float SLAM_DMGPERLEVEL = 40;
    private static final float IFWIZARD_EXEC = 0.8f;
    private static final float IFROGUE_EXEC = 1.15f;
    private static final float IFPYRO_EXEC = 1.1f;
    private static final float IFKNIGHT_EXEC = 1f;
    private static final float IFWIZARD_SLAM = 1.05f;
    private static final float IFROGUE_SLAM = 0.8f;
    private static final float IFKNIGHT_SLAM = 1.2f;
    private static final float IFPYRO_SLAM = 0.9f;
    private static final float TERRAIN_BONUS = 1.15f;
    private static final float EXECUTE_HELPER = 1.4f;


    public Knight(final char type, final int x, final int y) {
        super(type, x, y);
    }
    public final void isAttackedBy(final Hero hero, final char terrain) {
        hero.attack(this, terrain);
    }
    public final int execute(final Hero hero, final char terrain) {

        float hpLimit = HP_LIMIT + this.getLevel() * LEVEL_MULTIPIER;
        if (hpLimit > EXECUTE_HELPER) {
            hpLimit = EXECUTE_HELPER;
        }
        if (hero.getCurrentHP() < hpLimit) {
            return hero.getCurrentHP();
        }

        float startingDamage = EXECUTE_BASEDAMAGE + this.getLevel() * EXECUTEDMGPERLVL;
        float finalDamage = 0;
        if (hero.getType() == 'W') {
            finalDamage = startingDamage * IFWIZARD_EXEC;
        }
        if (hero.getType() == 'K') {
            finalDamage = startingDamage * IFKNIGHT_EXEC;
        }
        if (hero.getType() == 'R') {
            finalDamage = startingDamage * IFROGUE_EXEC;
        }
        if (hero.getType() == 'P') {
            finalDamage = startingDamage * IFPYRO_EXEC;
        }

        if (terrain == 'L') {
            finalDamage = finalDamage * TERRAIN_BONUS;
        }
        return Math.round(finalDamage);
    }
    public final int slam(final Hero hero, final char terrain) {
        float startingDamage;
        startingDamage = SLAM_BASEDAMAGE + this.getLevel() * SLAM_DMGPERLEVEL;
        float finalDamage = 0;
        if (hero.getType() == 'W') {
            finalDamage = startingDamage * IFWIZARD_SLAM;
        }
        if (hero.getType() == 'K') {
            finalDamage = startingDamage * IFKNIGHT_SLAM;
        }
        if (hero.getType() == 'R') {
            finalDamage = startingDamage * IFROGUE_SLAM;
        }
        if (hero.getType() == 'P') {
            finalDamage = startingDamage * IFPYRO_SLAM;
        }
        if (terrain == 'L') {
            finalDamage = finalDamage * TERRAIN_BONUS;
        }
        return Math.round(finalDamage);
    }

    public final void attack(final Wizard wizard, final char terrain) {
        XPAward xpAward = new XPAward();
        int damage = 0;
        damage = execute(wizard, terrain) + slam(wizard, terrain);
        if (damage >= wizard.getCurrentHP()) {
            wizard.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, wizard));

            return;
        } else {
            wizard.setCurrentHP(wizard.getCurrentHP() - damage);
        }
        wizard.setIsSlammed(1);
    }
    public final void attack(final Rogue rogue, final char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = execute(rogue, terrain) + slam(rogue, terrain);
        if (damage >= rogue.getCurrentHP()) {
            rogue.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, rogue));

            return;
        } else {
            rogue.setCurrentHP(rogue.getCurrentHP() - damage);
        }
        rogue.setIsSlammed(1);
    }
    public final void attack(final Knight knight, final char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = execute(knight, terrain) + slam(knight, terrain);
        if (damage >= knight.getCurrentHP()) {
            knight.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, knight));

            return;
        } else {
            knight.setCurrentHP(knight.getCurrentHP() - damage);
        }
        knight.setIsSlammed(1);
    }
    public final void attack(final Pyromancer pyromancer, final char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = execute(pyromancer, terrain) + slam(pyromancer, terrain);
        if (damage >= pyromancer.getCurrentHP()) {
            pyromancer.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, pyromancer));

            return;
        } else {
            pyromancer.setCurrentHP(pyromancer.getCurrentHP() - damage);
        }
        pyromancer.setIsSlammed(1);
    }
    public final int baseDamageCalculator(final char terrain) {
        float baseDamage1 = EXECUTE_BASEDAMAGE + EXECUTEDMGPERLVL * this.getLevel();
        if (terrain == 'L') {
            baseDamage1 = baseDamage1 * TERRAIN_BONUS;
        }
        baseDamage1 = Math.round(baseDamage1);
        float baseDamage2 = SLAM_BASEDAMAGE + SLAM_DMGPERLEVEL * this.getLevel();
        if (terrain == 'L') {
            baseDamage2 = baseDamage2 * TERRAIN_BONUS;
        }
        baseDamage2 = Math.round(baseDamage2);
        float totalDamage = baseDamage1 + baseDamage2;

        return Math.round(baseDamage1 + baseDamage2);
    }




}

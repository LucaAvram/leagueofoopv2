package hero;

import Game.XPAward;

public class Rogue extends Hero {
    private int BackStabCounter = 0;
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
    private static final int parSet_length = 3;
    private static final int rounds_WOODS = 6;
    private static final int rounds_NORMAl = 3;

    public Rogue(char type, int x, int y) {
        super(type, x, y);
    }

    public int BackStab(Hero hero, char terrain){
        float starting_damage = BACKSTAB_BASE + BACKSTAB_PERLVL * this.getLevel();
        float final_damage = 0;
        if(hero.getType() == 'W'){
            final_damage = starting_damage * IFWIZARD_BS;
        }
        if(hero.getType() == 'K'){
            final_damage = starting_damage * IFKNIGHT_BS;
        }
        if(hero.getType() == 'R'){
            final_damage = starting_damage * IFROGUE_BS;
        }
        if(hero.getType() == 'P'){
            final_damage = starting_damage * IFPYROMANCER_BS;
        }
        if(terrain == 'W'){
            final_damage = final_damage * TERRAIN_BONUS;
        }
        if(BackStabCounter % 3 == 0  && terrain == 'W'){
            final_damage = final_damage * BS_MULTIPLIER;
            BackStabCounter = 1;
            return Math.round(final_damage);
        }
        BackStabCounter++;
        return Math.round(final_damage);
    }
    public int Paralysis(Hero hero, char terrain){
        float starting_damage = PARALYSIS_INSTANT + PARALYSIS_INSTLVL * this.getLevel();
        float final_damage = 0;

        if(hero.getType() == 'W'){
            final_damage = starting_damage * IFWIZARD_PAR;
        }
        if(hero.getType() == 'K'){
            final_damage = starting_damage * IFKNIGHT_PAR;
        }
        if(hero.getType() == 'R'){
            final_damage = starting_damage * IFROGUE_PAR;
        }
        if(hero.getType() == 'P'){
            final_damage = starting_damage * IFPYROMANCER_PAR;
        }
        if(terrain == 'W'){
            final_damage = final_damage * TERRAIN_BONUS;
        }

        return Math.round(final_damage);
    }
    public void isAttackedBy(Hero hero, char terrain) {
        hero.attack(this, terrain);
    }
    @Override
    public void attack(Wizard wizard, char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = BackStab(wizard, terrain) + Paralysis(wizard, terrain);
        if(damage > wizard.getCurrentHP()){
            wizard.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, wizard));

            return;
        }
        else{
            wizard.setCurrentHP(wizard.getCurrentHP() - damage);
        }
        int ParalysisDamage = Paralysis(wizard, terrain);
        int[] parSet = new int[3];
        parSet[0] = 1;
        parSet[1] = ParalysisDamage;
        if(terrain == 'W'){
            parSet[2] = rounds_WOODS;
        }
        else{
            parSet[2] = rounds_NORMAl;
        }
        wizard.setIsParalysed(parSet);

    }

    @Override
    public void attack(Pyromancer pyromancer, char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = BackStab(pyromancer, terrain) + Paralysis(pyromancer, terrain);
        if(damage > pyromancer.getCurrentHP()){
            pyromancer.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, pyromancer));

            return;
        }
        else{
            pyromancer.setCurrentHP(pyromancer.getCurrentHP() - damage);
        }
        int ParalysisDamage = Paralysis(pyromancer, terrain);
        int[] parSet = new int[3];
        parSet[0] = 1;
        parSet[1] = ParalysisDamage;
        if(terrain == 'W'){
            parSet[2] = rounds_WOODS;
        }
        else {
            parSet[2] = rounds_NORMAl;
        }
        pyromancer.setIsParalysed(parSet);
    }

    @Override
    public void attack(Knight knight, char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = BackStab(knight, terrain) + Paralysis(knight, terrain);
        if(damage > knight.getCurrentHP()){
            knight.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, knight));

            return;
        }
        else{
            knight.setCurrentHP(knight.getCurrentHP() - damage);
        }
        int ParalysisDamage = Paralysis(knight, terrain);
        int[] parSet = new int[3];
        parSet[0] = 1;
        parSet[1] = ParalysisDamage;
        if(terrain == 'W'){
            parSet[2] = rounds_WOODS;
        }
        else {
            parSet[2] = rounds_NORMAl;
        }
        knight.setIsParalysed(parSet);
    }

    @Override
    public void attack(Rogue rogue, char terrain) {
        XPAward xpAward = new XPAward();

        int damage = 0;
        damage = BackStab(rogue, terrain) + Paralysis(rogue, terrain);
        if(damage > rogue.getCurrentHP()){
            rogue.setDead(true);
            this.setCurrentXP(this.getCurrentXP() + xpAward.giveXP(this, rogue));

            return;
        }
        else{
            rogue.setCurrentHP(rogue.getCurrentHP() - damage);
        }
        int ParalysisDamage = Paralysis(rogue, terrain);
        int[] parSet = new int[3];
        parSet[0] = 1;
        parSet[1] = ParalysisDamage;
        if(terrain == 'W'){
            parSet[2] = rounds_WOODS;
        }
        else {
            parSet[2] = rounds_NORMAl;
        }
        rogue.setIsParalysed(parSet);

    }

    @Override
    public int BaseDamageCalculator(char terrain) {
        float baseDamage1 = BACKSTAB_BASE + BACKSTAB_PERLVL * this.getLevel();
        if(terrain == 'W') {
            baseDamage1 = baseDamage1 * TERRAIN_BONUS;
        }
        float baseDamage2 = PARALYSIS_INSTANT + PARALYSIS_INSTLVL * this.getLevel();
        if(terrain == 'W') {
            baseDamage2 = baseDamage2 * TERRAIN_BONUS;
        }
        float total_damage = baseDamage1 + baseDamage2;
        return Math.round(total_damage);

    }


}

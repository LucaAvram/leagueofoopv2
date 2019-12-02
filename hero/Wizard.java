package hero;

public class Wizard extends Hero {
    private static final float DR_BASEPERCENT = 1.2f;
    private static final float DR_PERLVL = 1.05f;
    private static final float DEF_BASE = 1.35f;
    private static final float DEF_PERLEVEL = 1.02f;
    private static final float BASEHP_DEFAULT = 0.3f;
    private static final float IFWIZARD_DR = 1.05f;
    private static final float IFROGUE_DR = 0.8f;
    private static final float IFPYRO_DR = 0.9f;
    private static final float IFKNIGHT_DR = 1.2f;
    private static final float IFROGUE_DEF = 1.2f;
    private static final float IFKNIGHT_DEF = 1.4f;
    private static final float IFPYRO_DEF = 1.3f;
    private static final float TERRAIN_BONUS = 1.1f;


    public Wizard(char type, int x, int y) {
        super(type, x, y);
    }

    public int Drain(Hero hero, char terrain){
        float starting_total_percent =  DR_BASEPERCENT + DR_PERLVL * this.getLevel();
        float total_percent = 0;
        if(hero.getType() == 'W'){
            total_percent = starting_total_percent * IFWIZARD_DR;
        }
        if(hero.getType() == 'R'){
            total_percent = starting_total_percent * IFROGUE_DR;
        }
        if(hero.getType() == 'P'){
            total_percent = starting_total_percent * IFPYRO_DR;
        }
        if(hero.getType() == 'K'){
            total_percent = starting_total_percent * IFKNIGHT_DR;
        }
        float damage = total_percent * Math.min(BASEHP_DEFAULT * hero.getMaxHP(),
                hero.getCurrentHP());

        if(terrain == 'D'){
            damage = damage * TERRAIN_BONUS;
        }

        return Math.round(damage);

    }
    public int Deflect(Hero hero, char terrain){
        float total_percent = DEF_BASE + this.getLevel() * DEF_PERLEVEL;
        float damage = total_percent * hero.BaseDamageCalculator(terrain);


        if(hero.getType() == 'R'){
            damage = damage * IFROGUE_DEF;
        }
        if(hero.getType() == 'P'){
            damage = damage * IFPYRO_DEF;
        }
        if(hero.getType() == 'K'){
            damage = damage * IFKNIGHT_DR;
        }
        if(terrain == 'D'){
            damage = damage * TERRAIN_BONUS;
        }

        return Math.round(damage);
    }

    public void isAttackedBy(Hero hero, char terrain) {
        hero.attack(this, terrain);
    }

    public void attack(Wizard wizard, char terrain){
        int damage = 0;
        damage = Drain(wizard, terrain);
        if(damage > wizard.getCurrentHP()){
            wizard.setDead(true);

        }
        else{
            wizard.setCurrentHP(wizard.getCurrentHP() - damage);
        }
    }
    public void attack(Rogue rogue, char terrain){
        int damage = 0;
        damage = Drain(rogue, terrain) + Deflect(rogue, terrain);
        if(damage > rogue.getCurrentHP()){
            rogue.setDead(true);
        }
        else{
            rogue.setCurrentHP(rogue.getCurrentHP() - damage);
        }
    }
    public void attack(Knight knight, char terrain){
        int damage = 0;
        damage = Drain(knight, terrain) + Deflect(knight, terrain);
        if(damage > knight.getCurrentHP()){
            knight.setDead(true);
        }
        else{
            knight.setCurrentHP(knight.getCurrentHP() - damage);
        }
    }
    public void attack(Pyromancer pyromancer, char terrain){
        int damage = 0;
        damage = Drain(pyromancer, terrain) + Deflect(pyromancer, terrain);
        if(damage > pyromancer.getCurrentHP()){
            pyromancer.setDead(true);
        }
        else{
            pyromancer.setCurrentHP(pyromancer.getCurrentHP() - damage);
        }
    }
    public int BaseDamageCalculator(char land){
        return 0;
    }

}

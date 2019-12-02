package hero;

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

    public Pyromancer(char type, int x, int y) {
        super(type, x, y);
    }

    public int FireBlast(Hero hero, char terrain){
        float starting_damage;
        starting_damage = FIREBLAST_BASEDAMAGE + this.getLevel() * FIREBLAST_DMGPERLVL;
        float final_damage = 0;
        if(hero.getType() == 'W'){
            final_damage = starting_damage * IFWIZARD_FB;
        }
        if(hero.getType() == 'K'){
            final_damage = starting_damage * IFKNIGHT_FB;
        }
        if(hero.getType() == 'R'){
            final_damage = starting_damage * IFROGUE_FB;
        }
        if(hero.getType() == 'P'){
            final_damage = starting_damage * IFPYRO_FB;
        }
        if(terrain == 'V'){
            final_damage = final_damage * TERRAIN_BONUS;
        }

        return Math.round(final_damage);
    }
    public int Ignite(Hero hero, char terrain){
        float starting_damage;
        starting_damage = IGNITE_BASEDAMAGE + this.getLevel() * IGNITE_DMGPERLEVEL;
        float final_damage = 0;
        if(hero.getType() == 'W'){
            final_damage = starting_damage * IFWIZARD_IGN;
        }
        if(hero.getType() == 'K'){
            final_damage = starting_damage * IFKNIGHT_IGN;
        }
        if(hero.getType() == 'R'){
            final_damage = starting_damage * IFROGUE_IGN;
        }
        if(hero.getType() == 'P'){
            final_damage = starting_damage * IFPYRO_IGN;
        }
        if(terrain == 'V'){
            final_damage = final_damage * TERRAIN_BONUS;
        }

        return Math.round(final_damage);
    }

    public void isAttackedBy(Hero hero, char terrain) {
        hero.attack(this, terrain);
    }

    public void attack(Wizard wizard, char terrain){
        int damage = 0;
        damage = FireBlast(wizard, terrain) + Ignite(wizard, terrain);
        if(damage >= wizard.getCurrentHP()){
            wizard.setDead(true);
        }
        else{
            wizard.setCurrentHP(wizard.getCurrentHP() - damage);
        }
        int igniteDamage = Math.round((IGNITE_OVERTIME + IGNITE_DMGPERLEVEL * this.getLevel()) * IFWIZARD_IGN);
        int[] igniteSet = new int[3];
        igniteSet[0] = 1;
        igniteSet[1] = igniteDamage;
        igniteSet[2] = IGNITE_ROUNDS;
        wizard.setIsIgnited(igniteSet);
    }
    public void attack(Rogue rogue, char terrain){
        int damage = 0;
        damage = FireBlast(rogue, terrain) + Ignite(rogue, terrain);
        if(damage >= rogue.getCurrentHP()){
            rogue.setDead(true);
        }
        else{
            rogue.setCurrentHP(rogue.getCurrentHP() - damage);
        }
        int igniteDamage = Math.round((IGNITE_OVERTIME + IGNITE_DMGPERLEVEL * this.getLevel()) * IFROGUE_IGN);

        int[] igniteSet = new int[3];
        igniteSet[0] = 1;
        igniteSet[1] = igniteDamage;
        igniteSet[2] = IGNITE_ROUNDS;
        rogue.setIsIgnited(igniteSet);
    }
    public void attack(Knight knight, char terrain){
        int damage = 0;
        damage = FireBlast(knight, terrain) + Ignite(knight, terrain);
        if(damage >= knight.getCurrentHP()){
            knight.setDead(true);
        }
        else{
            knight.setCurrentHP(knight.getCurrentHP() - damage);
        }
        int igniteDamage = Math.round((IGNITE_OVERTIME + IGNITE_DMGPERLEVEL * this.getLevel()) * IFKNIGHT_IGN);
        int[] igniteSet = new int[3];
        igniteSet[0] = 1;
        igniteSet[1] = igniteDamage;
        igniteSet[2] = IGNITE_ROUNDS;
        knight.setIsIgnited(igniteSet);
    }
    public void attack(Pyromancer pyromancer, char terrain){
        int damage = 0;
        damage = FireBlast(pyromancer, terrain) + Ignite(pyromancer, terrain);
        if(damage >= pyromancer.getCurrentHP()){
            pyromancer.setDead(true);
        }
        else{
            pyromancer.setCurrentHP(pyromancer.getCurrentHP() - damage);
        }
        int igniteDamage = Math.round((IGNITE_OVERTIME + IGNITE_DMGPERLEVEL * this.getLevel()) * IFPYRO_IGN);
        int[] igniteSet = new int[3];
        igniteSet[0] = 1;
        igniteSet[1] = igniteDamage;
        igniteSet[2] = IGNITE_ROUNDS;
        pyromancer.setIsIgnited(igniteSet);
    }
    public int BaseDamageCalculator(char terrain){
        float baseDamage1 = FIREBLAST_BASEDAMAGE + FIREBLAST_DMGPERLVL * this.getLevel();
        float baseDamage2 = IGNITE_BASEDAMAGE + IGNITE_DMGPERLEVEL * this.getLevel();
        float total_damage = 0;
        if(terrain == 'V'){
            total_damage = (baseDamage1 + baseDamage2) * TERRAIN_BONUS;
        }
        return Math.round(total_damage);
    }



}

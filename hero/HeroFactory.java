package hero;

public class HeroFactory {
    private static HeroFactory instance = null;


    private static class HeroHP  {


        private static final int KnightHP = 900;
        private static final int PyromancerHP = 500;
        private static final int WizardHP = 400;
        private static final int RogueHP = 600;


        private static final int KnightPERLVL = 80;
        private static final int PyromancerPERLVL = 50;
        private static final int WizardPERLVL = 30;
        private static final int RogurPERLVL = 40;

        public static int getKnightHP() {
            return KnightHP;
        }

        public static int getPyromancerHP() {
            return PyromancerHP;
        }

        public static int getWizardHP() {
            return WizardHP;
        }

        public static int getRogueHP() {
            return RogueHP;
        }

        public static int getKnightPERLVL() {
            return KnightPERLVL;
        }

        public static int getPyromancerPERLVL() {
            return PyromancerPERLVL;
        }

        public static int getWizardPERLVL() {
            return WizardPERLVL;
        }

        public static int getRogurPERLVL() {
            return RogurPERLVL;
        }

    }

    public int getHeroHP(char type){
        int hp=0;
        if(type == 'W'){
            hp = HeroHP.getWizardHP();
        }
        else if(type == 'P'){
            hp=HeroHP.getPyromancerHP();
        }
        else if(type == 'K'){
            hp=HeroHP.getKnightHP();
        }
        else if(type == 'R'){
            hp=HeroHP.getRogueHP();
        }

        return hp;
    }

    public int getHP_perLevel(char type) {
        int hp = 0;
        if (type == 'W') {
            hp = HeroHP.getWizardPERLVL();
        } else if (type == 'P') {
            hp = HeroHP.getPyromancerPERLVL();
        } else if (type == 'K') {
            hp = HeroHP.getKnightPERLVL();
        } else if (type == 'R') {
            hp = HeroHP.getRogurPERLVL();
        }

        return hp;
    }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

}

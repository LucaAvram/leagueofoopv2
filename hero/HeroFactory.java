package hero;

public class HeroFactory {
    private static HeroFactory instance = null;


    private static class HeroHP  {


        private static final int KNIGHT_HP = 900;
        private static final int PYROMANCER_HP = 500;
        private static final int WIZARD_HP = 400;
        private static final int ROGUE_HP = 600;


        private static final int KNIGHT_PERLVL = 80;
        private static final int PYROMANCER_PERLVL = 50;
        private static final int WIZARD_PERLVL = 30;
        private static final int ROGUR_PERLVL = 40;

        public static int getKnightHp() {
            return KNIGHT_HP;
        }

        public static int getPyromancerHp() {
            return PYROMANCER_HP;
        }

        public static int getWizardHp() {
            return WIZARD_HP;
        }

        public static int getRogueHp() {
            return ROGUE_HP;
        }

        public static int getKnightPerlvl() {
            return KNIGHT_PERLVL;
        }

        public static int getPyromancerPerlvl() {
            return PYROMANCER_PERLVL;
        }

        public static int getWizardPerlvl() {
            return WIZARD_PERLVL;
        }

        public static int getRogurPerlvl() {
            return ROGUR_PERLVL;
        }

    }

    public final int getHeroHP(final char type) {
        int hp = 0;
        if (type == 'W') {
            hp = HeroHP.getWizardHp();
        } else if (type == 'P') {
            hp = HeroHP.getPyromancerHp();
        } else if (type == 'K') {
            hp = HeroHP.getKnightHp();
        } else if (type == 'R') {
            hp = HeroHP.getRogueHp();
        }

        return hp;
    }

    public final int getHPperLevel(final char type) {
        int hp = 0;
        if (type == 'W') {
            hp = HeroHP.getWizardPerlvl();
        } else if (type == 'P') {
            hp = HeroHP.getPyromancerPerlvl();
        } else if (type == 'K') {
            hp = HeroHP.getKnightPerlvl();
        } else if (type == 'R') {
            hp = HeroHP.getRogurPerlvl();
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

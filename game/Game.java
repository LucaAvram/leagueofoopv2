package game;

import fileio.FileSystem;
import hero.Hero;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    private static final int XPTOBEAT = 250;
    private static final int XPDIV = 50;
    private int level;
    public final void gameStart(final ArrayList<Hero> heroes, final char[][] map,
                                final ArrayList<String> moves,
                                final int numberOfRounds, final int numberOfHeroes,
                                final String[] args) throws IOException {
        int round;
        int i;
        int j;
        int[] igniteParalysisSetter = {0, 0, 0};
        SamePosition samePosition = new SamePosition();

        for (round = 0; round < numberOfRounds; round++) {
            for (i = 0; i < numberOfHeroes; i++) {
                if (moves.get(round).charAt(i) == 'R' && heroes.get(i).getIsParalysed()[0] != 1
                        && heroes.get(i).getIsSlammed() != 1) {
                    heroes.get(i).setY(heroes.get(i).getY() + 1);
                }
                if (moves.get(round).charAt(i) == 'L' && heroes.get(i).getIsParalysed()[0] != 1
                        && heroes.get(i).getIsSlammed() != 1) {
                    heroes.get(i).setY(heroes.get(i).getY() - 1);
                }
                if (moves.get(round).charAt(i) == 'U' && heroes.get(i).getIsParalysed()[0] != 1
                        && heroes.get(i).getIsSlammed() != 1) {
                    heroes.get(i).setX(heroes.get(i).getX() - 1);
                }
                if (moves.get(round).charAt(i) == 'D' && heroes.get(i).getIsParalysed()[0] != 1
                        && heroes.get(i).getIsSlammed() != 1) {
                    heroes.get(i).setX(heroes.get(i).getX() + 1);
                }
            }
            System.out.println(" ROUND " + round);
            for (i = 0; i < numberOfHeroes; i++) {
                if (heroes.get(i).getIsIgnited()[0] == 1 && heroes.get(i).getIsIgnited()[2] > 0) {
                    if (heroes.get(i).getCurrentHP() - heroes.get(i).getIsIgnited()[1] < 0) {

                        heroes.get(i).setDead(true);

                    } else {
                        System.out.println(heroes.get(i).getCurrentHP());
                        System.out.println(heroes.get(i).getIsIgnited()[1]);
                        heroes.get(i).setCurrentHP(heroes.get(i).getCurrentHP()
                                - heroes.get(i).getIsIgnited()[1]);

                    }
                    heroes.get(i).getIsIgnited()[2]--;
                } else {
                    heroes.get(i).setIsIgnited(igniteParalysisSetter);
                }
                if (heroes.get(i).getIsParalysed()[0] == 1
                        && heroes.get(i).getIsParalysed()[2] > 0) {
                    if (heroes.get(i).getCurrentHP() - heroes.get(i).getIsParalysed()[1] < 0) {
                        heroes.get(i).setDead(true);

                    } else {
                        heroes.get(i).setCurrentHP(heroes.get(i).getCurrentHP()
                                - heroes.get(i).getIsParalysed()[1]);
                    }
                    heroes.get(i).getIsParalysed()[2]--;

                } else {
                    heroes.get(i).setIsIgnited(igniteParalysisSetter);
                }

            }

            for (i = 0; i < numberOfHeroes; i++) {
                if (heroes.get(i).getIsSlammed() == 1) {
                    heroes.get(i).setIsSlammed(0);
                }
            }
            for (i = 0; i < numberOfHeroes - 1; i++) {
                for (j = i +  1; j < numberOfHeroes; j++) {
                    if (samePosition.same(heroes.get(i), heroes.get(j)) == 1) {
                        int x = heroes.get(i).getX();
                        int y = heroes.get(i).getY();
                        if (!heroes.get(i).isDead() && !heroes.get(j).isDead()) {
                            if (heroes.get(i).getType() == 'W') {
                                heroes.get(i).isAttackedBy(heroes.get(j), map[x][y]);
                                heroes.get(j).isAttackedBy(heroes.get(i), map[x][y]);
                            } else if (heroes.get(j).getType() == 'W') {

                                heroes.get(j).isAttackedBy(heroes.get(i), map[x][y]);
                                heroes.get(i).isAttackedBy(heroes.get(j), map[x][y]);

                            } else {
                                heroes.get(i).isAttackedBy(heroes.get(j), map[x][y]);
                                heroes.get(j).isAttackedBy(heroes.get(i), map[x][y]);
                            }
                        }

                        if (heroes.get(i).getCurrentXP() > XPTOBEAT) {
                            level = (heroes.get(i).getCurrentXP() - XPTOBEAT) / XPDIV + 1;
                            heroes.get(i).levelUP(level);
                        }
                        if (heroes.get(j).getCurrentXP() > XPTOBEAT) {
                            level = (heroes.get(j).getCurrentXP() - XPTOBEAT) / XPDIV + 1;
                            heroes.get(j).levelUP(level);
                        }
                    }

                }
            }




            for (i = 0; i < numberOfHeroes; i++) {
                if (heroes.get(i).isDead()) {
                    System.out.println(heroes.get(i).getType() + "dead");
                } else {
                    System.out.println(heroes.get(i).getType() + " "
                            + heroes.get(i).getCurrentHP() + " HATZ ");
                }
            }


        }
        FileSystem fs = new FileSystem(args[0], args[1]);
        for (Hero hero : heroes) {
            if (hero.isDead()) {
                fs.writeCharacter(hero.getType());
                fs.writeWord(" dead");
                fs.writeNewLine();
            } else {
                fs.writeCharacter(hero.getType());
                fs.writeWord(" " + hero.getLevel() + " " + hero.getCurrentXP() + " "
                        + (int) hero.getCurrentHP() + " " + hero.getX() + " " + hero.getY());
                fs.writeNewLine();
            }
        }
        fs.close();
    }
}

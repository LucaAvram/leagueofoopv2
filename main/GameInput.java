package main;

import hero.Hero;

import java.util.ArrayList;


public class GameInput {
    // DO NOT MODIFY
    private int lines;
    private int columns;
    private  char[][] map = new char[lines][columns];
    private  int numberOfHeroes;
    private ArrayList<Hero> heroes;
    private int numberOfRounds;
    private ArrayList<String> moves = new ArrayList<>();

    public GameInput() {
        lines = -1;
        columns = -1;
        map = null;
        numberOfHeroes = -1;
        heroes = null;
        numberOfRounds = -1;
        moves = null;

    }

    public GameInput(final int lines, final int columns, final char[][] map,
                     final int numberOfHeroes, final ArrayList<Hero> heroes,
                     final int numberOfRounds, final ArrayList<String> moves) {
        this.lines = lines;
        this.columns = columns;
        this.map = map;
        this.numberOfHeroes = numberOfHeroes;
        this.heroes = heroes;
        this.numberOfRounds = numberOfRounds;
        this.moves = moves;
    }

    public final int getLines() {
        return lines;
    }

    public final int getColumns() {
        return columns;
    }

    public final char[][] getMap() {
        return map;
    }

    public final int getNumberOfHeroes() {
        return numberOfHeroes;
    }

    public final ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public final int getNumberOfRounds() {
        return numberOfRounds;
    }

    public final ArrayList<String> getMoves() {
        return moves;
    }
}

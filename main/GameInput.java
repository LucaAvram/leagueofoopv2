package main;

import hero.Hero;

import java.util.ArrayList;
import java.util.List;

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

    public GameInput(int lines, int columns, char[][] map, int numberOfHeroes, ArrayList<Hero> heroes,
                                    int numberOfRounds,ArrayList<String> moves) {
        this.lines = lines;
        this.columns = columns;
        this.map = map;
        this.numberOfHeroes = numberOfHeroes;
        this.heroes = heroes;
        this.numberOfRounds = numberOfRounds;
        this.moves=moves;
    }

    public int getLines() {
        return lines;
    }

    public int getColumns() {
        return columns;
    }

    public char[][] getMap() {
        return map;
    }

    public int getNumberOfHeroes() {
        return numberOfHeroes;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }
}

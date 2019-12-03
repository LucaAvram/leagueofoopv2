package main;

import game.Game;
import hero.*;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0],args[1]);
        GameInput gameInput = gameInputLoader.load();
        ArrayList<Hero> heroes = new ArrayList<>();



        Game game = new Game();
        game.gameStart(gameInput.getHeroes(),gameInput.getMap(),gameInput.getMoves(),gameInput.getNumberOfRounds(),
                gameInput.getNumberOfHeroes(), args);




    }
}

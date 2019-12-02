package main;

import Game.Game;
import hero.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0],args[1]);
        GameInput gameInput = gameInputLoader.load();
        ArrayList<Hero> heroes = new ArrayList<>();



        Game game = new Game();
        game.GameStart(gameInput.getHeroes(),gameInput.getMap(),gameInput.getMoves(),gameInput.getNumberOfRounds(),
                gameInput.getNumberOfHeroes(), args);




    }
}

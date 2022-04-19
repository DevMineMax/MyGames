package net.mm.pong.main;

import net.mm.pong.game.Game;

public class Main {

    public static void main(String[] args){

        Game game = new Game();
        Thread mainThread = new Thread(game);
        mainThread.start();

    }

}

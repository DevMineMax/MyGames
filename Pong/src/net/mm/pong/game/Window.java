package net.mm.pong.game;

import net.mm.pong.util.Cons;

import javax.swing.*;
import java.awt.event.KeyListener;

public class Window extends JFrame {

    public Window (Game game){
        setSize(Cons.SCREEN_WIDTH, Cons.SCREEN_HEIGHT);
        setTitle(Cons.SCREEN_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        addKeyListener(Game.keyListener);
        setLocationRelativeTo(null);
        add(game);
    }



}

package net.mm.pong.game;

import net.mm.pong.util.Cons;
import net.mm.pong.util.Time;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game extends JPanel implements Runnable{

    private boolean isRunning = true;
    private Window window = null;

    public static KeyHandler keyListener;

    private Image doubleBufferImage = null;
    private Graphics doubleBufferGraphics = null;

    List<Integer> d = new ArrayList<>();

    public static Player player;
    public static Enemy enemy;
    public static Ball ball;
    private double time;
    public static int playerScore;
    public static int enemyScore;

    public static Vector2 midPos;
    public static Vector2 ballStartPos;

    public Game(){
        init();
    }

    DecimalFormat f = new DecimalFormat("#0.00");
    public void init(){
        midPos = new Vector2(475, 333);
        ballStartPos = midPos;

        keyListener = new KeyHandler();
        window = new Window(this);
        player = new Player(new Vector2(20,100), new Vector2(25, 125), Color.white);
        enemy = new Enemy(new Vector2(950 - 20,500), new Vector2(25, 125), Color.white);
        ball = new Ball(ballStartPos, new Vector2(15, 15), Color.RED);
    }

    public void update(double deltaTime){
        render(getGraphics());
        player.update(deltaTime);
        ball.update(deltaTime);
        enemy.update(deltaTime);
    }

    public static void onScore(){
        ball.pos = Game.ballStartPos;
    }

    public void render(Graphics g){
        if(doubleBufferImage == null){
            doubleBufferImage = createImage(Cons.SCREEN_WIDTH, Cons.SCREEN_HEIGHT);
            doubleBufferGraphics = doubleBufferImage.getGraphics();
        }
        g.drawImage(doubleBufferImage, 0, 0, null);
        renderOffScreen(doubleBufferGraphics);
    }

    public void renderOffScreen(Graphics g){
        Graphics2D g2 = (Graphics2D) g;


        g2.setColor(Color.black);
        g2.fillRect(0,0, getWidth(), getHeight());

        player.render(g2);
        enemy.render(g2);
        for(int i = 0; i < 20; i++){
            g.fillRect((int)475, 0 + i * 100, 20, 60);
        }
        ball.render(g2);

        Font font = new Font("", 1, 64);
        g2.setFont(font);

        g2.setColor(Color.white);

        g.drawString("" + playerScore, 475 - 90, 50);
        g.drawString("" + enemyScore, 475+ 80, 50);



        Font font2 = new Font("", 1, 20);
        g2.setFont(font2);
        g.drawString("Time: " + Math.round(Time.getTime()) + "S", 100, 50);
    }


    @Override
    public void run() {
        double lastFrameTime = 0.0;

        while (isRunning){
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;
            update(deltaTime);
        }

    }
}

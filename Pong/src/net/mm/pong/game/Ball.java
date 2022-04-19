package net.mm.pong.game;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Ball {

    public Vector2 pos;

    private Vector2 size;
    private Rect rect;
    private Color color;
    private int dir;
    private Player player;
    private Enemy enemy;
    private float ballSpeed = 750;



    public Ball(Vector2 pos, Vector2 size, Color color){
        this.pos = pos;
        this.size = size;
        this.rect = new Rect((int)pos.x,(int)pos.y,(int)size.x,(int)size.y);
        this.color = color;
        this.player = Game.player;
        this.enemy = Game.enemy;

        dir = 1;
    }

    public void update(double dt){

    switch (dir){
        case 1:
            pos.y+=ballSpeed*dt / 2;
            pos.x+=ballSpeed*dt;

            break;
        case 2:
            pos.y+= ballSpeed*dt / 2;
            pos.x-=ballSpeed*dt;

            break;
        case -1:
            pos.y-=ballSpeed*dt / 2;
            pos.x+=ballSpeed*dt;

            break;
        case -2:
            pos.y-=ballSpeed*dt / 2;
            pos.x-=ballSpeed*dt;
            break;
    }



    //Collision
        if(pos.y <= 0){
            if(dir == -1){
                dir = 1;
            }
            if(dir == -2){
                dir = 2;
            }
        }

        if(pos.y >= 666){
            if(dir == 1){
                dir = -1;
            }
            if(dir == 2){
                dir = -2;
            }
        }

        if(Rect.isColliding(rect, player.rect)){
            if(pos.y > player.rect.midY()){
                dir = 1;
            }else{
                dir = -1;
            }
        }
        if(Rect.isColliding(rect, enemy.rect)){
            if(pos.y > enemy.rect.midY()){
                dir = 2;
            }else{
                dir = -2;
            }
        }

        // Scoring;
        if(pos.x <= 0){
            //Enemy Scores;
            Game.enemyScore++;
            pos = new Vector2(475, 333);
            dir = 1;
            this.rect = new Rect((int)pos.x,(int)pos.y,(int)size.x,(int)size.y);
        }
        if(pos.x >= 970){
            //Player Scores;
            Game.playerScore++;
            pos = new Vector2(475, 333);
            dir = 2;
            this.rect = new Rect((int)pos.x,(int)pos.y,(int)size.x,(int)size.y);
        }
        this.rect = new Rect((int)pos.x,(int)pos.y,(int)size.x,(int)size.y);
    }

    public void render(Graphics2D g2){
        g2.setColor(color);
        g2.fillRect(rect.x, rect.y, rect.width, rect.height);

    }

    private void reset(){

    }



}

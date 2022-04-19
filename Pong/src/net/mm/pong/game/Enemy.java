package net.mm.pong.game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Enemy {
    private Vector2 pos;
    private Vector2 size;
    private Color color;
    private int speed = 500;


    public Rect rect;

    public Enemy(Vector2 pos, Vector2 size, Color color){
        this.pos = pos;
        this.size = size;
        this.rect = new Rect((int)pos.x,(int)pos.y,(int)size.x,(int)size.y);
        this.color = color;
    }


    public void update(double dt){

       // if(Game.ball.pos.x > 575){ // 575
            if(Game.ball.pos.y > pos.y+size.y / 2){
                if(pos.y > 0){
                    pos.y+=speed*dt;
                }else{
                    pos.y+=400*dt;
                }
            } else if(Game.ball.pos.y < pos.y+size.y / 2){
                pos.y-=speed*dt;
            }
      //  }
        this.rect = new Rect((int)pos.x,(int)pos.y,(int)size.x,(int)size.y);
    }

    public void render(Graphics2D g2){
        g2.setColor(color);
        g2.fillRect(rect.x, rect.y, rect.width, rect.height);

    }
}

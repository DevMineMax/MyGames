package net.mm.pong.game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private Vector2 pos;
    private Vector2 size;
    private Color color;

    public Rect rect;

    public Player(Vector2 pos, Vector2 size, Color color){
        this.pos = pos;
        this.size = size;
        this.rect = new Rect((int)pos.x,(int)pos.y,(int)size.x,(int)size.y);
        this.color = color;
    }


    public void update(double dt){

        if(Game.keyListener.isKeyPressed(KeyEvent.VK_UP) && pos.y > 0 + 10){
            pos.y-=400*dt;
            this.rect = new Rect((int)pos.x,(int)pos.y,(int)size.x,(int)size.y);
        }else if(Game.keyListener.isKeyPressed(KeyEvent.VK_DOWN) && pos.y < 560 - 10){
            pos.y+=400*dt;
            this.rect = new Rect((int)pos.x,(int)pos.y,(int)size.x,(int)size.y);
        }


    }

    public void render(Graphics2D g2){
        g2.setColor(color);
        g2.fillRect(rect.x, rect.y, rect.width, rect.height);

    }

}

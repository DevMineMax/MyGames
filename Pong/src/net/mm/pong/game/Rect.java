package net.mm.pong.game;

import java.awt.*;

public class Rect {

    int x, y, width, height;

    public Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int midX(){
        return x + width / 2;
    }
    public int midY(){
        return y + height / 2;
    }

    public static boolean isColliding(Rect a, Rect b){
        Rectangle ra = new Rectangle(a.x,a.y,a.width,a.height);
        Rectangle rb = new Rectangle(b.x,b.y,b.width,b.height);
        return ra.intersects(rb);
    }

}

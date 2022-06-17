package zeldaminiclone;

import java.awt.Rectangle;
import java.awt.Graphics;

public class FireBall extends Rectangle{

    public int dir = 1, speed = 8, frames = 0;
    public static int LADO = 10;

    public FireBall(int x, int y, int dir){
        super(x+16,y+16,LADO,LADO);
        this.dir = dir;
    }

    public void tick(){
        x+=speed*dir;
        frames++;
        if(frames == 60){
            Player.bullets.remove(this);
            Enemy.bullets.remove(this);
            return;
        }
    }

    public void render(Graphics g){
        g.drawImage(SpriteSheet.fireBall, x, y, width, height, null);
    }
    
}

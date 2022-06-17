package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{
	
	public int spd = 4;
	public boolean right,up,down,left;

	public int curAnimation = 0;

	public int curFrames = 0, targetFrames = 15;
	
	public Player(int x, int y) {
		super(x,y,40,40);
	}
	
	public void tick() {

		boolean moved = false;

		if(right && World.isFree(x+spd, y)) {
			x+=spd;
			moved = true;
		}else if(left && World.isFree(x-spd, y)) {
			x-=spd;
			moved = true;
		}

		if(up && World.isFree(x, y-spd)) {
			y-=spd;
			moved = true;
		}else if(down && World.isFree(x, y+spd)) {
			y+=spd;
			moved = true;
		}

		if(moved){
			curFrames++;
			if(curFrames == targetFrames)
			{
				curFrames=0;
				curAnimation++;
				if(curAnimation == SpriteSheet.playerFront.length){
					curAnimation = 0;
				}
			}
		}
	}
	
	
	public void render(Graphics g) {
		g.drawImage(SpriteSheet.playerFront[curAnimation], x, y, 32, 32, null);
	}
}

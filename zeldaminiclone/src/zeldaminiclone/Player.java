package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle{
	
	public static int spd = 4;
	public boolean right,up,down,left;

	public int curAnimation = 0;

	public int curFrames = 0, targetFrames = 15;

	public static List<FireBall> bullets = new ArrayList<FireBall>();

	public boolean shoot = false;

	public int dir = 1;
	
	public Player(int x, int y) {
		super(x,y,40,40);
	}

	public boolean playerMovement(){
		boolean moved = false;

		if(right && World.isFree(x+spd, y)) {
			x+=spd;
			moved = true;
			dir = 1;
		}else if(left && World.isFree(x-spd, y)) {
			x-=spd;
			moved = true;
			dir = -1;
		}

		if(up && World.isFree(x, y-spd)) {
			y-=spd;
			moved = true;
		}else if(down && World.isFree(x, y+spd)) {
			y+=spd;
			moved = true;
		}

		return moved;
	}
	
	public void tick() {

		boolean moved = playerMovement();

		if(shoot){
			shoot = false;
			bullets.add(new FireBall(x, y,dir));
		}

		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).tick();
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

		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).render(g);
		}
	}
}

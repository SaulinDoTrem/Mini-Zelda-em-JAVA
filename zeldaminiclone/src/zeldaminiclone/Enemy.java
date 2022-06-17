package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends Rectangle{
	
	public int spd = 4;

	public int right = 1,up = 0,down = 0,left = 0;

	public int curAnimation = 0;

	public int curFrames = 0, targetFrames = 15;

	public static List<FireBall> bullets = new ArrayList<FireBall>();

	public boolean shoot = false;

	public int dir = 1;
	
	public Enemy(int x, int y) {
		super(x,y,40,40);
	}
	
	public void tick() {

		boolean moved = false;

		if(right == 1 && World.isFree(x + 1, y)){
            x++;
			moved = true;
        }
        

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
		g.drawImage(SpriteSheet.enemyFront[curAnimation], x, y, 32, 32, null);
		//for(int i = 0; i < bullets.size(); i++){
		//	bullets.get(i).render(g);
		//}
	}
}

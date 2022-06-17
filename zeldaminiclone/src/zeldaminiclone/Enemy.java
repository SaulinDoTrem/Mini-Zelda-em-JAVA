package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends Rectangle{
	
	public int spd = Player.spd/2;
	
	Player p = Game.player;

	public int right = 1,up = 0,down = 0,left = 0;

	public int curAnimation = 0;

	public int curFrames = 0, targetFrames = 15;

	public int bulletsCooldown = 5;

	public static List<FireBall> bullets = new ArrayList<FireBall>();

	public boolean shoot = false;

	public int dir = 1;
	
	public Enemy(int x, int y) {
		super(x,y,40,40);
	}

	public void perseguirPlayer(){
		if(x < p.x && World.isFree(x + spd, y)){
			if(new Random().nextInt(100)<50)
				x+=spd;
		}
		else if(x > p.x && World.isFree(x - spd, y)){
			if(new Random().nextInt(100)<50)
				x-=spd;
		}

		if(y < p.y && World.isFree(x, y + spd)){
			if(new Random().nextInt(100)<50)
				y+=spd;
		}
		else if(y > p.y && World.isFree(x, y - spd)){
			if(new Random().nextInt(100)<50)
				y-=spd;	
		}
	}

	public void atiraNoPlayer(){
		if(y == p.y){
			shoot = true;
			if(x < p.x)
				dir = 1;
			else if(x > p.x)
				dir = -1;
		}
	}

	public boolean canShoot(){
		if(bulletsCooldown == 10)
			return true;
		return false;
	}
	
	public void tick() {

		boolean moved = false;

		perseguirPlayer();

		atiraNoPlayer();
		
		if(shoot){
			shoot = false;
			if(canShoot()){
				bullets.add(new FireBall(x, y,dir));
				bulletsCooldown = 0;
			}
			bulletsCooldown++;
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
				if(curAnimation == SpriteSheet.enemyFront.length){
					curAnimation = 0;
				}
			}
		}
	}
	
	
	public void render(Graphics g) {
		g.drawImage(SpriteSheet.enemyFront[curAnimation], x, y, 32, 32, null);
		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).render(g);
		}
	}
}

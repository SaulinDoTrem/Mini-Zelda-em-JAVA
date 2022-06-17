package zeldaminiclone;

import java.awt.Rectangle;
import java.awt.Graphics;

public class Blocks extends Rectangle{

	public static int LADO = 32;

	public Blocks(int x, int y) {
		super(x,y,LADO,LADO);
	}
	
	public void render(Graphics g){
		g.drawImage(SpriteSheet.tileWall, x, y, width,height, null);
	}
}

package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
    
    public static BufferedImage spritesheet;

    public static BufferedImage[] playerFront, enemyFront;
    public static BufferedImage tileWall, fireBall;

    public SpriteSheet() {
        try {
            spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        playerFront = new BufferedImage[2];
        enemyFront = new BufferedImage[2];

        playerFront[0] = getSprite(0, 11, 16, 16);
        playerFront[1] = getSprite(16, 11, 16, 16);

        enemyFront[0] = getSprite(277, 251, 16, 16);
        enemyFront[1] = getSprite(297, 251, 16, 16);
        
        tileWall = SpriteSheet.getSprite(264, 217, 16, 16);
        fireBall = SpriteSheet.getSprite(192,185, 16, 16);
    }

    public static BufferedImage getSprite(int x, int y, int width, int height){
        return spritesheet.getSubimage(x, y, width, height);
    }
}

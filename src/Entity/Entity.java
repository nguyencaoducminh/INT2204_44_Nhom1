package Entity;

import Game.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;
    public BufferedImage start, up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle hitBox;
    public int hitBoxDefaultX, hitBoxDefaultY;
    public boolean collisionOn = false;

    public void update() {}

    public void draw(Graphics2D g2, GamePanel gp) {
        BufferedImage image = null;

        switch (spriteNum) {
            case 1:
                image = start;
                break;
            case 2:
                image = up1;
                break;
            case 3:
                image = up2;
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}

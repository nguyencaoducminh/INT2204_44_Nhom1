package Entity;

import Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Slime extends Entity {

    GamePanel gp;
    int hitBoxWidth = 22;
    int hitBoxWeight = 22;

    public Slime(GamePanel gp, int x, int y, String direction) {
        this.gp = gp;
        hitBox = new Rectangle(5, 12, hitBoxWidth, hitBoxWeight);
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        this.x = x;
        this.y = y;
        this.speed = 2;
        this.direction = direction;

        getSlimeImage();
    }

    public void getSlimeImage() {
        try {
            start = ImageIO.read(getClass().getResourceAsStream("/res/slime/slime_1.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/slime/slime_2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/slime/slime_3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        spriteCounter++;
        if (spriteCounter > 12) {
            switch (spriteNum) {
                case 1:
                    spriteNum = 2;
                    break;
                case 2:
                    spriteNum = 3;
                    break;
                case 3:
                    spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
}

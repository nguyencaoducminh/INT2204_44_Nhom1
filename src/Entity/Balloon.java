package Entity;

import Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Balloon extends Entity {

    GamePanel gp;
    int hotBoxWidth = 16;
    int hitBoxWeight = 16;

    public Balloon(GamePanel gp, int x, int y) {
        this.gp = gp;
        hitBox = new Rectangle(x + 7, y + 5, hotBoxWidth, hitBoxWeight);
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        this.x = x;
        this.y = y;
        this.speed = 2;
        direction = "start";

        getBalloonImage();
    }

    public void getBalloonImage() {
        try {
            start = ImageIO.read(getClass().getResourceAsStream("/res/ballone/balloon_1.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/ballone/balloon_2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/ballone/balloon_3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        //TODO: code bot di chuyen

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
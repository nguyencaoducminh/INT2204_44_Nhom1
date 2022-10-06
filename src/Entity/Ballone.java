package Entity;

import Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Ballone extends Entity {

    GamePanel gp;
    int hotBoxWidth = 16;
    Int hitBoxWeight = 16;

    public Ballone(GamePanel gp, int x, int y) {
        this.gp = gp;
        hitBox = new Rectangle(x + 7, y + 5, hotBoxWidth, hitBoxWeight);
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        this.x = x;
        this.y = y;
        this.speed = 2;
        direction = "start";

        getBalloneImage();
    }

    public void getBalloneImage() {
        try {
            start = ImageIO.read(getClass().getResourceAsStream("/res/ballone/ballone_1.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/ballone/ballone_2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/ballone/ballone_3.png"));
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

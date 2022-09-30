package Entity;

import Game.GamePanel;
import Game.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    int hitBoxWidth = 18;
    int hitBoxHeight = 24;
    public Bomb bomb;
    public boolean haveBomb = true;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        hitBox = new Rectangle(x + 7, y + 4, hitBoxWidth, hitBoxHeight);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        this.x = 32;
        this.y = 32;
        this.speed = 3;
        direction = "start";
    }

    public void getPlayerImage() {
        try {
            start = ImageIO.read(getClass().getResourceAsStream("/res/bomber/bomberman_0.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/bomber/bomberman_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/bomber/bomberman_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/bomber/bomberman_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/bomber/bomberman_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/bomber/bomberman_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/bomber/bomberman_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/bomber/bomberman_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/bomber/bomberman_right_2.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed) {
                direction = "up";
            } else if (keyH.downPressed) {
                direction = "down";
            } else if (keyH.leftPressed) {
                direction = "left";
            } else if (keyH.rightPressed) {
                direction = "right";
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            if (!collisionOn) {
                switch (direction) {
                    case "up": y -= speed; break;
                    case "down": y += speed; break;
                    case "left": x -= speed; break;
                    case "right": x += speed; break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                spriteNum = (spriteNum == 1) ? 2 : 1;
                spriteCounter = 0;
            }
        }

        if (keyH.spacePressed && haveBomb) {
            placeBomb();
            haveBomb = false;
            keyH.spacePressed = false;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "start":
                image = start;
                break;
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                } else if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                } else if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                } else if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

    public void placeBomb() {
        bomb = new Bomb(gp, this);
    }
}

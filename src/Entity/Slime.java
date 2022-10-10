package Entity;

import Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Slime extends Entity {

    GamePanel gp;
    int hitBoxWidth = 26;
    int hitBoxHeight = 16;

    public Slime(GamePanel gp, int x, int y) {
        this.gp = gp;
        hitBox = new Rectangle(3, 13, hitBoxWidth, hitBoxHeight);
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        this.x = x;
        this.y = y;
        this.speed = 1;
        direction = "start";

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

    public void searchPath(int goalCol, int goalRow) {
        int startCol = (x + hitBox.x) / gp.tileSize;
        int startRow = (y + hitBox.y) / gp.tileSize;

        gp.pFinder.setNodes(startCol, startRow, goalCol, goalRow);

        if (gp.pFinder.search()) {
            int nextX = gp.pFinder.pathList.get(0).col * gp.tileSize;
            int nextY = gp.pFinder.pathList.get(0).row * gp.tileSize;

            int botLeftX = x + hitBox.x;
            int botRightX = x + hitBox.x + hitBoxWidth;
            int botTopY = y + hitBox.y;
            int botBottomY = y + hitBox.y + hitBoxHeight;

            if (botTopY > nextY && botLeftX >= nextX && botRightX < nextX + gp.tileSize) {
                direction = "up";
            } else if (botTopY < nextY && botLeftX >= nextX && botRightX < nextX + gp.tileSize) {
                direction = "down";
            } else if (botTopY >= nextY && botBottomY < nextY + gp.tileSize) {
                if (botLeftX > nextX) {
                    direction = "left";
                }
                if (botLeftX < nextX) {
                    direction = "right";
                }
            } else if (botTopY > nextY && botLeftX > nextX) {
                direction = "up";
                collisionOn = false;
                gp.cChecker.checkTile(this);
                if (collisionOn) {
                    direction = "left";
                }
            } else if (botTopY > nextY && botLeftX < nextX) {
                direction = "up";
                collisionOn = false;
                gp.cChecker.checkTile(this);
                if (collisionOn) {
                    direction = "right";
                }
            } else if (botTopY < nextY && botLeftX > nextX) {
                direction = "down";
                collisionOn = false;
                gp.cChecker.checkTile(this);
                if (collisionOn) {
                    direction = "left";
                }
            } else if (botTopY < nextY && botLeftX < nextX) {
                direction = "down";
                collisionOn = false;
                gp.cChecker.checkTile(this);
                if (collisionOn) {
                    direction = "right";
                }
            }
        }
    }

    public void update() {
        int xDistance = Math.abs(x - gp.player.x);
        int yDistance = Math.abs(y - gp.player.y);
        int tileDistance = (xDistance + yDistance) / gp.tileSize;

        if (!onPath && tileDistance < 4) {
            onPath = true;
        }

        if (onPath) {
            int goalCol = (gp.player.x + gp.player.hitBoxWidth) / gp.tileSize;
            int goalRow = (gp.player.y + gp.player.hitBoxHeight) / gp.tileSize;

            searchPath(goalCol, goalRow);
        }

        collisionOn = false;
        gp.cChecker.checkTile(this);

        int objIndex = gp.cChecker.checkObject(this, true);
        if (objIndex != 999) {
            String objectName = gp.obj[objIndex].name;
            if (objectName.equals("Door")) {
                collisionOn = true;
            }
        }

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

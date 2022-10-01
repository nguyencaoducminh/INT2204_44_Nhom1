package Entity;

import Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bomb extends Entity {
    GamePanel gp;
    Player player;
    public Explosion explosion;
    public int bombTimer = 105 + 45;
    public int col;
    public int row;
    public boolean explode = false;

    public Bomb(GamePanel gp, Player player) {
        this.gp = gp;
        this.player = player;

        setDefaultValues();
        getBombImage();
    }

    public void setDefaultValues() {
        int playerX = player.x + 16;
        int playerY = player.y + 16;

        col = playerX / gp.tileSize;
        row = playerY / gp.tileSize;

        x = col * gp.tileSize;
        y = row * gp.tileSize;
    }

    public void getBombImage() {
        try {
            start = ImageIO.read(getClass().getResourceAsStream("/res/bomb/bomb_1.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/bomb/bomb_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        spriteCounter++;
        if (spriteCounter > 10) {
            spriteNum = (spriteNum == 1) ? 2 : 1;
            spriteCounter = 0;
        }

        if (bombTimer < 130) {
            gp.tileM.mapTileNum[col][row] = 3;
        }

        if (explode) {
            int tileNum1 = gp.tileM.mapTileNum[col+1][row];
            int tileNum2 = gp.tileM.mapTileNum[col-1][row];
            int tileNum3 = gp.tileM.mapTileNum[col][row+1];
            int tileNum4 = gp.tileM.mapTileNum[col][row-1];

            if (gp.tileM.tile[tileNum1].breakable) {
                gp.tileM.mapTileNum[col+1][row] = 0;
            }
            if (gp.tileM.tile[tileNum2].breakable) {
                gp.tileM.mapTileNum[col-1][row] = 0;
            }
            if (gp.tileM.tile[tileNum3].breakable) {
                gp.tileM.mapTileNum[col][row+1] = 0;
            }
            if (gp.tileM.tile[tileNum4].breakable) {
                gp.tileM.mapTileNum[col][row-1] = 0;
            }

            gp.tileM.mapTileNum[col][row] = 0;

            explosion = new Explosion(gp, this);
        }

        bombTimer--;
    }

    public void draw(Graphics2D g2) {
        if (bombTimer >= 45) {
            BufferedImage image = null;

            if (spriteNum == 1) {
                image = start;
            } else if (spriteNum == 2) {
                image = up1;
            }

            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        } else {
            explosion.draw(g2);
        }
    }
}

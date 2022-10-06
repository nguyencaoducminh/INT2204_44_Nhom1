package Game;

import Object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class UI {
    GamePanel gp;
    Font arial_32;
    BufferedImage keyImage, heartImage;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_32 = new Font("Arial", Font.PLAIN, 32);

        try {
            keyImage = ImageIO.read(getClass().getResourceAsStream("/res/objects/key.png"));
            heartImage = ImageIO.read(getClass().getResourceAsStream("/res/objects/heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        for (int i = 1; i <= gp.player.life; i++) {
            g2.drawImage(heartImage, i * gp.tileSize + 8, 16 * gp.tileSize + 14, null);
        }

        g2.setFont(arial_32);
        g2.setColor(Color.white);
        g2.drawImage(keyImage, 12 * gp.tileSize + 8, 16 * gp.tileSize + 14, null);
        g2.drawString(" x " + gp.player.hasKey, 13 * gp.tileSize + 3, 17 * gp.tileSize + 14);
    }
}

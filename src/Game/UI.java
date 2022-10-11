package Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class UI {
    GamePanel gp;
    Font arial_32;
    BufferedImage keyImage, heartImage, bootImage, bottomPanel;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_32 = new Font("Arial", Font.PLAIN, 32);

        try {
            keyImage = ImageIO.read(getClass().getResourceAsStream("/res/objects/key.png"));
            heartImage = ImageIO.read(getClass().getResourceAsStream("/res/objects/heart.png"));
            bootImage = ImageIO.read(getClass().getResourceAsStream("/res/objects/boot.png"));
            bottomPanel = ImageIO.read(getClass().getResourceAsStream("/res/objects/bottom_panel.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(bottomPanel, 0, 16 * gp.tileSize, 512, 64, null);

        for (int i = 1; i <= gp.player.life; i++) {
            g2.drawImage(heartImage, i * gp.tileSize + 8, 16 * gp.tileSize + 14, gp.tileSize, gp.tileSize, null);
        }

        if (gp.player.haveBoot) {
            g2.drawImage(bootImage, 7 * gp.tileSize + 20, 16 * gp.tileSize + 14, gp.tileSize, gp.tileSize, null);
        }

        g2.setFont(arial_32);
        g2.setColor(Color.white);
        g2.drawImage(keyImage, 12 * gp.tileSize + 8, 16 * gp.tileSize + 14, gp.tileSize, gp.tileSize, null);
        g2.drawString(" x " + gp.player.hasKey, 13 * gp.tileSize + 3, 17 * gp.tileSize + 14);
    }
}

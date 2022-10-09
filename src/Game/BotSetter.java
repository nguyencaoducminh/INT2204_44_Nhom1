package Game;

import Entity.*;

import java.util.Arrays;

public class BotSetter {
    GamePanel gp;

    public BotSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setBot() {
        switch (gp.level) {
            case 1:
                gp.bot[0] = new Balloon(gp, 7 * gp.tileSize, gp.tileSize, "down");
                gp.bot[1] = new Balloon(gp, 8 * gp.tileSize, 14 * gp.tileSize, "up");
                gp.bot[2] = new Balloon(gp, gp.tileSize, 8 * gp.tileSize, "right");
                gp.bot[3] = new Balloon(gp, 14 * gp.tileSize, 7 * gp.tileSize, "left");
                break;
            case 2:
                gp.bot[0] = new Slime(gp, 6* gp.tileSize,5 * gp.tileSize);
                gp.bot[1] = new Slime(gp, 8* gp.tileSize,7 * gp.tileSize);
                gp.bot[2] = new Slime(gp, 10* gp.tileSize,9 * gp.tileSize);
                break;
        }
    }

    public void clearBotList() {
        Arrays.fill(gp.bot, null);
    }
}

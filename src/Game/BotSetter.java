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
                gp.bot[0] = new Balloon(gp, 14 * gp.tileSize, gp.tileSize);
                break;
        }
    }

    public void clearBotList() {
        Arrays.fill(gp.bot, null);
    }
}
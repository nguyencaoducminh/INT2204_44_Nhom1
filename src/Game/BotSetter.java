package Game;

import Entity.*;

public class BotSetter {
    GamePanel gp;

    public BotSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setBot() {
        switch (gp.level) {
            case 1:
                gp.bot[0] = new Ballone(gp, 14 * gp.tileSize, 1 * gp.tileSize);
                break;
        }
    }

    public void clearBotList() {
        for (Entity entity : gp.bot) {
            entity = null;
        }
    }
}

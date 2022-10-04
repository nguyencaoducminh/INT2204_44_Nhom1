package Game;

import Object.OBJ_Key;
import Object.OBJ_Door;
import Object.OBJ_Stair;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].x = 14 * gp.tileSize;
        gp.obj[0].y = 14 * gp.tileSize;

        gp.obj[1] = new OBJ_Stair();
        gp.obj[1].x = 8 * gp.tileSize;
        gp.obj[1].y = 8 * gp.tileSize;

        gp.obj[2] = new OBJ_Door();
        gp.obj[2].x = 8 * gp.tileSize;
        gp.obj[2].y = 8 * gp.tileSize;
    }
}

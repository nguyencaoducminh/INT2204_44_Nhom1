package Game;

import Entity.Balloon;
import Objects.*;

import java.util.Arrays;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        switch (gp.level) {
            case 1:
                gp.obj[0] = new OBJ_Key();
                gp.obj[0].x = 14 * gp.tileSize;
                gp.obj[0].y = gp.tileSize;

                gp.obj[1] = new OBJ_Stair();
                gp.obj[1].x = 6 * gp.tileSize;
                gp.obj[1].y = 9 * gp.tileSize;

                gp.obj[2] = new OBJ_Door();
                gp.obj[2].x = 6 * gp.tileSize;
                gp.obj[2].y = 9 * gp.tileSize;

                gp.obj[3] = new OBJ_Boot();
                gp.obj[3].x = 6 * gp.tileSize;
                gp.obj[3].y = gp.tileSize;

                gp.obj[4] = new OBJ_Heart();
                gp.obj[4].x = 14 * gp.tileSize;
                gp.obj[4].y = 4 * gp.tileSize;
                break;

            case 2:
                gp.obj[0] = new OBJ_Key();
                gp.obj[0].x = 13 * gp.tileSize;
                gp.obj[0].y = 7 * gp.tileSize;

                gp.obj[1] = new OBJ_Key();
                gp.obj[1].x = 11 * gp.tileSize;
                gp.obj[1].y = 11 * gp.tileSize;

                gp.obj[2] = new OBJ_Door();
                gp.obj[2].x = 3 * gp.tileSize;
                gp.obj[2].y = 6 * gp.tileSize;

                gp.obj[3] = new OBJ_Door();
                gp.obj[3].x = 9 * gp.tileSize;
                gp.obj[3].y = 7 * gp.tileSize;

                gp.obj[4] = new OBJ_Stair();
                gp.obj[4].x = 7 * gp.tileSize;
                gp.obj[4].y = 7 * gp.tileSize;

                gp.obj[5] = new OBJ_Boot();
                gp.obj[5].x = gp.tileSize;
                gp.obj[5].y = 3 * gp.tileSize;

                gp.obj[6] = new OBJ_Heart();
                gp.obj[6].x = 13 * gp.tileSize;
                gp.obj[6].y = 6 * gp.tileSize;

                gp.obj[7] = new OBJ_Heart();
                gp.obj[7].x = 6 * gp.tileSize;
                gp.obj[7].y = 11 * gp.tileSize;
                break;

            case 3:
                gp.obj[0] = new OBJ_Key();
                gp.obj[0].x = 2 * gp.tileSize;
                gp.obj[0].y = 11 * gp.tileSize;

                gp.obj[1] = new OBJ_Key();
                gp.obj[1].x = 4 * gp.tileSize;
                gp.obj[1].y = 14 * gp.tileSize;

                gp.obj[2] = new OBJ_Key();
                gp.obj[2].x = 8 * gp.tileSize;
                gp.obj[2].y = 4 * gp.tileSize;

                gp.obj[3] = new OBJ_Key();
                gp.obj[3].x = 7 * gp.tileSize;
                gp.obj[3].y = gp.tileSize;

                gp.obj[4] = new OBJ_Key();
                gp.obj[4].x = 10 * gp.tileSize;
                gp.obj[4].y = 14 * gp.tileSize;

                gp.obj[5] = new OBJ_Door();
                gp.obj[5].x = 3 * gp.tileSize;
                gp.obj[5].y = 6 * gp.tileSize;

                gp.obj[6] = new OBJ_Door();
                gp.obj[6].x = 6 * gp.tileSize;
                gp.obj[6].y = 2 * gp.tileSize;

                gp.obj[7] = new OBJ_Door();
                gp.obj[7].x = 6 * gp.tileSize;
                gp.obj[7].y = 13 * gp.tileSize;

                gp.obj[8] = new OBJ_Door();
                gp.obj[8].x = 9 * gp.tileSize;
                gp.obj[8].y = 9 * gp.tileSize;

                gp.obj[9] = new OBJ_Door();
                gp.obj[9].x = 12 * gp.tileSize;
                gp.obj[9].y = 2 * gp.tileSize;

                gp.obj[10] = new OBJ_Stair();
                gp.obj[10].x = 13 * gp.tileSize;
                gp.obj[10].y = 14 * gp.tileSize;

                gp.obj[11] = new OBJ_Heart();
                gp.obj[11].x = 2 * gp.tileSize;
                gp.obj[11].y = 3 * gp.tileSize;

                gp.obj[12] = new OBJ_Boot();
                gp.obj[12].x = 8 * gp.tileSize;
                gp.obj[12].y = 2 * gp.tileSize;

                gp.obj[13] = new OBJ_Heart();
                gp.obj[13].x = 11 * gp.tileSize;
                gp.obj[13].y = 14 * gp.tileSize;

                gp.obj[14] = new OBJ_Heart();
                gp.obj[14].x = 8 * gp.tileSize;
                gp.obj[14].y = 7 * gp.tileSize;
                break;
        }
    }

    public void clearObjectList() {
        Arrays.fill(gp.obj, null);
    }
}

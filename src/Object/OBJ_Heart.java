package Object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Heart extends SuperObject {
    public OBJ_Heart() {
        name = "Heart";

        hitBox = new Rectangle(6, 6, 20, 20);
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

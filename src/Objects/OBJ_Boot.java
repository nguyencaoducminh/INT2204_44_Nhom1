package Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Boot extends SuperObject {
    public OBJ_Boot() {
        name = "Boot";

        hitBox = new Rectangle(6, 6, 20, 20);
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/boot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

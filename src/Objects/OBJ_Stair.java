package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Stair extends SuperObject {
    public OBJ_Stair() {
        name = "Stair";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/stair.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package Tile;

import Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenCol];

        getTileImage();
        loadMap("/res/maps/map_1.txt");
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/background.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/brick.png"));
            tile[2].collision = true;
            tile[2].breakable = true;

            tile[3] = new Tile();
            tile[3].collision = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col < gp.maxScreenCol && row < gp.maxScreenCol) {
                String line = br.readLine();
                if (line != null) {
                    while (col < gp.maxScreenCol) {
                        String[] numbers = line.split(" ");

                        int num = Integer.parseInt(numbers[col]);
                        mapTileNum[col][row] = num;

                        col++;
                    }
                    if (col == gp.maxScreenCol) {
                        col = 0;
                        row++;
                    }
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(tile[0].image, 0, 0, 512, 512, null);

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenCol) {
            int tileNum = mapTileNum[col][row];

            if (tileNum != 0 && tileNum != 3) {
                g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            }
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}

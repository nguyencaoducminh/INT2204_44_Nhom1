package Game;

import Entity.Player;
import Tile.TileManager;
import Object.SuperObject;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //Tiles Setting
    final int originalTileSize = 32;
    final int scale = 1;
    public final int tileSize = originalTileSize * scale;

    //Screen Setting
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 18;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    int FPS = 60;

    //Game Component
    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    public TileManager tileM = new TileManager(this);
    public AssetSetter aSetter = new AssetSetter(this);
    Player player = new Player(this, keyH);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public SuperObject[] obj = new SuperObject[15];

    //Game Variables
    public int maxLevel = 3;
    public int level = 1;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() {
        aSetter.setObject();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        player.update();

        if (!player.haveBomb) {
            player.bomb.update();
            if (player.bomb.bombTimer == 30) {
                player.bomb.explode = true;
            } else if (player.bomb.bombTimer < 0) {
                player.haveBomb = true;
            }
        }
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);

        for (SuperObject object : obj) {
            if (object != null) {
                object.draw(g2, this);
            }
        }

        if (!player.haveBomb) {
            player.bomb.draw(g2);
        }

        player.draw(g2);

        g2.dispose();
    }

    public void changeLevel() {
        if (level <= maxLevel) {
            aSetter.clearObjectList();
            setupGame();
            tileM.loadMap("/res/maps/" + level + ".txt");
            player.setDefaultValues();
        } else {
            aSetter.clearObjectList();
            tileM.loadMap("/res/maps/end.txt");
            player.setDefaultValues();
            player.speed = 0;
        }
    }
}

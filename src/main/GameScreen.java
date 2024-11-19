package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel {

    private Random random;
    private BufferedImage img;

    private ArrayList<BufferedImage> sprites = new ArrayList<>();

    private int[] numbers;

    public GameScreen(BufferedImage img) {
        this.img = img;

        loadSprites();

        random = new Random();



    }

    private void loadSprites() {

        for(int y = 0; y < 10; y++){
            for(int x = 0; x < 10; x++){
                sprites.add(img.getSubimage(x *32, y*32, 32, 32));
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

//        g.drawImage(sprites.get(19),0,0,null);

        for (int y = 0; y < 20; y++){
            for (int x = 0; x < 20; x++){

                g.drawImage(sprites.get(getRndInt()), x * 32, y * 32, null);
            }
        }
    }

    private int getRndInt(){
        return random.nextInt(20);
    }

    private Color getRndColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r, g, b);
    }
}

package main;

import inputs.KeyBoardListener;
import inputs.MyMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel {

    private Game game;
    private Dimension size;

    private MyMouseListener myMouseListener;
    private KeyBoardListener keyboardListener;

    public GameScreen(Game game) {
        this.game = game;
        setPanelSize();
    }

    public void initInput(){
        myMouseListener = new MyMouseListener(game);
        keyboardListener = new KeyBoardListener();

        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addKeyListener(keyboardListener);

        requestFocus();
    }

    private void setPanelSize() {
        size = new Dimension(640, 640);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        game.getRender().render(g);
    }
}

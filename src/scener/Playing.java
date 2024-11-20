package scener;

import helpsz.LevelBuilder;
import main.Game;
import managers.TileManager;
import ui.MyButton;

import java.awt.*;

import static main.GameStates.*;

public class Playing extends GameScene implements SceneMethods{

    private int[][] lvl;
    private TileManager tileManager;
    private MyButton bMenu;

    public Playing(Game game) {
        super(game);

        initButtons();
        lvl = LevelBuilder.getLevelData();
        tileManager = new TileManager();
        //The level
        //tileManager
    }

    private void initButtons() {
        bMenu = new MyButton("Menu", 2, 2, 100, 30);

    }

    @Override
    public void render(Graphics g) {

        for (int y = 0; y < lvl.length; y++) {
            for (int x = 0; x < lvl[y].length; x++) {
                int id = lvl[y][x];
                g.drawImage(tileManager.getSprite(id), x*32, y*32, null);
            }
        }

        drawButtons(g);
    }

    private void drawButtons(Graphics g) {
        bMenu.draw(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bMenu.getBounds().contains(x, y))
            SetGameState(MENU);

    }

    @Override
    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMouseOver(true);

    }

    @Override
    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMousePressed(true);

    }

    @Override
    public void mouseReleased(int x, int y) {
        bMenu.resetBooleans();

    }
}

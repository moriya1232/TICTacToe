package GUI;

import Board.Game;
import Tiles.OccupiedTile;
import Tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TilePanel extends JPanel {
    private final Tile tile;
    private final Game game;

    public TilePanel(Tile tile, Game game){
        super(new CardLayout());

        this.tile = tile;
        this.game = game;
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Tile Pressed: " + tile.getTileCoordinate());
                game.executeMove(tile);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public Tile getTile() {
        return tile;
    }

    public void drawTile(){
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createBevelBorder(1));

        //TODO: FIX IT!
        int height = 200;
        int width = 200;
        if (this.tile.isTileOccupied()) {
            ImageIcon imageIcon = this.game.getImageBySign(tile.getSign());
            JLabel jLabel = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
            add(jLabel);
        }
        validate();
        repaint();
    }

}

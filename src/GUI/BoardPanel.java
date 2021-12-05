package GUI;

import Board.Board;
import Tiles.Tile;
import Board.Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardPanel extends JPanel {
    private Board board;
    private ArrayList<TilePanel> tilePanels;
    private Game game;

    public BoardPanel(Game game, Board board) {
        super(new GridLayout(3,3));
        this.game = game;
        this.board = board;
        this.tilePanels = new ArrayList<>();
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode("#8B4726"));
        drawBoard(board);
        validate();
    }

    public Board getBoard() {
        return board;
    }

    public void updateMembers(Board board) {
        this.board = board;
        this.tilePanels = createTilePanels(board);
    }
    private void drawBoard(final Board board) {
        updateMembers(board);
        for (TilePanel tilePanel : this.tilePanels) {
            tilePanel.drawTile();
            add(tilePanel);
        }
        validate();
        repaint();
    }

    private ArrayList<TilePanel> createTilePanels(Board board) {
        ArrayList<TilePanel> tilePanels = new ArrayList<>();
        for (Tile t: board.getTiles()) {
            tilePanels.add(new TilePanel(t, this.game));
        }
        return tilePanels;
    }

    public void drawMove(Board board){
        removeAll();
        drawBoard(board);
        validate();
        repaint();
    }
}

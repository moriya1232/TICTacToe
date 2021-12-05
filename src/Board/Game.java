package Board;

import Board.Board;
import GUI.BoardPanel;
import Players.Player;
import Tiles.OccupiedTile;
import Tiles.Sign;
import Tiles.Tile;
import javax.swing.*;
import java.awt.*;

public class Game {
    private final BoardPanel boardPanel;
    private final Player playerX;
    private final Player playerO;
    private Player playerTurn;
    public boolean gameDone = false;

    public Game(Board board, Player xPlayer, Player oPlayer){
        JFrame jframe = new JFrame("TIC Tac Toe");
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setSize(new Dimension(600,600));
        jframe.setResizable(false);
        this.boardPanel = new BoardPanel(this, board);
        jframe.add(this.boardPanel, BorderLayout.CENTER);
        jframe.setVisible(true);
        this.playerTurn = xPlayer;
        this.playerO = oPlayer;
        this.playerX = xPlayer;
    }

    public Board getBoard(){
        return this.boardPanel.getBoard();
    }

    public void changeTurn(){
        if (this.playerTurn == this.playerX) {
            this.playerTurn = this.playerO;
        } else {
            this.playerTurn = this.playerX;
        }
    }

    public Player getPlayerTurn() {
        return playerTurn;
    }

    public void executeMove(Tile chosenTile) {
        if (chosenTile instanceof OccupiedTile) {
            return;
        }
        if (this.getPlayerTurn() == this.playerX) {
            this.getBoard().makeTileOccupied(chosenTile.getTileCoordinate(),Sign.X);
        } else if (this.getPlayerTurn() == this.playerO) {
            this.getBoard().makeTileOccupied(chosenTile.getTileCoordinate(),Sign.O);
        }
        this.boardPanel.drawMove(this.getBoard());
        Sign signWinner = this.getBoard().checkIfWinner();
        if (signWinner != null) {
            System.out.println("this winner is: " + signWinner.toString());
            this.gameDone = true;
            return;
        }
        changeTurn();


    }

    public ImageIcon getXImage(){
        return new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("resources/icons/ximage.png"));
    }

    public ImageIcon getOImage(){
        return new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("resources/icons/OImage.png"));
    }

    public ImageIcon getImageBySign(Sign sign) {
        if (sign == Sign.O) {
            return getOImage();
        } else if (sign == Sign.X) {
            return getXImage();
        }
        return null;
    }
}

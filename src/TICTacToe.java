import Board.Board;
import Players.HumanPlayer;
import Players.Player;
import Tiles.Sign;
import Board.Game;

public class TICTacToe {


    public static void main(String[] args) {
        Board.Builder builder = new Board.Builder();
        Board board = builder.build();
        Player xPlayer = new HumanPlayer(Sign.X);
        Player oPlayer = new HumanPlayer(Sign.O);
        new Game(board, xPlayer, oPlayer);
    }
}

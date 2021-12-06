import Board.Board;
import Players.ComputerPlayer;
import Players.HumanPlayer;
import Players.Player;
import Tiles.Sign;
import Board.Game;

public class TICTacToe {


    public static void main(String[] args) {
        Board.Builder builder = new Board.Builder();
        Board board = builder.build();
        Player xPlayer = new ComputerPlayer(Sign.X);
        Player oPlayer = new HumanPlayer(Sign.O);
        Game game = new Game(board, xPlayer, oPlayer);

    }
}

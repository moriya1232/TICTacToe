package Players;

import Board.Game;
import Tiles.EmptyTile;
import Tiles.Sign;
import Tiles.Tile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player{
    public ComputerPlayer(Sign sign) {
        super(sign);
    }

    public void makeTurn(Game game){
        List<Tile> emptyTiles = new ArrayList<>();
        for (Tile t: game.getBoard().getTiles()) {
            if (t instanceof EmptyTile) {
               emptyTiles.add(t);
            }
        }
        if (!emptyTiles.isEmpty()) {
            Random random = new Random();
            int randTile = random.nextInt(emptyTiles.size());
            game.executeMove(emptyTiles.get(randTile));
        }
    }
}

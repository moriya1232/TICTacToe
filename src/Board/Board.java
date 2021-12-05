package Board;

import Players.Player;
import Tiles.EmptyTile;
import Tiles.OccupiedTile;
import Tiles.Sign;
import Tiles.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Board {
    private Tile[] tiles;


    public Board() {
        this.tiles = new Tile[9];
        this.tiles[0] = new EmptyTile(0);
        this.tiles[1] = new EmptyTile(1);
        this.tiles[2] = new EmptyTile(2);
        this.tiles[3] = new EmptyTile(3);
        this.tiles[4] = new EmptyTile(4);
        this.tiles[5] = new EmptyTile(5);
        this.tiles[6] = new EmptyTile(6);
        this.tiles[7] = new EmptyTile(7);
        this.tiles[8] = new EmptyTile(8);

    }

    public Tile getTile(int numTile) {
        return this.tiles[numTile];
    }

    public void makeTileOccupied(int numTile, Sign sign) {
        if (getTile(numTile) instanceof EmptyTile) {
            this.tiles[numTile] =  new OccupiedTile(sign, numTile);
        }
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public static class Builder {
        public Builder(){}
        public Board build(){
            return new Board();
        }

    }

}

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

    public Sign checkIfWinner() {
        if(tiles[0].getSign() != null && tiles[0].getSign() == tiles[1].getSign() && tiles[1].getSign() == tiles[2].getSign()) {
            return tiles[0].getSign(); //first row
        } else if(tiles[3].getSign() != null && tiles[3].getSign() == tiles[4].getSign() && tiles[3].getSign() == tiles[5].getSign()) {
            return tiles[3].getSign(); // second row
        } else if(tiles[6].getSign() != null && tiles[6].getSign() == tiles[7].getSign() && tiles[6].getSign() == tiles[8].getSign()) {
            return tiles[6].getSign(); // third row
        }  else if(tiles[0].getSign() != null && tiles[0].getSign() == tiles[3].getSign() && tiles[0].getSign() == tiles[6].getSign()) {
            return tiles[0].getSign(); // first col
        } else if(tiles[1].getSign() != null && tiles[1].getSign() == tiles[4].getSign() && tiles[1].getSign() == tiles[7].getSign()) {
            return tiles[1].getSign(); //second col
        } else if(tiles[2].getSign() != null && tiles[2].getSign() == tiles[5].getSign() && tiles[2].getSign() == tiles[8].getSign()) {
            return tiles[2].getSign(); //third col
        } else if(tiles[0].getSign() != null && tiles[0].getSign() == tiles[4].getSign() && tiles[0].getSign() == tiles[8].getSign()) {
            return tiles[0].getSign(); //slant
        } else if(tiles[2].getSign() != null && tiles[2].getSign() == tiles[4].getSign() && tiles[2].getSign() == tiles[6].getSign()) {
            return tiles[2].getSign(); //slant
        }

        return null;
    }

}

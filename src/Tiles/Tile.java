package Tiles;

public abstract class Tile {
    protected final int tileCoordinate;

    protected Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isTileOccupied();
    public abstract Sign getSign();

    public int getTileCoordinate() {
        return tileCoordinate;
    }
}

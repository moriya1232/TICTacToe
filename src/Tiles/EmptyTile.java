package Tiles;

public class EmptyTile extends Tile{
    public EmptyTile(final int tileCoordinate) {
        super(tileCoordinate);
    }

    @Override
    public boolean isTileOccupied() {
        return false;
    }

    @Override
    public Sign getSign() {
        return null;
    }
}

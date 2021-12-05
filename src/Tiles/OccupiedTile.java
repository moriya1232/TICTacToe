package Tiles;

public class OccupiedTile extends Tile{
    final private Sign sign;

    public OccupiedTile(Sign sign, final int tileCoordinate) {
        super(tileCoordinate);
        this.sign = sign;
    }

    @Override
    public boolean isTileOccupied() {
        return true;
    }

    @Override
    public Sign getSign() {
        return this.sign;
    }
}

package plant.power.powerplantandroid.ViewTile;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import TilePacket.Tile;

/**
 * Created by felip on 24/06/2018.
 */

public class SpaceTile implements Tile {

    private static Paint p;

    static {
        p = new Paint();
        p.setColor(Color.BLACK);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        canvas.drawRect(side,0,0,side,p);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}

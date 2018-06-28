package plant.power.powerplantandroid.ViewTile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import ImgPacket.Img;
import TilePacket.Tile;
import plant.power.powerplantandroid.R;

/**
 * Created by felip on 31/05/2018.
 */

public class PowerTile implements Tile {

    private static Paint p;
    private int position;

    static {
        p = new Paint();
        p.setColor(Color.rgb(122, 122, 82));
    }

    final Img power;

    public PowerTile(int position, Context ctx) {
        this.position = position;
        power = new Img(ctx, R.drawable.power);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        power.draw(canvas, side, side, p);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}

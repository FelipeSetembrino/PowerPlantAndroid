package pt.isel.poo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import pt.isel.leic.poo.jogogalo.R;
import pt.isel.poo.view.tile.Tile;

public class CircleView implements Tile {
    static Paint p;
    static {
        p = new Paint();
    }

    final Img img;

    public CircleView(Context ctx) {
        img = new Img(ctx, R.drawable.circle);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        img.draw(canvas, side, side, p);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}

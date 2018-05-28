package pt.isel.tiledemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import pt.isel.poo.tile.Tile;

public class CircleTile implements Tile {
    private static Paint p;
    static {
        p = new Paint();
        p.setColor(Color.GRAY);
    }
    private int r;

    public CircleTile(int initialRadius) {
        r = initialRadius;
    }
    @Override
    public void draw(Canvas canvas, int side) {
        canvas.drawCircle(
                side/2,side/2,r,
                p
        );
    }
    public void incRadius() {
        r+=10;
    }
    public int getRadius() {
        return r;
    }
    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}

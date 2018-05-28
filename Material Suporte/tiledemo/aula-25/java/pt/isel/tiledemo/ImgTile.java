package pt.isel.tiledemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import pt.isel.poo.tile.Tile;

public class ImgTile implements Tile {
    static private Paint p;
    static {
        p = new Paint();
    }
    private Context ctx;
    private int imgId;
    public ImgTile(Context ctx, int imgId) {
        this.ctx = ctx;
        this.imgId = imgId;
    }

    @Override
    public void draw(Canvas canvas, int side) {
        Bitmap img =
            BitmapFactory.decodeResource(
                ctx.getResources(),
                imgId);
        Rect srcArea = new Rect(
                0, 0, img.getWidth(), img.getHeight());
        Rect destArea = canvas.getClipBounds();
        canvas.drawBitmap(img, srcArea, destArea, p);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}

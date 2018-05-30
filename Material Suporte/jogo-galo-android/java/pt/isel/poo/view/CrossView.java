package pt.isel.poo.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import pt.isel.leic.poo.jogogalo.R;
import pt.isel.poo.view.tile.Tile;

public class CrossView implements Tile {
    static Paint p;
    static {
        p = new Paint();
    }

    //final private Resources res;
    final Img img;

    public CrossView(Context ctx) {
        //res = ctx.getResources();
        img = new Img(ctx, R.drawable.cross);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        /*Bitmap bitmap =
                BitmapFactory.decodeResource(
                   res,
                   R.drawable.cross);
        Rect srcArea = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect destArea = canvas.getClipBounds();
        canvas.drawBitmap(bitmap, srcArea, destArea, p);*/
        img.draw(canvas, side, side, p);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}

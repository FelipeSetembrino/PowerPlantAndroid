package plant.power.powerplantandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import ImgPacket.Img;
import TilePacket.Tile;

/**
 * Created by felip on 30/05/2018.
 */

public class HouseTile implements Tile {

    private static Paint p;
    private int position;

    static {
        p = new Paint();
        p.setColor(Color.rgb(122, 122, 82));
    }

    final Img house_off_img;
    final Img house_on_img;

    public HouseTile(int position, Context ctx){
        this.position = position;
        house_off_img = new Img(ctx, R.drawable.house_off);
        house_on_img = new Img(ctx, R.drawable.house_on);
    }

    @Override
    public void draw(Canvas canvas, int side) {

        switch (position){
            case 0:
                canvas.drawRect(side/3,0,side*2/3,side/3,p);
                //se acontecer algo house_on, se nao, house_off:
                house_off_img.draw(canvas, side, side, p);
                break;
            case 1:
                canvas.drawRect(0,side/3,side/3,side*2/3,p);
                house_off_img.draw(canvas, side, side, p);
                break;
            case 2:
                canvas.drawRect(side/3,side*2/3,side*2/3,side,p);
                house_off_img.draw(canvas, side, side, p);
                break;
            case 3:
                canvas.drawRect(side*2/3,side/3,side,side*2/3,p);
                house_off_img.draw(canvas, side, side, p);
                break;
        }

    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}

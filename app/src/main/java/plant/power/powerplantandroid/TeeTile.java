package plant.power.powerplantandroid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import TilePacket.Tile;

/**
 * Created by felip on 30/05/2018.
 */

public class TeeTile implements Tile {

    private static Paint p;
    private int position;

    static {
        p = new Paint();
        p.setColor(Color.rgb(122, 122, 82));
    }

    public TeeTile(int position){
        this.position = position;
    }

    @Override
    public void draw(Canvas canvas, int side) {

        switch (position){
            case 0:
                canvas.drawRect(side*0, side/3, side, side*2/3, p);
                canvas.drawRect(side/3,0,side*2/3,side/3,p);
                break;
            case 1:
                canvas.drawRect(side*1/3, side*0, side*2/3, side*1, p);
                canvas.drawRect(0,side/3,side/3,side*2/3,p);
                break;
            case 2:
                canvas.drawRect(side*0, side/3, side, side*2/3, p);
                canvas.drawRect(side/3,side*2/3,side*2/3,side,p);
                break;
            case 3:
                canvas.drawRect(side*1/3, side*0, side*2/3, side*1, p);
                canvas.drawRect(side*2/3,side/3,side,side*2/3,p);
        }

    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}

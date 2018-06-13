package plant.power.powerplantandroid.ViewTile;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import TilePacket.Tile;

/**
 * Created by felip on 28/05/2018.
 */

public class LineTile implements Tile {

    private static Paint p;
    private int position;

    static {
        p = new Paint();
        p.setColor(Color.rgb(122, 122, 82));
    }

    public void LineTile(){
    }

    public void setPosition(int position){
        this.position = position;
    }

    public int getTilePosition(){
        if (position == 3) position = 0;
        return position;
    }

    @Override
    public void draw(Canvas canvas, int side) {
        switch (position){
            case 0:case 2: //Horizontal
                canvas.drawRect(side*0, side/3, side, side*2/3, p);
                break;
            case 1:case 3: //Vertical
                canvas.drawRect(side*1/3, side*0, side*2/3, side*1, p);
                break;
        }
        //side retorna a posição do vértice do primeiro quadrante da celula
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}

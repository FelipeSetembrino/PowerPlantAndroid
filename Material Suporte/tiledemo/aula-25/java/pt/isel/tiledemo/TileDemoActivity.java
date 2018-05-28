package pt.isel.tiledemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

import pt.isel.leic.poo.tiledemo.R;
import pt.isel.poo.tile.OnTileTouchListener;
import pt.isel.poo.tile.Tile;
import pt.isel.poo.tile.TilePanel;

public class TileDemoActivity
        extends Activity
        implements OnTileTouchListener
{

    private TilePanel tilePanel;
    private TextView radiusValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tile_demo);

        // read initial value from raw file
        int initialRadius;
        InputStream initFile = getResources().openRawResource(R.raw.info);
        Scanner in = new Scanner(initFile);
        initialRadius = in.nextInt();
        in.close();

        //CircleTile c = new CircleTile();
        tilePanel = findViewById(R.id.tilepanel);
        for(int lin = 0; lin < tilePanel.getHeightInTiles(); ++lin) {
            for (int col=0; col < tilePanel.getWidthInTiles(); ++col) {
                tilePanel.setTile(col, lin, new CircleTile(initialRadius));
            }
        }

        radiusValue = findViewById(R.id.radius);

        tilePanel.setListener(this);
    }

    @Override
    public boolean onClick(int xTile, int yTile) {
        Tile t = tilePanel.getTile(xTile, yTile);
        if (t instanceof ImgTile) return true;
        CircleTile ct = (CircleTile) t;
        ct.incRadius();
        radiusValue.setText("" + ct.getRadius());
        if (ct.getRadius() > 50) {
            // muda para imgtile
            tilePanel.setTile(xTile,yTile,
                    new ImgTile(this, R.drawable.cross));
        } else {
            tilePanel.invalidate(xTile, yTile);
            Log.d("Tile", "onClick x=" + xTile + " y=" + yTile);
        }
        return false;
    }

    @Override
    public boolean onDrag(int xFrom, int yFrom, int xTo, int yTo) {
        return false;
    }

    @Override
    public void onDragEnd(int x, int y) {

    }

    @Override
    public void onDragCancel() {

    }
}

package plant.power.powerplantandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import TilePacket.OnTileTouchListener;
import TilePacket.TilePanel;

public class MainActivity extends AppCompatActivity implements OnTileTouchListener {

    private TilePanel tilePanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilePanel = findViewById(R.id.tilepanel);

        tilePanel.setTile(0,0,new LineTile(1));

    }





    @Override
    public boolean onClick(int xTile, int yTile) {
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

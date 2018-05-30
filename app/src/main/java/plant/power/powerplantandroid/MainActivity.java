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

        tilePanel.setTile(0,0,new LineTile(0));
        tilePanel.setTile(0,1,new CurveTile(0));
        tilePanel.setTile(0,2,new TeeTile(3));
        tilePanel.setTile(0,3,new HouseTile(0, this));
        tilePanel.setTile(0,4,new PowerTile(0, this));

        tilePanel.setListener(this);

    }


    @Override
    public boolean onClick(int xTile, int yTile) {
        tilePanel.setTile(xTile,yTile,new LineTile(1));
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

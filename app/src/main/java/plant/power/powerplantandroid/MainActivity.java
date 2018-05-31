package plant.power.powerplantandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

import TilePacket.OnTileTouchListener;
import TilePacket.TilePanel;

public class MainActivity extends AppCompatActivity implements OnTileTouchListener {

    private TilePanel tilePanel;
    private Random rdm = new Random();
    private int tileRan;
    private int position;
    private static final int TILE_NUMBER = 5;
    private static final int POSITION_NUMBER = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilePanel = findViewById(R.id.tilepanel);

        load();
        /*
        tilePanel.setTile(0,0,new LineTile(0));
        tilePanel.setTile(0,1,new CurveTile(0));
        tilePanel.setTile(0,2,new TeeTile(3));
        tilePanel.setTile(0,3,new HouseTile(0, this));
        tilePanel.setTile(0,4,new PowerTile(0, this));
        */
        tilePanel.setListener(this);

    }

    private void load(){
        for (int tileY = 0; tileY < tilePanel.getHeightInTiles(); ++tileY){
            for (int tileX = 0; tileX < tilePanel.getWidthInTiles(); ++tileX){
                tileRan = rdm.nextInt(TILE_NUMBER)+1;
                position = rdm.nextInt(POSITION_NUMBER)+1;
                switch (tileRan){
                    case 1:
                        tilePanel.setTile(tileX,tileY,new LineTile(position));
                        break;
                    case 2:
                        tilePanel.setTile(tileX,tileY,new CurveTile(position));
                        break;
                    case 3:
                        tilePanel.setTile(tileX,tileY,new TeeTile(position));
                        break;
                    case 4:
                        tilePanel.setTile(tileX,tileY,new HouseTile(position, this));
                        break;
                    case 5:
                        tilePanel.setTile(tileX,tileY,new PowerTile(position, this));
                        break;
                }
            }
        }
    }


    @Override
    public boolean onClick(int xTile, int yTile) {
        load();
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

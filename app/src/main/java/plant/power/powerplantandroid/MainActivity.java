package plant.power.powerplantandroid;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import TilePacket.OnTileTouchListener;
import TilePacket.TilePanel;
import plant.power.powerplantandroid.Model.Loader;
import plant.power.powerplantandroid.Model.Plant;
import plant.power.powerplantandroid.ViewTile.CurveTile;
import plant.power.powerplantandroid.ViewTile.HouseTile;
import plant.power.powerplantandroid.ViewTile.LineTile;
import plant.power.powerplantandroid.ViewTile.TeeTile;

public class MainActivity extends AppCompatActivity implements OnTileTouchListener {

    private TilePanel tilePanel;
    private Plant model;
    private int num;
    private static final String LEVELS_FILE = "Levels.txt"; // Name of levels file

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilePanel = findViewById(R.id.tilepanel);

        num = 0;
        loadLevel(num);

        /*
        tilePanel.setTile(0,0,new LineTile(0));
        tilePanel.setTile(0,1,new CurveTile(0));
        tilePanel.setTile(0,2,new TeeTile(3));
        tilePanel.setTile(0,3,new HouseTile(0, this));
        tilePanel.setTile(0,4,new PowerTile(0, this));
        */
        tilePanel.setListener(this);

    }

    @Override
    public boolean onClick(int xTile, int yTile) {
        /*if (tilePanel.getTile(xTile,yTile) instanceof LineTile){
            position = line.getTilePosition() + 1;
            line.setPosition(position);
            tilePanel.setTile(xTile,yTile,new LineTile());
        }
        else if (tilePanel.getTile(xTile,yTile) instanceof CurveTile){

        }
        else if (tilePanel.getTile(xTile,yTile) instanceof TeeTile){

        }
        else if (tilePanel.getTile(xTile,yTile) instanceof HouseTile){

        }
        //load();
        return false;
        */
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

    /**
     * Load the model of the indicated level from the LEVELS_FILE file
     * @param n The level to load (1..MAX)
     * @return true if the level is loaded
     */
    private boolean loadLevel(int n) {
        Scanner in = null;
        try {
            AssetManager initFile = getAssets();
            in = new Scanner(new FileInputStream(LEVELS_FILE)); // Scanner to read the file
            model = new Loader(in).load(n);                     // Load level from scanner
            //model.setListener( listener );                      // Set the listener of modifications
            //view = new TilePanel(model.getHeight(),model.getWidth(),CellTile.SIDE);
            //win.clear();
           // view.center(WIN_HEIGHT,WIN_WIDTH);
            //status.setLevel(n);
            //status.setMoves(0);
            return true;
        } catch (FileNotFoundException | InputMismatchException e) {
            System.out.println("Error loading file \""+LEVELS_FILE+"\":\n"+e.getMessage());
            return false;
        } catch (Loader.LevelFormatException e) {
            System.out.println(e.getMessage()+" in file \""+LEVELS_FILE+"\"");
            System.out.println(" "+e.getLineNumber()+": "+e.getLine());
            return false;
        } finally {
            if (in!=null) in.close();   // Close the file
        }
    }
}

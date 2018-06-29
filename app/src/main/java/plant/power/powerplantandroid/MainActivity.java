package plant.power.powerplantandroid;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import TilePacket.OnTileTouchListener;
import TilePacket.Tile;
import TilePacket.TilePanel;
import plant.power.powerplantandroid.Cells.casaCell;
import plant.power.powerplantandroid.Cells.curvaCell;
import plant.power.powerplantandroid.Cells.espacoCell;
import plant.power.powerplantandroid.Cells.fonteCell;
import plant.power.powerplantandroid.Cells.linhaCell;
import plant.power.powerplantandroid.Cells.ramoCell;
import plant.power.powerplantandroid.Model.Cell;
import plant.power.powerplantandroid.Model.Loader;
import plant.power.powerplantandroid.Model.Plant;
import plant.power.powerplantandroid.ViewTile.CurveTile;
import plant.power.powerplantandroid.ViewTile.HouseTile;
import plant.power.powerplantandroid.ViewTile.LineTile;
import plant.power.powerplantandroid.ViewTile.PowerTile;
import plant.power.powerplantandroid.ViewTile.SpaceTile;
import plant.power.powerplantandroid.ViewTile.TeeTile;

public class MainActivity extends AppCompatActivity implements OnTileTouchListener {

    private TilePanel tilePanel;
    private Plant model;
    private Cell cell;
    private int num;
    private static final String LEVELS_FILE = "Levels.txt"; // Name of levels file

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilePanel = findViewById(R.id.tilepanel);

        num = 1;
        loadLevel(num);

        tilePanel.setListener(this);
        tilePanel.setSize(model.getWidth(),model.getHeight());
        for (int w = 0; w < model.getWidth(); w++){
            for (int h = 0; h < model.getWidth(); h++){
                if (model.getCell(w,h) instanceof casaCell) tilePanel.setTile(w,h,new HouseTile(model.getCellPosition(w,h), this));
                else if (model.getCell(w,h) instanceof curvaCell) tilePanel.setTile(w,h,new CurveTile(model.getCellPosition(w,h)));
                else if (model.getCell(w,h) instanceof espacoCell) tilePanel.setTile(w,h,new SpaceTile());
                else if (model.getCell(w,h) instanceof fonteCell) tilePanel.setTile(w,h,new PowerTile(model.getCellPosition(w,h), this));
                else if (model.getCell(w,h) instanceof linhaCell) tilePanel.setTile(w,h,new LineTile(model.getCellPosition(w,h)));
                else if (model.getCell(w,h) instanceof ramoCell) tilePanel.setTile(w,h,new TeeTile(model.getCellPosition(w,h)));
            }
        }
        model.cellRules();
    }

    @Override
    public boolean onClick(int xTile, int yTile) {
        if (model.getCell(xTile,yTile) instanceof casaCell) tilePanel.setTile(xTile,yTile,new HouseTile(model.getCellPosition(xTile,yTile), this));
        else if (model.getCell(xTile,yTile) instanceof curvaCell) tilePanel.setTile(xTile,yTile,new CurveTile(model.getCellPosition(xTile,yTile)));
        else if (model.getCell(xTile,yTile) instanceof espacoCell) tilePanel.setTile(xTile,yTile,new SpaceTile());
        else if (model.getCell(xTile,yTile) instanceof fonteCell) tilePanel.setTile(xTile,yTile,new PowerTile(model.getCellPosition(xTile,yTile), this));
        else if (model.getCell(xTile,yTile) instanceof linhaCell) tilePanel.setTile(xTile,yTile,new LineTile(model.getCellPosition(xTile,yTile)));
        else if (model.getCell(xTile,yTile) instanceof ramoCell) tilePanel.setTile(xTile,yTile,new TeeTile(model.getCellPosition(xTile,yTile)));
        Log.i("position: ", ""+model.cell_position[xTile][yTile]);
        model.cellRules();
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
            InputStream initFile = getResources().openRawResource(R.raw.levels);
            in = new Scanner(initFile);
            model = new Loader(in).load(n);                     // Load level from scanner
            //model.setListener( listener );                      // Set the listener of modifications
            //view = new TilePanel(model.getHeight(),model.getWidth(),CellTile.SIDE);
            //win.clear();
           // view.center(WIN_HEIGHT,WIN_WIDTH);
            //status.setLevel(n);
            //status.setMoves(0);
            return true;
        }
        catch (InputMismatchException e) {
            System.out.println("Error loading file \""+LEVELS_FILE+"\":\n"+e.getMessage());
            return false;
        }
        catch (Loader.LevelFormatException e) {
            System.out.println(e.getMessage()+" in file \""+LEVELS_FILE+"\"");
            System.out.println(" "+e.getLineNumber()+": "+e.getLine());
            return false;
        }
        finally {
            if (in!=null) in.close();   // Close the file
        }
    }
}

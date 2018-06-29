package plant.power.powerplantandroid.Model;

import android.util.Log;

import java.util.Random;

import TilePacket.Tile;
import plant.power.powerplantandroid.Cells.casaCell;
import plant.power.powerplantandroid.Cells.curvaCell;
import plant.power.powerplantandroid.Cells.espacoCell;
import plant.power.powerplantandroid.Cells.fonteCell;
import plant.power.powerplantandroid.Cells.linhaCell;
import plant.power.powerplantandroid.Cells.ramoCell;

public class Plant {

    private Cell[][] map; // = new Cell[height][width];
    private Cell[] map_neighbors = new Cell[4];
    private int width, height;
    public int[][] cell_position;
    private int[] cell_neighbors_position = new int[4];
    Random ran = new Random();

    public Plant() {

    }

    public void setWidthHeight(int width, int height) {
        this.width = width;
        this.height = height;
        map = new Cell[height][width];
        cell_position = new int[height][width];
    }

    public void putCell(int l, int i, Cell cell) {
        map[l][i] = cell;
        cell_position[l][i] = ran.nextInt(3);
    }

    public Cell getCell(int l, int i){
        return map[l][i];
    }

    public int getCellPosition(int l, int i){
        if (cell_position[l][i] == 3){
            cell_position[l][i] = 0;
            return cell_position[l][i];
        }
        else{
            return ++cell_position[l][i];
        }
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public void cellRules(){
        for (int h = 0; h < height; h++){
            for (int w = 0; w < width; w++){
                if (map[h][w] instanceof fonteCell){
                    neighbor(h,w);
                }
            }
        }

        /*
        if (map[l][i] instanceof fonteCell){
            neighbor(l,i);
        }
        else if (map[l][i] instanceof curvaCell);
        else if (map[l][i] instanceof espacoCell);
        else if (map[l][i] instanceof casaCell);
        else if (map[l][i] instanceof linhaCell);
        else if (map[l][i] instanceof ramoCell);
        */
    }

    private void neighbor(int l, int i){

        try {
            map_neighbors[0] = map[l][i-1];
            cell_neighbors_position[0] = cell_position[l][i-1];
            }
        catch (Exception e){
            map_neighbors[0] = null;
            cell_neighbors_position[0] = 4;
        }

        try {
            map_neighbors[1] = map[l-1][i];
            cell_neighbors_position[1] = cell_position[l-1][i];
        }
        catch (Exception e){
            map_neighbors[1] = null;
            cell_neighbors_position[1] =  4;
        }

        try {
            map_neighbors[2] = map[l][i+1];
            cell_neighbors_position[2] = cell_position[l][i+1];
        }
        catch (Exception e){
            map_neighbors[2] = null;
            cell_neighbors_position[2] =  4;
        }

        try {
            map_neighbors[3] = map[l+1][i];
            cell_neighbors_position[3] = cell_position[l+1][i];
        }
        catch (Exception e){
            map_neighbors[3] = null;
            cell_neighbors_position[3] =  4;
        }
    }

    private void howTouchMe(){

    }


}


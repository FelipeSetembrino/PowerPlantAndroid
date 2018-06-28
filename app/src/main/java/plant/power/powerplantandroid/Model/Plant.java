package plant.power.powerplantandroid.Model;


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
    private int width, height;
    private int[][] cell_position;
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
        if (cell_position[i][l] == 3){
            cell_position[i][l] = 0;
            return cell_position[l][i];
        }
        return cell_position[l][i]++;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public void cellChanged(int l, int i){
        if (map[l][i] instanceof casaCell) new casaCell();
        else if (map[l][i] instanceof curvaCell);
        else if (map[l][i] instanceof espacoCell);
        else if (map[l][i] instanceof fonteCell);
        else if (map[l][i] instanceof linhaCell);
        else if (map[l][i] instanceof ramoCell);
    }

    /*public int getPosition(int l, int i) {
        if (map[l][i] instanceof casaCell){

        }
        else if (map[l][i] instanceof curvaCell);
        else if (map[l][i] instanceof espacoCell);
        else if (map[l][i] instanceof fonteCell);
        else if (map[l][i] instanceof linhaCell);
        else if (map[l][i] instanceof ramoCell);
    }*/

}


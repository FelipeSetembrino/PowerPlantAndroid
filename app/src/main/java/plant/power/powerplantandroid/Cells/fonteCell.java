package plant.power.powerplantandroid.Cells;

import plant.power.powerplantandroid.Model.Cell;

/**
 * Created by felip on 10/06/2018.
 */

public class fonteCell extends Cell {

    private boolean[] side;

    public void fonteCell(){

    }

    public boolean[] getSideCell(int pos) {
        switch (pos) {
            case 0:
                side = new boolean[]{true, true, true, true};
                break;
            case 1:
                side = new boolean[]{true, true, true, true};
                break;
            case 2:
                side = new boolean[]{true, true, true, true};
                break;
            case 3:
                side = new boolean[]{true, true, true, true};
                break;
        }
        return side;
    }

}

package plant.power.powerplantandroid.Cells;

import plant.power.powerplantandroid.Model.Cell;

/**
 * Created by felip on 10/06/2018.
 */

public class casaCell extends Cell {

    private boolean[] side;

    public void casaCell(){
    }

    public boolean[] getSideCell(int pos){
        switch (pos) {
            case 0:
                side = new boolean[]{true, false, false, false};
                break;
            case 1:
                side = new boolean[]{false, true, false, false};
                break;
            case 2:
                side = new boolean[]{false, false, true, false};
                break;
            case 3:
                side = new boolean[]{false, false, false, true};
                break;
        }
        return side;
    }

}

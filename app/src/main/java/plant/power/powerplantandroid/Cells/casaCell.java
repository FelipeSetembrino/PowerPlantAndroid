package plant.power.powerplantandroid.Cells;

import plant.power.powerplantandroid.Model.Cell;

/**
 * Created by felip on 10/06/2018.
 */

public class casaCell extends Cell {

    public int rot;

    public void casaCell(){
        if (rot == 3)rot = 0;
        rot++;
    }

    public int getcasaCellRot(){
        return rot;
    }

}

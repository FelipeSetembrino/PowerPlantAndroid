package plant.power.powerplantandroid.Model;

import plant.power.powerplantandroid.Cells.casaCell;
import plant.power.powerplantandroid.Cells.curvaCell;
import plant.power.powerplantandroid.Cells.espacoCell;
import plant.power.powerplantandroid.Cells.fonteCell;
import plant.power.powerplantandroid.Cells.linhaCell;
import plant.power.powerplantandroid.Cells.ramoCell;

public abstract class Cell {
    protected static Plant model;


    public static Cell newInstance(char type) {

        Cell cell = null;

        if (type == 'P') {
            cell = new fonteCell();
        } else if (type == 'H') {
            cell = new casaCell();
        } else if (type == '-') {
            cell = new linhaCell();
        } else if (type == 'c') {
            cell = new curvaCell();
        } else if (type == 'T') {
            cell = new ramoCell();
        } else if (type == '.') {
            cell = new espacoCell();
        }

        return cell;
    }



    //TODO:
}


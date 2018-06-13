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
        switch (type){
            case 'P':
                return new fonteCell();
            case'H':
                return new casaCell();
            case'-':
                return new linhaCell();
            case'c':
                return new curvaCell();
            case'T':
                return new ramoCell();
            case'.':
                return new espacoCell();
            default:
                return null;
        }
    }


    //TODO:
}


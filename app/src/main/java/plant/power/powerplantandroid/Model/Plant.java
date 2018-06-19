package plant.power.powerplantandroid.Model;


public class Plant {

    private Cell[][] map; // = new Cell[height][width];

    public Plant() {

    }

    public void setWidthHeight(int width, int height) {
        map = new Cell[height][width];
    }

    public void putCell(int l, int i, Cell cell) {
        map[l][i] = cell;
    }

    public void init() {
    }

    public interface Listener {
        void cellChanged(int lin, int col, Cell cell);
    }

}


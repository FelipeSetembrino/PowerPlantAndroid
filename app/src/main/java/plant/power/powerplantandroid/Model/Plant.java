package plant.power.powerplantandroid.Model;


public class Plant {
    private Cell[][] map;

    public Plant() {
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


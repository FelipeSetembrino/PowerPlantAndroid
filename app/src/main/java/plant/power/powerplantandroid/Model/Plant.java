package plant.power.powerplantandroid.Model;


public class Plant {

    private int height;
    private int width;
    private Cell[][] map; // = new Cell[height][width];

    public Plant() {

    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
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


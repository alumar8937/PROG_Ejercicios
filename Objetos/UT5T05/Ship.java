// 18/01/2023 Pedro Marín Sanchis

public class Ship {
    
    private boolean placed;
    private int height;
    private int width;

    private int row;
    private int column;

    public Ship() {
        this.height = 1;
        this.width = 1;
    }

    public Ship(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void rotate() {
        if (!placed) {
            int flip;
            flip = height;
            height = width;
            width = flip;
        }
    }

    public boolean isPlaced() {
        return placed;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

}

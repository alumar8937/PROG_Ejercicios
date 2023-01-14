// 13/01/2023 - Pedro Marín Sanchis

public class Cell {

    public static enum CellType { // [ █ ] SHIP [ - ] EMPTY [ X ] MISS [ ╬ ] HIT

        SHIP("[ █ ]"),
        EMPTY("[ - ]"),
        MISS("[ X ]"),
        HIT("[ ╬ ]");

        private final String cellString;

        CellType(String cellString) {

            this.cellString = cellString;

        }

        public String getCellString() {
            return cellString;
        }

    }

    private CellType type = CellType.MISS;

    public Cell() {
        this.type = CellType.EMPTY;
    }

    public Cell(CellType type) {
        this.type = type;
    }

    public String toString() {
        return type.getCellString();
    }

    public void setCellType(CellType type) {
        this.type = type;
    }

    public boolean isPopulated() {
        return (type == CellType.SHIP);
    }

}

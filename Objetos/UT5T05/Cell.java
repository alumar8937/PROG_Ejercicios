// 13/01/2023 - Pedro Marín Sanchis

import Utils.ConsoleColors;

public class Cell {

    public static enum CellType {

        SHIP("███", ConsoleColors.WHITE),
        EMPTY(" · ", ConsoleColors.GREY_8),
        MISS(" X ", ConsoleColors.WHITE),
        HIT("▓╬▓", ConsoleColors.WHITE);

        private final String cellString;
        private final String color;

        CellType(String cellString, String color) {

            this.cellString = cellString;
            this.color = color + cellString + ConsoleColors.RESET;

        }

        public String getCellString() {
            return cellString;
        }

        public String getCellColor() {
            return color;
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

    public boolean isShip() {
        return (type == CellType.SHIP);
    }

}

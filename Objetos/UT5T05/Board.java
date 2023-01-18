// 13/01/2023 - Pedro Marín Sanchis

// Contains a cell matrix.

import Utils.StringUtils;

import java.util.ArrayList;

import Utils.ConsoleColors;

public class Board {
    
    final private static char[] ALPHABET_INDEX = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    final private int MAX_ROWS = 50;
    final private int MIN_ROWS = 8;
    final private int MAX_COLUMNS = ALPHABET_INDEX.length;
    final private int MIN_COLUMNS = 8;
    private String boardName;
    protected boolean colorizeCells;
    protected String boardColor;
    protected Cell[][] cells;
    private ArrayList<Ship> ships = new ArrayList<Ship>();

    public Board(String boardName, boolean colorizeCells) {
        this.cells = new Cell[MIN_ROWS][MIN_COLUMNS]; // Row, Column.
        this.boardName = boardName;
        this.colorizeCells = colorizeCells;
        this.boardColor = ConsoleColors.WHITE;
        populateCells();
    }

    public Board(int rows, int columns, String boardName, boolean colorizedCells, String boardColor) {
        
        if (rows >= MAX_ROWS) {rows = MAX_ROWS;}
        if (columns >= MAX_COLUMNS) {columns = MAX_COLUMNS;}

        if (rows <= MIN_ROWS) {rows = MIN_ROWS;}
        if (columns <= MIN_COLUMNS) {columns = MIN_COLUMNS;}

        this.cells = new Cell[rows][columns]; // Row, Column.
        populateCells();
        this.boardName = boardName;
        this.colorizeCells = colorizedCells;
        this.boardColor = boardColor;

    }
    
    public String toString(boolean colorize) {
        
        String[] boardStringArray = new String[cells.length]; // Rows.
        String[] numericalIndexingArray = new String[cells.length]; // Number column.
        String[] alphabeticalIndexingArray = new String[]{""};
        String[] combinedBoxes; // Final return String.

        for (int i = 0; i < boardStringArray.length; i++) { // Set all elements as empty String instead of NULL.
            boardStringArray[i] = "";
        }

        for (int i = 0; i < cells.length; i++) { // Incorporate all cells.
            for (int j = 0; j < cells[0].length; j++){
                boardStringArray[i] = boardStringArray[i] + cells[i][j].toString();
            }
            numericalIndexingArray[i] = ""; // Set element to empty string (Is NULL before).
            numericalIndexingArray[i] = numericalIndexingArray[i] + " " + i + " "; // Numerical indexing column.
        }

        for (int i = 0; i < cells[0].length; i++) {
            alphabeticalIndexingArray[0] = alphabeticalIndexingArray[0] + " " + ALPHABET_INDEX[i] + " ";
        }

        // Encase in box.

        numericalIndexingArray = StringUtils.surroundStringArrayWithBox(numericalIndexingArray);
        alphabeticalIndexingArray = StringUtils.surroundStringArrayWithBox(alphabeticalIndexingArray);
        boardStringArray = StringUtils.surroundStringArrayWithBox(boardStringArray);

        combinedBoxes = new String[boardStringArray.length + alphabeticalIndexingArray.length + 1]; // Initialze combined boxes array. + 1 For the Name
        
        for (int i = 0; i < combinedBoxes.length; i++) { // Set all elements as empty String instead of NULL.
            combinedBoxes[i] = "";
        }

        // Combine boxes.

        for (int i = 0; i < alphabeticalIndexingArray.length; i++) { // Set all elements as empty String instead of NULL.
            combinedBoxes[i+1] = alphabeticalIndexingArray[i];
        }

        for (int i = 0; i < boardStringArray.length; i++) {
            boardStringArray[i] = boardStringArray[i] + " " + numericalIndexingArray[i];
            combinedBoxes[i+alphabeticalIndexingArray.length+1] = boardStringArray[i];
        }

        combinedBoxes[0] = " ".repeat((combinedBoxes[1].length() / 2) - (boardName.length() - boardName.length() / 2)) + boardName;
        StringUtils.padToSameLength(combinedBoxes, ' ');
        
        if (colorize) {
            return colorize(boardColor + StringUtils.stringArrayToString(combinedBoxes) + ConsoleColors.RESET); 
        } else {
            return StringUtils.stringArrayToString(combinedBoxes);
        }
    
    }

    public String colorize(String boardString) { // Adds ASCII color characters + boardColor afterwards.
        for (int i = 0; i < Cell.CellType.values().length; i++) {
            boardString = boardString.replaceAll(Cell.CellType.values()[i].getCellString(), (Cell.CellType.values()[i].getCellColor() + boardColor));
        }
        return boardString;
    }

    public void populateCells() { // Fills cells array with Cell objects.
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++){
                cells[i][j] = new Cell();
            }
        } 
    }

    public boolean isShipCell(int row, int column) {
        return cells[row][column].isShip();
    }

    public boolean addShip(Ship ship, int row, int column) {
        boolean canAddShip = true;
        
        for (int i = 0; i < ship.getHeight(); i++) {
            for (int j = 0; j < ship.getWidth(); j++) {
                if (!canPlaceShipCell(row + i, column + j)) {
                    canAddShip = false;
                }
            }
        }

        if (canAddShip) {
            
            ships.add(ship);
            for (int i = 0; i < ship.getHeight(); i++) { 
                for (int j = 0; j < ship.getWidth(); j++) {
                    cells[row + i][column + j].setCellType(Cell.CellType.SHIP);
                    placeSafezone(row + i, column + j);
                }
            }

            ship.setRow(row);
            ship.setColumn(column);

        }

        return canAddShip;
    
    }

    public boolean isShipAlive(Ship ship) {
        ships.add(ship);
        for (int i = 0; i < ship.getHeight(); i++) {
            for (int j = 0; j < ship.getWidth(); j++) {
                if (isShipCell(ship.getRow() + i, ship.getColumn() + j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canPlaceShipCell(int row, int column) {
        if (row >= getRowNumber() || column >= getColumnNumber()) {
            return false;
        } else {
            return (!cells[row][column].isSafezone());
        }
    }

    public void placeSafezone(int row, int column) {
        row--; // Move to upper left corner
        column--;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    if (!cells[row+i][column+j].isShip()) {
                        cells[row+i][column+j].setCellType(Cell.CellType.SAFETY);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public int getAliveShipNumber() {
        int shipCells = 0;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (isShipCell(i, j)) {shipCells++;}
            }
        }

        return shipCells;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
    
    public void setColorizeCells(boolean colorizedCells) {
        this.colorizeCells = colorizedCells;
    }

    public String getBoardColor() {
        return boardColor;
    }

    public void setBoardColor(String boardColor) {
        this.boardColor = boardColor;
    }

    public int getColumnNumber() {
        return cells[0].length;
    }

    public int getRowNumber() {
        return cells.length;
    }

}
// 13/01/2023 - Pedro Marín Sanchis

// Contains a cell matrix.

public class Board {
    
    final private char[] ALPHABET_INDEX = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    final private int MAX_ROWS = 50;
    final private int MIN_ROWS = 8;
    final private int MAX_COLUMNS = ALPHABET_INDEX.length;
    final private int MIN_COLUMNS = 8;
    private String boardName = "Board";
    protected Cell[][] cells;

    public Board() {
        this.cells = new Cell[MIN_ROWS][MIN_COLUMNS]; // Row, Column.
        populateCells();
    }

    public Board(int rows, int columns, String boardName) {
        
        if (rows >= MAX_ROWS) {rows = MAX_ROWS;}
        if (columns >= MAX_COLUMNS) {columns = MAX_COLUMNS;}

        if (rows <= MIN_ROWS) {rows = MIN_ROWS;}
        if (columns <= MIN_COLUMNS) {columns = MIN_COLUMNS;}

        this.cells = new Cell[rows][columns];
        populateCells();
        this.boardName = boardName;
    }

    public String toString() {
        
        String[] boardStringArray = new String[cells.length]; // Rows.
        String[] numericalIndexingArray = new String[cells.length]; // Number column.
        String alphabeticalIndexingRow = "";
        String boardString = ""; // Final return String.

        for (int i = 0; i < boardStringArray.length; i++) { // Set all elements as empty String instead of NULL.
            boardStringArray[i] = "";
        }

        for (int i = 0; i < cells.length; i++) { // Incorporate all cells.
            for (int j = 0; j < cells[0].length; j++){
                boardStringArray[i] = boardStringArray[i] + cells[i][j].toString();
            }
            numericalIndexingArray[i] = ""; // Set element to empty string (Is NULL before).
            numericalIndexingArray[i] = numericalIndexingArray[i] + "[ " + i + " ]"; // Numerical indexing column.
        }

        for (int i = 0; i < cells[0].length; i++) {
            alphabeticalIndexingRow = alphabeticalIndexingRow + "[ " + ALPHABET_INDEX[i] + " ]";
        }

        // Encase in box.

        numericalIndexingArray = StringUtils.surroundStringWithBox(numericalIndexingArray);
        alphabeticalIndexingRow = StringUtils.stringArrayToString(StringUtils.surroundStringWithBox(alphabeticalIndexingRow));
        boardStringArray = StringUtils.surroundStringWithBox(boardStringArray);

        // Combine boxes.

        boardString = " ".repeat((alphabeticalIndexingRow.substring(0, alphabeticalIndexingRow.indexOf('\n')).length() / 2) - (boardName.length() / 2)) + boardName.toUpperCase() + "\n" + boardString + alphabeticalIndexingRow + "\n";
        
        for (int i = 0; i < boardStringArray.length; i++) {
            boardString = boardString + boardStringArray[i] + " " + numericalIndexingArray[i] + "\n";
        }
    
        return boardString;
    
    }

    public void populateCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++){
                cells[i][j] = new Cell();
            }
        } 
    }

    public boolean isCellPopulated(int row, int column) {
        return cells[column][row].isPopulated();
    }

    /*public void setCellType(int column, int row, Cell.CellType type) { // Made obsolete due to "board" becoming protected instead of private.
        board[column][row].setCellType(type);
    }*/

    public String getBoardName() {
        return boardName;
    }

    public int getColumnNumber() {
        return cells[0].length;
    }

    public int getRowNumber() {
        return cells.length;
    }

}
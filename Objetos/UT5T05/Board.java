public class Board {

    // Legend for toString method.
    
    char[] alphabetIndex = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

        // [ █ ] SHIP [ - ] UNTOUCHED [ ╳ ] MISS [ ╬ ] HIT

    final private String shipCell = "[ █ ]";
    final private String untouchedCell = "[ - ]";
    final private String missCell = "[ ╳ ]";
    final private String hitCell = "[ ╬ ]";
    private String boardName = "Board";

    private boolean[][] board;

    public Board() {
        this.board = new boolean[8][8]; // Row, Column.
    }

    public Board(int columns, int rows, String boardName) {
        //if
        this.board = new boolean[rows][columns];
        this.boardName = boardName;
    }

    public String toString() {
        
        String[] boardStringArray = new String[board.length]; // Rows

        for (int i = 0; i < board.length; i++) {
            boardStringArray[i] = "";
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j]) {
                    boardStringArray[i] = boardStringArray[i] + shipCell;
                } else {
                    boardStringArray[i] = boardStringArray[i] + untouchedCell;
                }
            }
            boardStringArray[i] = boardStringArray[i] + "[" + alphabetIndex[i] + "]";
        }

        for (int i = 0; i < board)

        return StringUtils.surroundWithBox(boardStringArray);
    }

    public boolean isPopulated(int column, int row) {
        return board[column][row];
    }

    public void setPopulated(int column, int row, boolean populated) {
        board[column][row] = populated;
    }

}
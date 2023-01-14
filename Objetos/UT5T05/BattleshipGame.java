// 13/01/2023 - Pedro Marín Sanchis

public class BattleshipGame {
    public static void main(String[] args) {
        Board board = new Board(5,5,"Jade! <3");
        BoardView boardView = new BoardView(board);

        board.cells[1][1].setCellType(Cell.CellType.SHIP);
        board.cells[1][2].setCellType(Cell.CellType.SHIP);

        boardView.revealCell(1, 1);
        boardView.revealCell(3, 1);

        System.out.println(board.toString());
        System.out.println(boardView.toString());
    }

    private static void cls() {
        System.out.println("\n".repeat(99));
    }
}

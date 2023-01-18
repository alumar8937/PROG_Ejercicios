/* 13/01/2023 - Pedro Marín Sanchis

BoardView stores knowledge of another board. The whole point is to be able to have many instaces of a viewer
for a single board (Suppose a 3v3. One player shouldn't know the other's shots, since fog of war is the whole
point of the game.)

*/

public class BoardView extends Board {

    protected Board originalBoard;
    
    private int shotsMade;
    private int shotsHit;

    public BoardView(Board oriniginalBoard) {
        super(oriniginalBoard.getColumnNumber(), oriniginalBoard.getRowNumber(), oriniginalBoard.getBoardName(),
                oriniginalBoard.colorizeCells, oriniginalBoard.boardColor);
        this.originalBoard = oriniginalBoard;
    }

    public boolean revealCell(int row, int column) { // Updates view and updates original if it is populated (With a SHIP cell)
        if (originalBoard.isShipCell(row, column)) {

            cells[row][column].setCellType(Cell.CellType.HIT); // Set this cell to HIT cell.
            originalBoard.cells[row][column].setCellType(Cell.CellType.HIT); // Set original board cell to HIT cell.

            shotsMade++;
            shotsHit++;
            return true;

        } else {
            if (!cells[row][column].isHitShip())
            cells[row][column].setCellType(Cell.CellType.MISS);
            shotsMade++;
            return false;
        }
    }

    public void revealAllCheat() { // Reveals all cells and ruins the fun.
        for (int i = 0; i < getRowNumber(); i++) {
            for (int j = 0; j < getColumnNumber(); j++) {
                cells[i][j].setCellType(originalBoard.cells[i][j].getCellType());
            }
        }
    }

    public int getShotsMade() {
        return shotsMade;
    }

    public int getShotsHit() {
        return shotsHit;
    }
    
}

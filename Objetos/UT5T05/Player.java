// 13/01/2023 - Pedro Marín Sanchis

import java.util.ArrayList;

public class Player {
    private Board playerBoard;
    private ArrayList<BoardView> boardViews = new ArrayList<>();
    private String name;
    
    public Player(String name, boolean RENDER_COLORS) {
        this.playerBoard = new Board(name, RENDER_COLORS);
        this.name = name;
    }

    public Player(Board playerBoard, ArrayList<BoardView> boardViews) {
        this.playerBoard = playerBoard;
        this.boardViews = boardViews;
        this.name = playerBoard.getBoardName();
    }

    public ArrayList<BoardView> getBoardViews() {
        return boardViews;
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }

    public String getName() {
        return name;
    }

    public void addBoardView(BoardView boardView) {
        boardViews.add(boardView);
    }

}

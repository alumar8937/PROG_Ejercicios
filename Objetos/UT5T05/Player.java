// 13/01/2023 - Pedro Marín Sanchis

import java.util.ArrayList;

public class Player {
    private Board board;
    private ArrayList<BoardView> boardViews = new ArrayList<>();
    private String name;
    
    public Player(String name, boolean RENDER_COLORS) {
        this.board = new Board(name, RENDER_COLORS);
        this.name = name;
    }

    public Player(Board board, ArrayList<BoardView> boardViews) {
        this.board = board;
        this.boardViews = boardViews;
        this.name = board.getBoardName();
    }

    public ArrayList<BoardView> getBoardViews() {
        return boardViews;
    }

    public Board getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }

    public void addBoardView(BoardView boardView) {
        boardViews.add(boardView);
    }

}

package org.ave.pet.sport;

import java.util.ArrayList;
import java.util.List;

import org.ave.pet.board.Board;
import org.ave.pet.board.BoardType;

public class BeachSport {

    private List<Board> boards;

    public BeachSport() {
        init();
    }

    private void init() {
        boards = new ArrayList<Board>(2);
        boards.add(new Board());
        boards.add(new Board(BoardType.KITESURF));
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

}

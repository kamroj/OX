package kamil.rojek.ox;

import kamil.rojek.ox.CustomExceptions.BoardCreatorException;

public class AppMain {
    public static void main(String[] args) throws BoardCreatorException {
        BoardCreator boardCreator = new BoardCreator();
        Board board = boardCreator.createNewBoard(3,3);

        BoardDisplay boardDisplay = new BoardDisplay(board);
        boardDisplay.updateView();
    }

}


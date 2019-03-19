package kamil.rojek.ox.Game;

import kamil.rojek.ox.CustomExceptions.BoardCreatorException;

/**
 * @author Kamil Rojek
 */
class BoardCreator {

    Board createNewBoard(int rowsNumber, int columnsNumber) throws BoardCreatorException {
        try {
            Board board = new Board(rowsNumber, columnsNumber);
            fillBoardWithNoneSeeds(board);
            return board;
        }
        catch (IllegalArgumentException e) {
            throw new BoardCreatorException("Cannot create new Board!", e);
        }
    }

    private void fillBoardWithNoneSeeds(Board board){
        for (int i = 0; i < board.fields.length; i++){
            for (int j = 0; j < board.fields[i].length; j++){
                board.fields[i][j] = new Seed(SeedType.None);
            }
        }
    }
}

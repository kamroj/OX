package kamil.rojek.ox;

/**
 * @author Kamil Rojek
 */
public class BoardCreator {
    public Board createNewBoard(int columnsNumber, int rowsNumber) {
        return new Board(columnsNumber, rowsNumber);
    }
}

package kamil.rojek.ox;

/**
 * Board holding fields
 *
 * @author Kamil Rojek
 */
public class Board {
    public Board(int columnsNuber, int rowsNumber) {
        if (columnsNuber <= 2 || rowsNumber <= 2)
            throw new IllegalArgumentException("Minimum board size must be 3x3");
    }
}

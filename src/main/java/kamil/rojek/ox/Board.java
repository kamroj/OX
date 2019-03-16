package kamil.rojek.ox;

import java.util.Arrays;

/**
 * Board holding fields
 *
 * @author Kamil Rojek
 */
public class Board {
    Seed[][] fields;

    public Board(int columnsNumber, int rowsNumber) {
        if (columnsNumber <= 2 || rowsNumber <= 2)
            throw new IllegalArgumentException("Minimum fields size must be 3x3");

        fields = new Seed[columnsNumber][rowsNumber];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        Board boardToCompare = (Board) obj;
        Seed[][] otherFields = boardToCompare.fields;

        if (otherFields.length != fields.length) {
            return false;
        }

        for (int i = 0; i < fields.length; i++) {
            if (!Arrays.equals(fields[i], otherFields[i])) {
                return false;
            }
        }
        return true;
    }
}

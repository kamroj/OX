package kamil.rojek.ox.game;

import java.util.Arrays;

/**
 * Main board that holds seeds (marks X and O)
 * @author Kamil Rojek
 */
class Board {
    Seed[][] fields;

    Board(int rowsNumber, int columnsNumber) {
        if (rowsNumber <= 2 || columnsNumber <= 2)
            throw new IllegalArgumentException("Minimum fields size must be 3x3");

        fields = new Seed[rowsNumber][columnsNumber];
    }

    /**
     *
     * @param rowNumber number of rows
     * @param columnNumber number of columns
     * @param type Seed type
     */
    void markField(int rowNumber, int columnNumber, SeedType type) {
        fields[rowNumber][columnNumber].type = type;
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

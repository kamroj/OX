package kamil.rojek.ox.game;

/**
 * Algorithm that checks win and availability of seed on the board
 * @author Kamil Rojek
 */
class GameValidator {
    private Board board;
    private SeedType type;
    private int fieldsWithSameTypeCouter = 0;
    private int winningLimit = 3;

    /**
     * Default winning condition is set to 3
     * @param board takes current board
     */

    GameValidator(Board board) {
        this.board = board;
    }

    /**
     *
     * @param board takes current board
     * @param winningLimit set winning condition limit
     */

    GameValidator(Board board, int winningLimit) {
        this.board = board;
        this.winningLimit = winningLimit;
    }


    /**
     * Validate if seed with parameters rowNumber and columnNumber is available to take
     * @param rowNumber row number
     * @param columnNumber column number
     * @return true if is available or false if seed is taken
     */
    boolean validateSeed(int rowNumber, int columnNumber) {
        return rowNumber >= 0 && rowNumber < board.fields.length &&
                columnNumber >= 0 && columnNumber < board.fields[0].length &&
                board.fields[rowNumber][columnNumber].type.equals(SeedType.None);
    }


    /**
     * validate horizontally, vertically and diagonally winning conditions start from
     * point on board when last seed was placed
     * @param rowNumber row number
     * @param columnNumber column number
     * @return true if winning condition limit succeed false if it fails
     */
    boolean validateWin(int rowNumber, int columnNumber) {
        type = board.fields[rowNumber][columnNumber].type;

        return validateHorizotnaly(rowNumber, columnNumber) ||
                validateVertically(rowNumber, columnNumber) ||
                validateDiagonally(rowNumber, columnNumber);

    }


    /**
     * validate if all seeds are taken and not winning condition limit succeed
     * @return true if all seeds are taken and no winning condition limit succeed,
     *          false if winning condition limit succeed
     */
    boolean isDraw() {
        boolean isDraw = true;

        for (int i = 0; i < board.fields.length; i++) {
            for (int j = 0; j < board.fields[i].length; j++) {
                if (board.fields[i][j].type.equals(SeedType.None))
                    isDraw = false;
            }
        }
        return isDraw;
    }

    private boolean validateHorizotnaly(int rowNumber, int columnNumber) {
        if (checkHorizontalRightDirection(rowNumber, columnNumber))
            return true;
        else if (checkHorizontalLeftDirection(rowNumber, columnNumber))
            return true;
        else {
            fieldsWithSameTypeCouter = 0;
            return false;
        }
    }

    private boolean validateVertically(int rowNumber, int columnNumber) {
        if (checkVerticalDownDirection(rowNumber, columnNumber))
            return true;
        else if (checkVerticalUpDirection(rowNumber, columnNumber))
            return true;
        else {
            fieldsWithSameTypeCouter = 0;
            return false;
        }
    }

    private boolean validateDiagonally(int rowNumber, int columnNumber) {
        if (checkDiagonallyDownLeftDirection(rowNumber, columnNumber))
            return true;
        else if (checkDiagonallyUpLeftDirection(rowNumber, columnNumber))
            return true;
        else if (checkDiagonallyDownRightDirection(rowNumber, columnNumber))
            return true;
        else if (checkDiagonallyUpRightDirection(rowNumber, columnNumber))
            return true;
        else {
            fieldsWithSameTypeCouter = 0;
            return false;
        }
    }

    private boolean checkHorizontalRightDirection(int rowNumber, int columnNumber) {
        int columnToCheck = columnNumber;

        while (fieldsWithSameTypeCouter != winningLimit) {
            if (columnToCheck >= board.fields[0].length)
                return false;

            if (board.fields[rowNumber][columnToCheck].type.equals(type)) {
                fieldsWithSameTypeCouter++;
            }
            columnToCheck++;
        }
        return true;
    }

    private boolean checkHorizontalLeftDirection(int rowNumber, int columnNumber) {
        int columnToCheck = columnNumber;

        while (fieldsWithSameTypeCouter != winningLimit) {
            columnToCheck--;

            if (columnToCheck < 0) {
                return false;
            }

            if (board.fields[rowNumber][columnToCheck].type.equals(type)) {
                fieldsWithSameTypeCouter++;
            }
        }
        return true;
    }

    private boolean checkVerticalDownDirection(int rowNumber, int columnNumber) {
        int rowToCheck = rowNumber;

        while (fieldsWithSameTypeCouter != winningLimit) {
            if (board.fields.length <= rowToCheck)
                return false;

            if (board.fields[rowToCheck][columnNumber].type.equals(type)) {
                fieldsWithSameTypeCouter++;
            }
            rowToCheck++;
        }
        return true;
    }

    private boolean checkVerticalUpDirection(int rowNumber, int columnNumber) {
        int rowToCheck = rowNumber;

        while (fieldsWithSameTypeCouter != winningLimit) {
            rowToCheck--;

            if (rowToCheck < 0) {
                return false;
            }

            if (board.fields[rowToCheck][columnNumber].type.equals(type)) {
                fieldsWithSameTypeCouter++;
            }
        }
        return true;
    }

    private boolean checkDiagonallyDownLeftDirection(int rowNumber, int columnNumber) {
        int rowToCheck = rowNumber;
        int columnToCheck = columnNumber;

        while (fieldsWithSameTypeCouter != winningLimit) {
            if (rowToCheck >= board.fields.length  || columnToCheck >= board.fields[0].length)
                return false;

            if (board.fields[rowToCheck][columnToCheck].type.equals(type)) {
                fieldsWithSameTypeCouter++;
            }

            rowToCheck++;
            columnToCheck++;
        }
        return true;
    }


    private boolean checkDiagonallyUpLeftDirection(int rowNumber, int columnNumber) {
        int rowToCheck = rowNumber;
        int columnToCheck = columnNumber;

        while (fieldsWithSameTypeCouter != winningLimit) {

            rowToCheck--;
            columnToCheck--;

            if (rowToCheck < 0 || columnToCheck < 0) {
                return false;
            }


            if (board.fields[rowToCheck][columnToCheck].type.equals(type)) {
                fieldsWithSameTypeCouter++;
            }

        }
        return true;
    }

    private boolean checkDiagonallyDownRightDirection(int rowNumber, int columnNumber) {
        int rowToCheck = rowNumber;
        int columnToCheck = columnNumber;

        while (fieldsWithSameTypeCouter != winningLimit) {
            rowToCheck--;
            columnToCheck++;

            if (rowToCheck < 0 || columnToCheck >= board.fields[0].length) {
                return false;
            }

            if (board.fields[rowToCheck][columnToCheck].type.equals(type)) {
                fieldsWithSameTypeCouter++;
            }

        }
        return true;
    }

    private boolean checkDiagonallyUpRightDirection(int rowNumber, int columnNumber) {
        int rowToCheck = rowNumber;
        int columnToCheck = columnNumber;

        while (fieldsWithSameTypeCouter != winningLimit) {

            rowToCheck++;
            columnToCheck--;

            if (rowToCheck >= board.fields.length || columnToCheck < 0) {
                return false;
            }

            if (board.fields[rowToCheck][columnToCheck].type.equals(type)) {
                fieldsWithSameTypeCouter++;
            }

        }
        return true;
    }
}

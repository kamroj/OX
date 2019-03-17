package kamil.rojek.ox;

class GameValidator {
    private Board board;
    private SeedType type;
    private int fieldsWithSameTypeCouter = 0;
    private final int WINNING_SCORE = 3;

    GameValidator(Board board) {
        this.board = board;
    }

    boolean validateSeed(int rowNumber, int columnNumber) {
        return rowNumber >= 0 && rowNumber < board.fields.length &&
                columnNumber >= 0 && columnNumber < board.fields.length &&
                board.fields[rowNumber][columnNumber].type.equals(SeedType.None);
    }

    boolean validateWin(int rowNumber, int columnNumber) {
        type = board.fields[rowNumber][columnNumber].type;

        return validateHorizotnaly(rowNumber, columnNumber) ||
                validateVertically(rowNumber, columnNumber) ||
                validateDiagonally(rowNumber, columnNumber);

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
        if (checkHorizontalDownDirection(rowNumber, columnNumber))
            return true;
        else if (checkHorizontalUpDirection(rowNumber, columnNumber))
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

        while (fieldsWithSameTypeCouter != WINNING_SCORE) {
            if (board.fields.length - 1 < columnToCheck)
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

        while (fieldsWithSameTypeCouter != WINNING_SCORE) {
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

    private boolean checkHorizontalDownDirection(int rowNumber, int columnNumber) {
        int rowToCheck = rowNumber;

        while (fieldsWithSameTypeCouter != WINNING_SCORE) {
            if (board.fields.length - 1 < rowToCheck)
                return false;

            if (board.fields[rowToCheck][columnNumber].type.equals(type)) {
                fieldsWithSameTypeCouter++;
            }
            rowToCheck++;
        }
        return true;
    }

    private boolean checkHorizontalUpDirection(int rowNumber, int columnNumber) {
        int rowToCheck = rowNumber;

        while (fieldsWithSameTypeCouter != WINNING_SCORE) {
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

        while (fieldsWithSameTypeCouter != WINNING_SCORE) {
            if (rowToCheck >= board.fields.length || columnToCheck >= board.fields.length)
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

        while (fieldsWithSameTypeCouter != WINNING_SCORE) {

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

        while (fieldsWithSameTypeCouter != WINNING_SCORE) {
            rowToCheck--;
            columnToCheck++;

            if (rowToCheck < 0 || columnToCheck >= board.fields.length) {
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

        while (fieldsWithSameTypeCouter != WINNING_SCORE) {

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

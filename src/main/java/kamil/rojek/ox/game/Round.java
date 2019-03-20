package kamil.rojek.ox.game;

import kamil.rojek.ox.inputOutput.InputValidator;
import kamil.rojek.ox.inputOutput.SoutWrapper;

//to test
class Round {
    private Player player;
    private Board board;
    private int columnNumber;
    private int rowNumber;

    Round(Player player) {
        this.player = player;
    }

    void startRound (Board board){
        SoutWrapper.printMsg("Turn move: " + player.toString());
        this.board = board;
        takeTurn();
    }

    int getLastMarkedRow(){
        return rowNumber;
    }

    int getLastMarkedColumn(){
        return columnNumber;
    }

    Player getLastPlayerOfRound(){
        return player;
    }

    private void takeTurn(){
        GameValidator gameValidator = new GameValidator(board);

        do {
            SoutWrapper.printMsg("Type number of row: ", true);
            rowNumber = InputValidator.getIntegerInput();
            SoutWrapper.printMsg("Type number of column: ", true);
            columnNumber = InputValidator.getIntegerInput();

        } while (!gameValidator.validateSeed(rowNumber, columnNumber));

        board.markField(rowNumber, columnNumber, player.getSeedType());
    }
}

package kamil.rojek.ox.game;

import kamil.rojek.ox.inputOutput.InputValidator;
import kamil.rojek.ox.inputOutput.LocalizationKey;
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
        SoutWrapper.getInstance().getMsg(LocalizationKey.TURN_MOVE, player.toString());
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
            SoutWrapper.getInstance().getMsg(LocalizationKey.MOVE_PLAYER_ROW_TYPE, true);
            rowNumber = InputValidator.getIntegerInput();
            SoutWrapper.getInstance().getMsg(LocalizationKey.MOVE_PLAYER_COLUMN_TYPE, true);
            columnNumber = InputValidator.getIntegerInput();

        } while (!gameValidator.validateSeed(rowNumber, columnNumber));

        board.markField(rowNumber, columnNumber, player.getSeedType());
    }
}
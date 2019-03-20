package kamil.rojek.ox.menu;

import kamil.rojek.ox.customExceptions.InvalidSettingException;
import kamil.rojek.ox.inputOutput.LocalizationKey;
import kamil.rojek.ox.inputOutput.SoutWrapper;

/**
 * @author Kamil Rojek
 */
public class Settings {
    private int rowSize = 3;
    private int columnSize = 3;
    private int winningLimit = 3;
    private int numberOfRounds = 3;

    void setRowSize(int rowSize) throws InvalidSettingException {
        if (rowSize < 3 || rowSize > 30) {
            throw new InvalidSettingException(
                    SoutWrapper.getInstance().getMsgToString(LocalizationKey.BOARD_SIZE_WARNING));
        }
        this.rowSize = rowSize;
    }

    void setColumnSize(int columnSize) throws InvalidSettingException {
        if (columnSize < 3 || columnSize > 30) {
            throw new InvalidSettingException(
                    SoutWrapper.getInstance().getMsgToString(LocalizationKey.BOARD_SIZE_WARNING));
        }
        this.columnSize = columnSize;
    }

    void setWinningLimit(int winningLimit) throws InvalidSettingException {
        int maximumLenght = rowSize > columnSize ? rowSize : columnSize;
        if (winningLimit < 3 || winningLimit > maximumLenght){
            throw new InvalidSettingException(
                    SoutWrapper.getInstance().getMsgToString(LocalizationKey.WINNING_LIMIT_WARNING) + maximumLenght);
        }
        this.winningLimit = winningLimit;
    }

    void setNumberOfRounds(int numberOfRounds) throws InvalidSettingException {
        if (numberOfRounds < 1 || numberOfRounds > 10) {
            throw new InvalidSettingException(
                    SoutWrapper.getInstance().getMsgToString(LocalizationKey.NUMBER_OF_ROUNDS_WARNING));
        }
        this.numberOfRounds = numberOfRounds;
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public int getWinningLimit(){
        return winningLimit;
    }

    public int getNumberOfRounds(){
        return numberOfRounds;
    }

}

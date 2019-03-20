package kamil.rojek.ox.menu;

import kamil.rojek.ox.CustomExceptions.InvalidSettingException;

/**
 * @author Kamil Rojek
 */
public class Settings {
    private int rowSize;
    private int columnSize;
    private int winningLimit;

    void setRowSize(int rowSize) throws InvalidSettingException {
        if (rowSize < 3 || rowSize > 30) {
            throw new InvalidSettingException("Minimum board size 3x3, maximum 30x30!");
        }
        this.rowSize = rowSize;
    }

    void setColumnSize(int columnSize) throws InvalidSettingException {
        if (columnSize < 3 || columnSize > 30) {
            throw new InvalidSettingException("Minimum board size 3x3, maximum 30x30!");
        }
        this.columnSize = columnSize;
    }

    void setWinningLimit(int winningLimit) throws InvalidSettingException {
        int maximumLenght = rowSize > columnSize ? rowSize : columnSize;
        if (winningLimit < 3 || winningLimit > maximumLenght){
            throw new InvalidSettingException("Minimum winning limit should be 3 maximum " + maximumLenght);
        }
        this.winningLimit = winningLimit;
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
}

package kamil.rojek.ox.game;

import kamil.rojek.ox.inputOutput.SoutWrapper;

/**
 * Display changes on board
 * @author Kamil Rojek
 */
class BoardDisplay {
    private Board board;

    BoardDisplay(){
    }

    /**
     *
     * @param board - current board object
     */
    void updateView(Board board){
        this.board = board;
        updateBoard();
    }

    private void updateBoard(){
        int rowCounter = 0;
        int columnCounter = 0;

        System.out.print("\n   ");

        for (int i = 0; i < board.fields[0].length; i++) {
            if (i < 10)
                SoutWrapper.printMsg("  " + columnCounter + " ", true);
            else
                SoutWrapper.printMsg("  " + columnCounter, true);
            columnCounter++;
        }

        System.out.println();
        lineGenerator();

        for (int i = 0; i < board.fields.length; i++) {
            if(i < 10)
                SoutWrapper.printMsg(rowCounter + "  | ",true);
            else
                SoutWrapper.printMsg(rowCounter + " | ", true);
            rowCounter++;

            for (int j = 0; j < board.fields[i].length; j++) {
                System.out.print(board.fields[i][j].type.getValue() + " | ");
            }
            SoutWrapper.printMsg("");
            lineGenerator();
        }
    }

    private void lineGenerator() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");

        for (int i = 0; i <= lineLongCounter(); i++) {
            sb.append("-");
        }
        SoutWrapper.printMsg(sb.toString());
    }

    private int lineLongCounter(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.fields[0].length; i++) {
            sb.append(board.fields[0][i].type.getValue()).append(" | ");
        }

        return sb.toString().length();
    }
}

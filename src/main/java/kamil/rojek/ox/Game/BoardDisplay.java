package kamil.rojek.ox.Game;

//przetestowac
public class BoardDisplay {
    private Board board;

    public BoardDisplay(){
    }

    void updateView(Board board){
        this.board = board;
        updateBoard();
    }

    private void updateBoard(){
        int rowCounter = 0;
        int columnCounter = 0;

        System.out.print("\n   ");

        for (int i = 0; i < board.fields[0].length; i++) {
            System.out.print(" " + columnCounter + "  ");
            columnCounter++;
        }

        System.out.println();
        lineGenerator();

        for (int i = 0; i < board.fields.length; i++) {
            System.out.print(rowCounter + " | ");
            rowCounter++;

            for (int j = 0; j < board.fields[i].length; j++) {
                System.out.print(board.fields[i][j].type.getValue() + " | ");
            }
            System.out.println();
            lineGenerator();
        }
    }

    private void lineGenerator() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");

        for (int i = 0; i <= lineLongCounter(); i++) {
            sb.append("-");
        }

        System.out.println(sb.toString());
    }

    private int lineLongCounter(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.fields[0].length; i++) {
            sb.append(board.fields[0][i].type.getValue() + " | ");
        }

        return sb.toString().length();
    }
}

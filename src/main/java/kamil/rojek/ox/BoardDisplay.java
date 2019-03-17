package kamil.rojek.ox;

public class BoardDisplay {
    private Board board;

    public BoardDisplay(Board board) {
        this.board = board;
    }

    void updateView(){
        updateBoard();
    }

    private void updateBoard(){
        System.out.print("\n   ");
        for (int i = 0; i < board.fields.length; i++) {
            System.out.print(" 1  ");
        }
        System.out.println();
        lineGenerator();

        for (int i = 0; i < board.fields.length; i++) {
            System.out.print("1 | ");
            for (int j = 0; j < board.fields[i].length; j++) {
                board.fields[i][j].type = SeedType.Cross;
                System.out.print(board.fields[i][j].type.getValue() + " | ");
            }
            System.out.println();
            lineGenerator();
        }
    }

    private void lineGenerator() {
        var sb = new StringBuilder();
        for (int i = 0; i <= lineLongCounter(); i++) {
            sb.append("-");
        }

        System.out.println(sb.toString());
    }

    private int lineLongCounter(){
        var sb = new StringBuilder();

        for (int i = 0; i < board.fields[0].length; i++) {
            sb.append(board.fields[0][i].type.getValue() + " | ");
        }

        return sb.toString().length();
    }
}

package kamil.rojek.ox;

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
        System.out.println("Turn move: " + player.toString());
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
            System.out.print("Type number of row: ");
            rowNumber = InputValidator.getIntegerInput();
            System.out.print("Type number of column: ");
            columnNumber = InputValidator.getIntegerInput();

        } while (!gameValidator.validateSeed(rowNumber, columnNumber));

        board.markField(rowNumber, columnNumber, player.getSeedType());
    }
}

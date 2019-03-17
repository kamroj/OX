package kamil.rojek.ox;

import java.util.Scanner;

//to test
public class Round {
    private Player player;
    private int rowNumber = -1;
    private int columnNumber = -1;
    private Board board;

    public Round(Player player) {
        this.player = player;
    }

    void startRound (Board board){
        System.out.println("Turn move: " + player.toString());
        this.board = board;
        takeTurn();
    }

    private void takeTurn(){
        GameValidator gameValidator = new GameValidator(board);
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Type number of row: ");
            rowNumber = getInput(sc);
            System.out.print("Type number of column: ");
            columnNumber = getInput(sc);
            //getRowFromPlayer(sc);
            //getColumnFromPlayer(sc);
        } while (!gameValidator.validateSeed(rowNumber, columnNumber));
//        if(!gameValidator.validateSeed(rowNumber, columnNumber)){
//            takeTurn();
//        } else {
//            board.markField(rowNumber, columnNumber, player.getSeedType());
//        }
        board.markField(rowNumber, columnNumber, player.getSeedType());
    }

    private void getRowFromPlayer(Scanner scanner){
        System.out.print("Type number of row: ");
        while (rowNumber < 0 || rowNumber >= board.fields.length){
            rowNumber = getInput(scanner);
        }
    }

    private void getColumnFromPlayer(Scanner scanner){
        System.out.print("Type number of column: ");
        while (columnNumber < 0 || columnNumber >= board.fields.length){
            columnNumber = getInput(scanner);
        }
    }

    private static int getInput(Scanner scanner){
        while (!scanner.hasNextInt()) {
            System.out.println("Input has to be integer!");
            scanner.next();
        }
        return scanner.nextInt();
    }

}

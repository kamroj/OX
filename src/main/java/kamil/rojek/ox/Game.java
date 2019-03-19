package kamil.rojek.ox;

import kamil.rojek.ox.CustomExceptions.BoardCreatorException;

class Game {
    private Players players;
    private Player player;
    private Board board;

    Game(Players players) {
        this.players = players;
    }

    void startGame(){
        initialize();
        roundFlow();
    }

    private void roundFlow() {
        GameValidator gameValidator = new GameValidator(board);
        BoardDisplay boardDisplay = new BoardDisplay();
        Round round;

        do {
            round = new Round(player);
            boardDisplay.updateView(board);
            round.startRound(board);
            player = players.getNextPlayer();
        } while (!gameValidator.validateWin(round.getLastMarkedRow(), round.getLastMarkedColumn())
                    && !gameValidator.isDraw());

        boardDisplay.updateView(board);

        if (gameValidator.isDraw()) {
            System.out.println("Round has ended with Draw!");
        } else {
            Player winner = round.getLastPlayerOfRound();
            System.out.println("The winner of this round is: " + winner.toString());
        }
    }

    private void initialize() {
        BoardCreator boardCreator = new BoardCreator();

        try {
            board = boardCreator.createNewBoard(3,3);
        }
        catch (BoardCreatorException e) {
            e.printStackTrace();
        }

        player = players.getCurrentPlayer();
    }
}

package kamil.rojek.ox;

import kamil.rojek.ox.CustomExceptions.BoardCreatorException;

public class Game {
    private Players players;
    private Player player;
    private Board board;

    public Game(Players players) {
        this.players = players;
    }

    public void startGame(){
        initialize();
        roundFlow();
    }

    private void roundFlow() {
        GameValidator gameValidator = new GameValidator(board);

        do {
            Round round = new Round(player);
            round.startRound(board);
            player = players.getNextPlayer();
        } while (!gameValidator.validateWin(0, 0));
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

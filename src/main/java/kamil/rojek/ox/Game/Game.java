package kamil.rojek.ox.Game;

import kamil.rojek.ox.CustomExceptions.BoardCreatorException;
import kamil.rojek.ox.InputOutput.SoutWrapper;
import kamil.rojek.ox.menu.Settings;

public class Game implements IGame {
    private IPlayers players;
    private Player player;
    private Board board;
    private Settings settings;

    public Game(IPlayers players, Settings settings) {
        this.players = players;
        this.settings = settings;
    }

    public void startGame(){
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
            SoutWrapper.printMsg("Round has ended with Draw!");
        } else {
            Player winner = round.getLastPlayerOfRound();
            SoutWrapper.printMsg("The winner of this round is: " + winner.toString());
        }
    }

    private void initialize() {
        BoardCreator boardCreator = new BoardCreator();

        try {
            board = boardCreator.createNewBoard(settings.getRowSize(),settings.getColumnSize());
        }
        catch (BoardCreatorException e) {
            e.printStackTrace();
        }

        player = players.getCurrentPlayer();
    }
}

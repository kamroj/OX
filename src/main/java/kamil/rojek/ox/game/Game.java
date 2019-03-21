package kamil.rojek.ox.game;

import kamil.rojek.ox.customExceptions.BoardCreatorException;
import kamil.rojek.ox.inputOutput.LocalizationKey;
import kamil.rojek.ox.inputOutput.SoutWrapper;
import kamil.rojek.ox.menu.MenuDisplay;
import kamil.rojek.ox.menu.Settings;

import java.util.Scanner;

public class Game implements IGame {
    private IPlayers players;
    private Player player;
    private Board board;
    private Settings settings;
    private Scanner scanner;
    private int roundCounter = 0;

    public Game(IPlayers players, Settings settings, Scanner scanner) {
        this.players = players;
        this.settings = settings;
        this.scanner = scanner;
    }

    public void startGame(){
        ScoreBoard scoreBoard = new ScoreBoard(players);

        while (roundCounter != settings.getNumberOfRounds()) {
            initialize();
            roundFlow();
            scoreBoard.printScoreBoard();
            roundCounter++;
        }

        gameEnded();
    }

    private void roundFlow() {
        GameValidator gameValidator = new GameValidator(board, settings.getWinningLimit());
        BoardDisplay boardDisplay = new BoardDisplay();
        Round round;

        do {
            round = new Round(player, scanner);
            boardDisplay.updateView(board);
            round.startRound(board);
            player = players.getNextPlayer();
        } while (!gameValidator.validateWin(round.getLastMarkedRow(), round.getLastMarkedColumn())
                    && !gameValidator.isDraw());

        boardDisplay.updateView(board);

        if (gameValidator.isDraw()) {
            SoutWrapper.getInstance().getMsg(LocalizationKey.ROUND_ENDED_DRAW);
            for (Player player : players.getAllPlayers()) {
                player.addPoint();
            }

        } else {
            Player winner = round.getLastPlayerOfRound();
            winner.addPoint();
            SoutWrapper.getInstance().getMsg(LocalizationKey.ROUND_ENDED_WINNER, winner.toString());
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

    private void gameEnded() {
        MenuDisplay menuDisplay = new MenuDisplay(this, settings, scanner);
        menuDisplay.endingQuery();
    }
}

package kamil.rojek.ox.game;

import kamil.rojek.ox.inputOutput.LocalizationKey;
import kamil.rojek.ox.inputOutput.SoutWrapper;

/**
 * Prints score board based on players
 * @author Kamil Rojek
 */
class ScoreBoard {
    private IPlayers players;

    ScoreBoard(IPlayers players) {
        this.players = players;
    }

    void printScoreBoard() {
        SoutWrapper.getInstance().getMsg(LocalizationKey.SCORE_BOARD_START);

        for (Player player : players.getAllPlayers()){
            SoutWrapper.printMsg(player.toString() + ": " + player.getScore());
        }

        SoutWrapper.getInstance().getMsg(LocalizationKey.SCORE_BOARD_END);
    }
}

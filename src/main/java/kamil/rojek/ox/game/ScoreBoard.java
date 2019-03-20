package kamil.rojek.ox.game;

import kamil.rojek.ox.inputOutput.LocalizationKey;
import kamil.rojek.ox.inputOutput.SoutWrapper;

/**
 * @author Kamil Rojek
 */
class ScoreBoard {
    IPlayers players;

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

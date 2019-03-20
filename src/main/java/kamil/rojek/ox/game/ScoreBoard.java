package kamil.rojek.ox.game;

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
        SoutWrapper.printMsg("\n********** SCOREBOARD **********\n");

        for (Player player : players.getAllPlayers()){
            SoutWrapper.printMsg(player.toString() + ": " + player.getScore());
        }

        System.out.println("\n******** END SCOREBOARD ********\n");
    }
}

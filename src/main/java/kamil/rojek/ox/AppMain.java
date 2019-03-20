package kamil.rojek.ox;

import kamil.rojek.ox.Game.Game;
import kamil.rojek.ox.Game.IPlayers;
import kamil.rojek.ox.Game.Players;

public class AppMain {
    public static void main(String[] args) {
        IPlayers players = new Players();
        Game game = new Game(players);
        game.startGame();
    }
}


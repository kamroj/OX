package kamil.rojek.ox;

import kamil.rojek.ox.Game.Game;
import kamil.rojek.ox.Game.IGame;
import kamil.rojek.ox.Game.Players;

public class AppMain {
    public static void main(String[] args) {
        IGame game = new Game(new Players());
        game.startGame();
    }
}


package kamil.rojek.ox;

import kamil.rojek.ox.Game.Game;
import kamil.rojek.ox.Game.IPlayers;
import kamil.rojek.ox.Game.Players;
import kamil.rojek.ox.menu.MenuDisplay;
import kamil.rojek.ox.menu.Settings;

public class AppMain {
    public static void main(String[] args) {
        IPlayers players = new Players();
//        game.startGame();
        Settings settings = new Settings();
        Game game = new Game(players, settings);
        MenuDisplay menuDisplay = new MenuDisplay(game, settings);
        menuDisplay.initiliazeMenu();
    }
}


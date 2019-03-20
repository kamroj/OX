package kamil.rojek.ox;

import kamil.rojek.ox.game.Game;
import kamil.rojek.ox.game.IPlayers;
import kamil.rojek.ox.game.Players;
import kamil.rojek.ox.menu.MenuDisplay;
import kamil.rojek.ox.menu.Settings;

public class AppMain {
    public static void main(String[] args) {
        IPlayers players = new Players();
        Settings settings = new Settings();
        Game game = new Game(players, settings);
        MenuDisplay menuDisplay = new MenuDisplay(game, settings);
        menuDisplay.initiliazeMenu();
    }
}


package kamil.rojek.ox;

import kamil.rojek.ox.game.Game;
import kamil.rojek.ox.game.IPlayers;
import kamil.rojek.ox.game.Players;
import kamil.rojek.ox.inputOutput.SoutWrapper;
import kamil.rojek.ox.menu.MenuDisplay;
import kamil.rojek.ox.menu.Settings;

import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        IPlayers players = new Players();
        SoutWrapper.getInstance();
        Settings settings = new Settings();
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(players, settings, scanner);
        MenuDisplay menuDisplay = new MenuDisplay(game, settings, scanner);
        menuDisplay.initiliazeMenu();
    }
}


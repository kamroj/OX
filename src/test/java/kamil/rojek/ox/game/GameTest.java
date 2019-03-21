package kamil.rojek.ox.game;

import kamil.rojek.ox.inputOutput.SoutWrapper;
import kamil.rojek.ox.menu.MenuDisplay;
import kamil.rojek.ox.menu.Settings;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;


/**
 * @author Kamil Rojek
 */
public class GameTest {

    @Test
    public void testStartGame() {
        IPlayers players = new Players();
        SoutWrapper.getInstance();
        Settings settings = new Settings();

        Scanner scanner = new Scanner("1 0 0 1 1 1 0 2 2 2 0 0 0 1 1 1 0 2 2 2 0 0 0 1 1 1 0 2 2 2 0 2");
        Game game = new Game(players, settings, scanner);
        MenuDisplay menuDisplay = new MenuDisplay(game, settings, scanner);
        menuDisplay.initiliazeMenu();
    }
}
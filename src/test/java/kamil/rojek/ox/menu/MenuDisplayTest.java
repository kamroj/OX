package kamil.rojek.ox.menu;

import kamil.rojek.ox.game.Game;
import kamil.rojek.ox.game.IPlayers;
import kamil.rojek.ox.game.Players;
import kamil.rojek.ox.inputOutput.SoutWrapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @author Kamil Rojek
 */
public class MenuDisplayTest {
    @Test
    public void testMenuDisplayCreation(){
        //Arrange
        IPlayers players = new Players();
        SoutWrapper.getInstance();
        Settings settings = new Settings();

        Scanner scanner = new Scanner("2 1 3 3 2 3 3 3 4 1 4 2 4 3 5 3 4");
        Game game = new Game(players, settings, scanner);
        MenuDisplay menuDisplay = new MenuDisplay(game, settings);
        Assert.assertNotNull(menuDisplay);

        MenuDisplay menuDisplay1 = new MenuDisplay(game, settings, scanner);

        //Act && Assert
        Assert.assertNotNull(menuDisplay1);
    }

    @Test
    public void testMainMenu() {
        //Arrange
        IPlayers players = new Players();
        SoutWrapper.getInstance();
        Settings settings = new Settings();

        Scanner scanner = new Scanner("2 1 3 3 2 3 3 3 4 1 4 2 4 3 5 3 4");
        Game game = new Game(players, settings, scanner);
        MenuDisplay menuDisplay = new MenuDisplay(game, settings, scanner);

        //Act && Assert
        menuDisplay.initiliazeMenu();
    }
}
package kamil.rojek.ox.game;

import kamil.rojek.ox.inputOutput.SoutWrapper;
import kamil.rojek.ox.menu.MenuDisplay;
import kamil.rojek.ox.menu.Settings;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Kamil Rojek
 */
public class ValidatorFromOutput {

    @Test
    public void testValidatorFromOutput() throws IOException {
        FileReader fileReader = new FileReader("WinValidatorTestCase");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains("//"))
                continue;
            sb.append(line + " ");
        }

        IPlayers players = new Players();
        SoutWrapper.getInstance();
        Settings settings = new Settings();

        Scanner scanner = new Scanner(sb.toString());
        Game game = new Game(players, settings, scanner);
        MenuDisplay menuDisplay = new MenuDisplay(game, settings, scanner);
        menuDisplay.initiliazeMenu();
    }

}

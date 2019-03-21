package kamil.rojek.ox;

import kamil.rojek.ox.game.Game;
import kamil.rojek.ox.game.IPlayers;
import kamil.rojek.ox.game.Players;
import kamil.rojek.ox.inputOutput.SoutWrapper;
import kamil.rojek.ox.menu.MenuDisplay;
import kamil.rojek.ox.menu.Settings;

import java.io.*;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) throws IOException {
        if(args.length == 1) {
            File file = new File(args[0]);
            FileReader fileReader = new FileReader(file);
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
        } else {

            IPlayers players = new Players();
            SoutWrapper.getInstance();
            Settings settings = new Settings();
            Scanner scanner = new Scanner(System.in);
            Game game = new Game(players, settings, scanner);
            MenuDisplay menuDisplay = new MenuDisplay(game, settings, scanner);
            menuDisplay.initiliazeMenu();
        }
    }
}


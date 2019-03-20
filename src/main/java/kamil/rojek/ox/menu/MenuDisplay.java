package kamil.rojek.ox.menu;

import kamil.rojek.ox.Game.IGame;
import kamil.rojek.ox.InputOutput.InputValidator;
import kamil.rojek.ox.InputOutput.SoutWrapper;

/**
 * @author Kamil Rojek
 */
public class MenuDisplay {
    IGame game;
    Settings settings;

    public MenuDisplay(IGame game, Settings settings) {
        this.game = game;
        this.settings = settings;
    }

    public void initiliazeMenu() {
        SettingsDisplay settingsDisplay = new SettingsDisplay();

        switch (menuSelector()){
            case 1:
                game.startGame();
                break;
            case 2:
                settingsDisplay.initiliazeSettings(settings);
            case 3:
                System.exit(0);
        }
    }

    private int menuSelector() {
        int selection;

        SoutWrapper.printMsg("Select one from this options.");
        SoutWrapper.printMsg("-------------------------");
        SoutWrapper.printMsg("1 - Start game");
        SoutWrapper.printMsg("2 - Options");
        SoutWrapper.printMsg("3 - Quit");
        SoutWrapper.printMsg("-------------------------");

        do {
            selection = InputValidator.getIntegerInput();
        } while (selection <= 0 || selection >= 4);

        return selection;
    }


}

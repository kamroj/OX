package kamil.rojek.ox.menu;

import kamil.rojek.ox.CustomExceptions.InvalidSettingException;
import kamil.rojek.ox.Game.IGame;
import kamil.rojek.ox.InputOutput.InputValidator;
import kamil.rojek.ox.InputOutput.SoutWrapper;

/**
 * @author Kamil Rojek
 */
public class MenuDisplay {
    private IGame game;
    private Settings settings;

    public MenuDisplay(IGame game, Settings settings) {
        this.game = game;
        this.settings = settings;
    }

    public void initiliazeMenu() {
        switch (menuSelector()){
            case 1:
                game.startGame();
                break;
            case 2:
                initiliazeSettings();
                break;
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


    private void initiliazeSettings() {

        switch (optionsSelector()){
            case 1:
                changeBoardSize();
                break;
            case 2:
                changeWinningLimitSize();
                break;
            case 3:
                initiliazeMenu();
        }
    }

    private int optionsSelector() {
        int selection;

        SoutWrapper.printMsg("Select one from this options.");
        SoutWrapper.printMsg("-------------------------");
        SoutWrapper.printMsg("1 - Change board size");
        SoutWrapper.printMsg("2 - Change winning limit");
        SoutWrapper.printMsg("3 - Go to main menu");
        SoutWrapper.printMsg("-------------------------");

        do {
            selection = InputValidator.getIntegerInput();
        } while (selection <= 0 || selection >= 4);

        return selection;
    }

    void changeBoardSize() {
        boolean success = false;
        while (!success) {
            try {
                SoutWrapper.printMsg("Set row size: ");
                settings.setRowSize(InputValidator.getIntegerInput());
                SoutWrapper.printMsg("Set column size: ");
                settings.setColumnSize(InputValidator.getIntegerInput());
                success = true;
            } catch (InvalidSettingException e) {
                SoutWrapper.printMsg(e.getMessage());
            }
        }

        initiliazeSettings();
    }

    void changeWinningLimitSize() {
        boolean success = false;
        while (!success) {
            try {
                SoutWrapper.printMsg("Set winning limit: ");
                settings.setWinningLimit(InputValidator.getIntegerInput());
                success = true;
            } catch (InvalidSettingException e) {
                SoutWrapper.printMsg(e.getMessage());
            }
        }

        initiliazeSettings();
    }

}

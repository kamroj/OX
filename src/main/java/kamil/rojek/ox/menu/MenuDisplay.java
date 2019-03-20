package kamil.rojek.ox.menu;

import kamil.rojek.ox.customExceptions.InvalidSettingException;
import kamil.rojek.ox.game.IGame;
import kamil.rojek.ox.inputOutput.InputValidator;
import kamil.rojek.ox.inputOutput.SoutWrapper;

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

    public void endingQuery() {
        switch (endingSelector()){
            case 1:
                initiliazeMenu();
                break;
            case 2:
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
                changeNumberOfRounds();
                break;
            case 4:
                initiliazeMenu();
        }
    }

    private int optionsSelector() {
        int selection;

        SoutWrapper.printMsg("Select one from this options.");
        SoutWrapper.printMsg("-------------------------");
        SoutWrapper.printMsg("1 - Change board size");
        SoutWrapper.printMsg("2 - Change winning limit");
        SoutWrapper.printMsg("3 - Change number of rounds");
        SoutWrapper.printMsg("4 - Go to main menu");
        SoutWrapper.printMsg("-------------------------");

        do {
            selection = InputValidator.getIntegerInput();
        } while (selection <= 0 || selection >= 5);

        return selection;
    }

    private void changeBoardSize() {
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

    private void changeWinningLimitSize() {
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

    private void changeNumberOfRounds() {
        boolean success = false;
        while (!success) {
            try {
                SoutWrapper.printMsg("Set number of rounds: ");
                settings.setNumberOfRounds(InputValidator.getIntegerInput());
                success = true;
            } catch (InvalidSettingException e) {
                SoutWrapper.printMsg(e.getMessage());
            }
        }

        initiliazeSettings();
    }

    private int endingSelector() {
        int selection;

        SoutWrapper.printMsg("game has ended.");
        SoutWrapper.printMsg("-------------------------");
        SoutWrapper.printMsg("1 - Back to main menu");
        SoutWrapper.printMsg("2 - Quit");
        SoutWrapper.printMsg("-------------------------");

        do {
            selection = InputValidator.getIntegerInput();
        } while (selection <= 0 || selection >= 2);

        return selection;
    }

}

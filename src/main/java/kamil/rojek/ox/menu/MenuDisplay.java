package kamil.rojek.ox.menu;

import kamil.rojek.ox.customExceptions.InvalidSettingException;
import kamil.rojek.ox.game.IGame;
import kamil.rojek.ox.inputOutput.InputValidator;
import kamil.rojek.ox.inputOutput.Language;
import kamil.rojek.ox.inputOutput.LocalizationKey;
import kamil.rojek.ox.inputOutput.SoutWrapper;

import java.util.Scanner;

/**
 * @author Kamil Rojek
 */
public class MenuDisplay {
    private IGame game;
    private Settings settings;
    private InputValidator inputValidator;

    public MenuDisplay(IGame game, Settings settings) {
        this.game = game;
        this.settings = settings;
        inputValidator = new InputValidator(new Scanner(System.in));
    }

    public MenuDisplay(IGame game, Settings settings, Scanner scanner) {
        this.game = game;
        this.settings = settings;
        inputValidator = new InputValidator(scanner);
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
                SoutWrapper.getInstance().getMsg(LocalizationKey.INFO_ABOUT_GAME);
                initiliazeMenu();
                break;
            case 4:
                SoutWrapper.getInstance().getMsg(LocalizationKey.GOODBYE_MSG);
                break;
        }
    }

    public void endingQuery() {
        switch (endingSelector()){
            case 1:
                initiliazeMenu();
                break;
            case 2:
                SoutWrapper.getInstance().getMsg(LocalizationKey.GOODBYE_MSG);
                break;
        }
    }

    private int menuSelector() {
        int selection;

        SoutWrapper.getInstance().getMsg(LocalizationKey.MENU_INFO);
        SoutWrapper.printMsg("-------------------------");
        SoutWrapper.getInstance().getMsg(LocalizationKey.START_GAME);
        SoutWrapper.getInstance().getMsg(LocalizationKey.OPTIONS);
        SoutWrapper.getInstance().getMsg(LocalizationKey.INFO_MSG);
        SoutWrapper.getInstance().getMsg(LocalizationKey.QUIT);
        SoutWrapper.printMsg("-------------------------");

        do {
            selection = inputValidator.getIntegerInput();
        } while (selection < 1 || selection > 4);

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
                initializeChangingLanguage();
                break;
            case 5:
                initiliazeMenu();
        }
    }

    private void initializeChangingLanguage() {
        SoutWrapper soutWrapper = SoutWrapper.getInstance();

        switch (changeLanguage()){
            case 1:
                soutWrapper.changeLanguageBundle(Language.POLISH);
                initiliazeSettings();
                break;
            case 2:
                soutWrapper.changeLanguageBundle(Language.ENGLISH);
                initiliazeSettings();
                break;
            case 3:
                initiliazeSettings();
                break;
        }
    }

    private int optionsSelector() {
        int selection;

        SoutWrapper.getInstance().getMsg(LocalizationKey.MENU_INFO);
        SoutWrapper.printMsg("-------------------------");
        SoutWrapper.getInstance().getMsg(LocalizationKey.CHANGE_BOARD_SIZE);
        SoutWrapper.getInstance().getMsg(LocalizationKey.CHANGE_WINNING_LIMIT);
        SoutWrapper.getInstance().getMsg(LocalizationKey.CHANGE_NUMBER_ROUNDS);
        SoutWrapper.getInstance().getMsg(LocalizationKey.CHANGE_LANGUAGE);
        SoutWrapper.getInstance().getMsg(LocalizationKey.GO_MAIN_MENU);
        SoutWrapper.printMsg("-------------------------");

        do {
            selection = inputValidator.getIntegerInput();
        } while (selection < 1 || selection > 5);

        return selection;
    }

    private void changeBoardSize() {
        boolean success = false;
        while (!success) {
            try {
                SoutWrapper.getInstance().getMsg(LocalizationKey.SET_ROW_SIZE_INFO);
                settings.setRowSize(inputValidator.getIntegerInput());
                SoutWrapper.getInstance().getMsg(LocalizationKey.SET_COLUMN_SIZE_INFO);
                settings.setColumnSize(inputValidator.getIntegerInput());
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
                SoutWrapper.getInstance().getMsg(LocalizationKey.SET_WINNING_LIMIT_INFO);
                settings.setWinningLimit(inputValidator.getIntegerInput());
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
                SoutWrapper.getInstance().getMsg(LocalizationKey.SET_NUMBER_OF_ROUNDS_INFO);
                settings.setNumberOfRounds(inputValidator.getIntegerInput());
                success = true;
            } catch (InvalidSettingException e) {
                SoutWrapper.printMsg(e.getMessage());
            }
        }

        initiliazeSettings();
    }

    private int endingSelector() {
        int selection;

        SoutWrapper.getInstance().getMsg(LocalizationKey.GAME_ENDED_INFO);
        SoutWrapper.printMsg("-------------------------");
        SoutWrapper.getInstance().getMsg(LocalizationKey.GO_MENU_ENDING_QUERY);
        SoutWrapper.getInstance().getMsg(LocalizationKey.QUIT_ENDING_QUERY);
        SoutWrapper.printMsg("-------------------------");

        do {
            selection = inputValidator.getIntegerInput();
        } while (selection < 1 || selection > 2);

        return selection;
    }

    private int changeLanguage(){
        int selection;

        SoutWrapper.printMsg("-------------------------");
        SoutWrapper.getInstance().getMsg(LocalizationKey.POLISH_LANGUAGE);
        SoutWrapper.getInstance().getMsg(LocalizationKey.ENGLISH_LANGUAGE);
        SoutWrapper.getInstance().getMsg(LocalizationKey.GO_SETTINGS);
        SoutWrapper.printMsg("-------------------------");

        do {
            selection = inputValidator.getIntegerInput();
        } while (selection < 1 || selection > 3);

        return selection;
    }
}

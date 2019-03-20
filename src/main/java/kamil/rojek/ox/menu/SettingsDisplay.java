package kamil.rojek.ox.menu;

import kamil.rojek.ox.InputOutput.InputValidator;
import kamil.rojek.ox.InputOutput.SoutWrapper;

/**
 * @author Kamil Rojek
 */
public class SettingsDisplay {
    Settings settings;

    public void initiliazeSettings(Settings settings) {
        switch (optionsSelector()){
            case 1:
                break;
            case 2:
                SoutWrapper.printMsg("Not working yet!");
            case 3:
                System.exit(0);
        }
    }

    private int optionsSelector() {
        int selection;

        SoutWrapper.printMsg("Select one from this options.");
        SoutWrapper.printMsg("-------------------------");
        SoutWrapper.printMsg("1 - Change board size");
        SoutWrapper.printMsg("2 - Go to main menu");
        SoutWrapper.printMsg("-------------------------");

        do {
            selection = InputValidator.getIntegerInput();
        } while (selection <= 0 || selection >= 3);

        return selection;
    }

    private void changeBoardSize() {
    }
}

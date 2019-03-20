//package kamil.rojek.ox.menu;
//
//import kamil.rojek.ox.customExceptions.InvalidSettingException;
//import kamil.rojek.ox.inputOutput.InputValidator;
//import kamil.rojek.ox.inputOutput.SoutWrapper;
//
///**
// * @author Kamil Rojek
// */
//public class SettingsDisplay {
//    Settings settings;
//
//    public SettingsDisplay(Settings settings) {
//        this.settings = settings;
//    }
//
//    public void initiliazeSettings() {
//
//        switch (optionsSelector()){
//            case 1:
//                changeBoardSize();
//                break;
//            case 2:
//
//            case 3:
//                ;
//        }
//    }
//
//    private int optionsSelector() {
//        int selection;
//
//        SoutWrapper.printMsg("Select one from this options.");
//        SoutWrapper.printMsg("-------------------------");
//        SoutWrapper.printMsg("1 - Change board size");
//        SoutWrapper.printMsg("2 - Go to main menu");
//        SoutWrapper.printMsg("-------------------------");
//
//        do {
//            selection = InputValidator.getIntegerInput();
//        } while (selection <= 0 || selection >= 3);
//
//        return selection;
//    }
//
//    void changeBoardSize() {
//        boolean success = false;
//        while (!success) {
//            try {
//                settings.setRowSize(InputValidator.getIntegerInput());
//                settings.setColumnSize(InputValidator.getIntegerInput());
//                success = true;
//            } catch (InvalidSettingException e) {
//                SoutWrapper.printMsg(e.getMessage());
//            }
//        }
//
//        initiliazeSettings();
//    }
//}

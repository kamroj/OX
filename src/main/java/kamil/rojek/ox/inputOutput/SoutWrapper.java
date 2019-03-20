package kamil.rojek.ox.inputOutput;

import java.io.PrintStream;
import java.util.ResourceBundle;

/**
 * @author Kamil Rojek
 */
public class SoutWrapper {
    private static SoutWrapper instance;
    private static ResourceBundle bundle;

    private SoutWrapper(){}

    public static SoutWrapper getInstance() {
        if(instance == null) {
            instance = new SoutWrapper();
            bundle = TextLocalizator.setBundle(Language.ENGLISH);
        }
        return instance;
    }

    public void changeLanguageBundle(Language language){
        bundle = TextLocalizator.setBundle(language);
    }

    public void getMsg(LocalizationKey key){
        System.out.println(bundle.getString(key.name()));
    }

    public void getMsg(LocalizationKey key, String additionalMsg){
        System.out.println(bundle.getString(key.name()) + additionalMsg);
    }

    public void getMsg(LocalizationKey key, boolean oneline){
        System.out.print(bundle.getString(key.name()));
    }

    public String getMsgToString(LocalizationKey key){
        return bundle.getString(key.name());
    }

    public static void printMsg(String msg) {
        if (msg == null) {
            throw new IllegalArgumentException("Invalid input argument");
        }

        System.out.println(msg);
    }

    public static void printMsg(String msg, boolean oneLine) {
        if (msg == null) {
            throw new IllegalArgumentException("Invalid input argument");
        }

        if (oneLine) {
            System.out.print(msg);
        } else {
            System.out.println(msg);
        }
    }

    public static void printMsg(String msg, PrintStream stream) {
        if (msg == null) {
            throw new IllegalArgumentException("Invalid input argument");
        }

        System.setOut(stream);
        System.out.println(msg);
    }
}

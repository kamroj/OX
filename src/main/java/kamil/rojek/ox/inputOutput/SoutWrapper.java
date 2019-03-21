package kamil.rojek.ox.inputOutput;

import java.io.PrintStream;
import java.util.ResourceBundle;

/**
 * Wrapper for printing messages. Singleton
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

    /**
     *
     * @param language language type
     */
    public void changeLanguageBundle(Language language){
        bundle = TextLocalizator.setBundle(language);
    }


    /**
     * get message from resource bundle
     * @param key enum parameter from LocalizationKey
     */
    public void getMsg(LocalizationKey key){
        System.out.println(bundle.getString(key.name()));
    }

    /**
     * get message from resource bundle + any other String
     * @param key enum parameter from LocalizationKey
     * @param additionalMsg String
     */
    public void getMsg(LocalizationKey key, String additionalMsg){
        System.out.println(bundle.getString(key.name()) + additionalMsg);
    }

    /**
     * get message from resource bundle and print it as one line
     * @param key enum parameter from LocalizationKey
     * @param oneline true if one line, false in line with \n at the end
     */
    public void getMsg(LocalizationKey key, boolean oneline){
        System.out.print(bundle.getString(key.name()));
    }

    /**
     * pack message to String from resource bundle
     * @param key enum parameter from LocalizationKey
     * @return String
     */
    public String getMsgToString(LocalizationKey key){
        return bundle.getString(key.name());
    }

    /**
     * Print message
     * @param msg String
     */
    public static void printMsg(String msg) {
        if (msg == null) {
            throw new IllegalArgumentException("Invalid input argument");
        }

        System.out.println(msg);
    }

    /**
     * Print message
     * @param msg String
     * @param oneLine one line if true, line with \n at the and if false
     */
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

    /**
     * Print message
     * @param msg String
     * @param stream PrintStream param. Can be change to out or in.
     */
    public static void printMsg(String msg, PrintStream stream) {
        if (msg == null) {
            throw new IllegalArgumentException("Invalid input argument");
        }

        System.setOut(stream);
        System.out.println(msg);
    }
}

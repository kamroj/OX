package kamil.rojek.ox.inputOutput;

import java.util.Locale;
import java.util.ResourceBundle;

class TextLocalizator {

    static ResourceBundle setBundle(Language language) {
        return createBundle(language);
    }

    private static ResourceBundle createBundle(Language language) {
        switch (language){
            case ENGLISH:
                return ResourceBundle.getBundle("OX", new Locale("eng", "ENG"));
            case POLISH:
                return ResourceBundle.getBundle("OX", new Locale("pl", "PL"));
            default:
                return ResourceBundle.getBundle("OX", new Locale("eng", "ENG"));
        }
    }
}
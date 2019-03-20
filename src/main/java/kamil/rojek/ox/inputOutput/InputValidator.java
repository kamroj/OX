package kamil.rojek.ox.inputOutput;

import java.util.Scanner;

/**
 * @author Kamil Rojek
 */
public class InputValidator {
    //private Scanner scanner;

//    public InputValidator(Scanner scanner) {
//        this.scanner = scanner;
//    }

    public static int getIntegerInput(){
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextInt()) {
            SoutWrapper.getInstance().getMsg(LocalizationKey.INTEGER_INPUT_WARNING);
            scanner.next();
        }
        return scanner.nextInt();
    }
}

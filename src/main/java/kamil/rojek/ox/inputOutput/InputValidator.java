package kamil.rojek.ox.inputOutput;

import java.util.Scanner;

/**
 * @author Kamil Rojek
 */
public class InputValidator {
    private Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * get input from player which is validated
     * @return int
     */
    public int getIntegerInput(){
        while (!scanner.hasNextInt()) {
            if(scanner.hasNext("quit")){
                SoutWrapper.getInstance().getMsg(LocalizationKey.GOODBYE_MSG);
                System.exit(0);
            }
            SoutWrapper.getInstance().getMsg(LocalizationKey.INTEGER_INPUT_WARNING);
            scanner.next();
        }
        return scanner.nextInt();
    }
}

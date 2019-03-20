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

    public int getIntegerInput(){
        while (!scanner.hasNextInt()) {
            System.out.println("Input has to be integer!");
            scanner.next();
        }
        return scanner.nextInt();
    }
}

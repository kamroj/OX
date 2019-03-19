package kamil.rojek.ox.Game;

import java.util.Scanner;

/**
 * @author Kamil Rojek
 */
public class InputValidator {
    private static Scanner scanner;

    static int getIntegerInput(){
        scanner = new Scanner(System.in);

        while (!scanner.hasNextInt()) {
            System.out.println("Input has to be integer!");
            scanner.next();
        }
        return scanner.nextInt();
    }
}

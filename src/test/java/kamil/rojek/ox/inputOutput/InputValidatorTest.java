package kamil.rojek.ox.inputOutput;

import org.testng.annotations.Test;

import java.util.Scanner;

import static org.testng.Assert.*;

/**
 * @author Kamil Rojek
 */
public class InputValidatorTest {

    @Test
    public void testGetIntegerValidInput() {
        Scanner scanner = new Scanner("1");
        InputValidator inputValidator = new InputValidator(scanner);
        System.out.println(inputValidator.ge);
    }
}
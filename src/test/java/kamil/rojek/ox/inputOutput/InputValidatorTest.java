package kamil.rojek.ox.inputOutput;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;

import static org.testng.Assert.*;

/**
 * @author Kamil Rojek
 */
public class InputValidatorTest {

    @Test
    public void testInputValidatorCreate(){
        //Assert
        assertNotNull(new InputValidator(new Scanner(System.in)));
    }

    @DataProvider
    public static Object[][] dataValidInputs(){
        return new Object[][] {
            {"1",1},{"123",123},{"414",414},{"22",22},{"32",32},
            {"0",0},{"231",231},{"4214",4214},{"321",321},{"2",2}
        };
    }

    @Test(dataProvider = "dataValidInputs")
    public void testGetIntegerValidInput(String input, int result) {
        //Arrange
        Scanner scanner = new Scanner(input);
        InputValidator inputValidator = new InputValidator(scanner);

        //Act && Assert
        Assert.assertEquals(inputValidator.getIntegerInput(), result);
    }
}
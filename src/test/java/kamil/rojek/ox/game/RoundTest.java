package kamil.rojek.ox.game;

import kamil.rojek.ox.customExceptions.PlayerSeedTypeException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoundTest {

    @Test
    public void testRoundObjectIfItsNotNull() throws PlayerSeedTypeException {
        //Arrange
        Round round = new Round(new Player("Kamil", SeedType.Cross));

        //Assert
        Assert.assertNotNull(round);
    }
}

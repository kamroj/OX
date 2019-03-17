package kamil.rojek.ox;

import kamil.rojek.ox.CustomExceptions.PlayerSeedTypeException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoundTest {

    @Test
    public void testRoundObjectIfItsNotNull() throws PlayerSeedTypeException {
        Round round = new Round(new Player("Kamil", SeedType.Cross));
        Assert.assertNotNull(round);
    }

    @Test
    public void test(){

    }
}

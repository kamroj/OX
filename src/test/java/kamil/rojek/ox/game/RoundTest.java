package kamil.rojek.ox.game;

import kamil.rojek.ox.customExceptions.PlayerSeedTypeException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoundTest {

    @Test
    public void testRoundObjectIfItsNotNull() throws PlayerSeedTypeException {
        Round round = new Round(new Player("Kamil", SeedType.Cross));
        Assert.assertNotNull(round);
    }

    @Test
    public void testGetLastMarkedRow() throws PlayerSeedTypeException {
        Player player = new Player("Kamil", SeedType.Cross);
        Round round = new Round(player);

    }
}

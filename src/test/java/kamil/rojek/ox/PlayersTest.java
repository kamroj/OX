package kamil.rojek.ox;

import kamil.rojek.ox.CustomExceptions.PlayerSeedTypeException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlayersTest {

    Players players;

    @BeforeMethod
    public void setUp(){
        players = new Players();
    }

    @Test
    public void testCreatingPlayersObject(){
        Players players = new Players();
    }

    @Test
    public void testNumberOfPlayersShouldBeEqualTwo(){
        Assert.assertTrue(players.getAllPlayers() == 2);
    }

    @Test
    public void testGetCurrentPlayer() throws PlayerSeedTypeException {
        Player excpectedPlayer = new Player("Kamil", SeedType.Cross);
        Assert.assertTrue(players.getCurrentPlayer().equals(excpectedPlayer));
    }

    @DataProvider
    public static Object[][] dataGetNextPlayer() throws PlayerSeedTypeException {
        return new Object[][]{
            {1, new Player("Monika", SeedType.Nought)},{2, new Player("Kamil", SeedType.Cross)},
            {3, new Player("Monika", SeedType.Nought)},{4, new Player("Kamil", SeedType.Cross)},
            {13, new Player("Monika", SeedType.Nought)},{10, new Player("Kamil", SeedType.Cross)},
            {21, new Player("Monika", SeedType.Nought)},{20, new Player("Kamil", SeedType.Cross)},
        };
    }

    @Test(dataProvider = "dataGetNextPlayer")
    public void testGetNextPlayer(int numberOfSwitches, Player excpectedPlayer) throws PlayerSeedTypeException {
        Player player = null;
        for (int i = 0; i < numberOfSwitches; i++) {
            player = players.getNextPlayer();
        }
        Assert.assertTrue(player.equals(excpectedPlayer));
    }
}

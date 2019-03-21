package kamil.rojek.ox.game;

import kamil.rojek.ox.customExceptions.PlayerSeedTypeException;
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
        //Act && Assert
        Assert.assertNotNull(players);
    }

    @Test
    public void testNumberOfPlayersShouldBeEqualTwo(){
        //Act && Assert
        Assert.assertTrue(players.getAllPlayers().size() == 2);
    }

    @Test
    public void testGetCurrentPlayer() throws PlayerSeedTypeException {
        //Arrange
        Player excpectedPlayer = new Player("Player 1", SeedType.Cross);

        //Act && Assert
        Assert.assertEquals(excpectedPlayer, players.getCurrentPlayer());
    }

    @DataProvider
    public static Object[][] dataGetNextPlayer() throws PlayerSeedTypeException {
        return new Object[][]{
            {1, new Player("Player 2", SeedType.Nought)},{2, new Player("Player 1", SeedType.Cross)},
            {3, new Player("Player 2", SeedType.Nought)},{4, new Player("Player 1", SeedType.Cross)},
            {13, new Player("Player 2", SeedType.Nought)},{10, new Player("Player 1", SeedType.Cross)},
            {21, new Player("Player 2", SeedType.Nought)},{20, new Player("Player 1", SeedType.Cross)},
        };
    }

    @Test(dataProvider = "dataGetNextPlayer")
    public void testGetNextPlayer(int numberOfSwitches, Player excpectedPlayer) throws PlayerSeedTypeException {
        //Arrange
        Player player = null;
        for (int i = 0; i < numberOfSwitches; i++) {
            player = players.getNextPlayer();
        }

        //Act && Assert
        Assert.assertEquals(excpectedPlayer, player);
    }
}

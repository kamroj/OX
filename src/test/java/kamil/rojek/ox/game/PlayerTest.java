package kamil.rojek.ox.game;

import kamil.rojek.ox.customExceptions.PlayerSeedTypeException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlayerTest {

    @Test
    public void testCreatingPlayer() throws PlayerSeedTypeException {
        //Arrange
        Player player = new Player("Kamil", SeedType.Cross);

        //Assert
        Assert.assertNotNull(player);
    }

    @DataProvider
    public static Object[][] dataPlayerSeedTypes() throws PlayerSeedTypeException {
        return new Object[][]{
            {new Player("a", SeedType.Cross), SeedType.Cross, true},
            {new Player("a", SeedType.Nought), SeedType.Nought, true},
            {new Player("a", SeedType.Cross), SeedType.Nought, false}
        };
    }

    @Test(dataProvider = "dataPlayerSeedTypes")
    public void testSeedTypesOfPlayer(Player player, SeedType expectedSeedType, boolean result){
        //Assert
        Assert.assertEquals(player.getSeedType().equals(expectedSeedType), result);
    }

    @DataProvider
    public static Object[][] dataPlayerToString() throws PlayerSeedTypeException {
        return new Object[][]{
            {new Player("Kamil", SeedType.Cross), "Kamil (X)"},
            {new Player("a", SeedType.Cross), "a (X)"},
            {new Player("Monia moja żona", SeedType.Nought), "Monia moja żona (O)"},
            {new Player("Kamil jej mąż", SeedType.Cross), "Kamil jej mąż (X)"},
        };
    }

    @Test(dataProvider = "dataPlayerToString")
    public void testPlayerToString(Player player, String playerToStringResult){
        //Assert
        Assert.assertEquals(playerToStringResult, player.toString());
    }

    @DataProvider
    public static Object[][] dataAddingScoresToPlayer(){
        return new Object[][]{
            {1,1},{2,2},{3,3},{4,4},
            {12,12},{15,15},{13,13},{16,16}
        };
    }

    @Test(dataProvider = "dataAddingScoresToPlayer")
    public void testAddingPointsToPlayer(int addScoreCounter, int scoreResult) throws PlayerSeedTypeException {
        //Arrange
        Player player = new Player("Kamil", SeedType.Cross);

        //Act
        for (int i = 0; i < addScoreCounter; i++) {
            player.addPoint();
        }

        //Assert
        Assert.assertTrue(player.getScore() == scoreResult);
    }

    @Test(expectedExceptions = PlayerSeedTypeException.class)
    public void testNoneSeedTypeCannotBeInitiliazedAsPlayerSeed() throws PlayerSeedTypeException {
        Player player = new Player("Kamil", SeedType.None);
        //Arrange && Act
        new Player("Kamil", SeedType.None);
    }

    @Test(expectedExceptions = PlayerSeedTypeException.class)
    public void testNullSeedTypeCannotBeInitiliazedAsPlayerSeed() throws PlayerSeedTypeException {
        //Arrange && Act
        new Player("Kamil", null);
    }
}

package kamil.rojek.ox;

import kamil.rojek.ox.CustomExceptions.PlayerSeedTypeException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlayerTest {

    @Test
    public void testCreatingPlayer() throws PlayerSeedTypeException {
        Player player = new Player("Kamil", SeedType.Cross);
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
        Assert.assertEquals(player.getSeedType().equals(expectedSeedType), result);
    }

    @DataProvider
    public static Object[][] dataPlayerToString() throws PlayerSeedTypeException {
        return new Object[][]{
            {new Player("Kamil", SeedType.Cross), "Player name: Kamil SeedType: Cross"},
            {new Player("a", SeedType.Cross), "Player name: a SeedType: Cross"},
            {new Player("Monia moja żona", SeedType.Nought), "Player name: Monia moja żona SeedType: Nought"},
            {new Player("Kamil jej mąż", SeedType.Cross), "Player name: Kamil jej mąż SeedType: Cross"},
        };
    }

    @Test(dataProvider = "dataPlayerToString")
    public void testPlayerToString(Player player, String playerToStringResult){
        Assert.assertTrue(player.toString().equals(playerToStringResult));
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
        Player player = new Player("Kamil", SeedType.Cross);

        for (int i = 0; i < addScoreCounter; i++) {
            player.addPoint();
        }

        Assert.assertTrue(player.getScore() == scoreResult);
    }

    @Test(expectedExceptions = PlayerSeedTypeException.class)
    public void testNoneSeedTypeCannotBeInitiliazedAsPlayerSeed() throws PlayerSeedTypeException {
        Player player = new Player("Kamil", SeedType.None);
    }

    @Test(expectedExceptions = PlayerSeedTypeException.class)
    public void testNullSeedTypeCannotBeInitiliazedAsPlayerSeed() throws PlayerSeedTypeException {
        Player player = new Player("Kamil", null);
    }
}

package kamil.rojek.ox.Game;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Kamil Rojek
 */
public class SeedTest {

    @Test
    public void testSeedNoneType(){
        Seed seed = new Seed(SeedType.None);
        Assert.assertEquals(seed.type, SeedType.None);
    }

    @Test
    public void testSeedNoughtType(){
        Seed seed = new Seed(SeedType.Nought);
        Assert.assertEquals(seed.type, SeedType.Nought);
    }

    @Test
    public void testSeedCrossType(){
        Seed seed = new Seed(SeedType.Cross);
        Assert.assertEquals(seed.type, SeedType.Cross);
    }

    @DataProvider
    public static Object[][] incorrectDataForSeedTypes(){
        return new Object[][] {
            {SeedType.Cross,SeedType.Nought},
            {SeedType.Cross,SeedType.None},
            {SeedType.Nought,SeedType.None}
        };
    }

    @Test(dataProvider = "incorrectDataForSeedTypes")
    public void testSeedIncorectTypes(SeedType type, SeedType expectedType){
        Seed seed = new Seed(type);
        Assert.assertNotEquals(seed.type, expectedType);
    }
}

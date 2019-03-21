package kamil.rojek.ox.game;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Kamil Rojek
 */
public class SeedTest {

    @Test
    public void testSeedNoneType(){
        //Arrange
        Seed seed = new Seed(SeedType.None);

        //Assert
        Assert.assertEquals(seed.type, SeedType.None);
    }

    @Test
    public void testSeedNoughtType(){
        //Arrange
        Seed seed = new Seed(SeedType.Nought);

        //Assert
        Assert.assertEquals(seed.type, SeedType.Nought);
    }

    @Test
    public void testSeedCrossType(){
        //Arrange
        Seed seed = new Seed(SeedType.Cross);

        //Assert
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
        //Arrange
        Seed seed = new Seed(type);

        //Assert
        Assert.assertFalse(seed.type.equals(expectedType));
    }
}

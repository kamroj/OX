package kamil.rojek.ox.menu;

import kamil.rojek.ox.customExceptions.InvalidSettingException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Kamil Rojek
 */
public class SettingsTest {

    Settings settings;

    @BeforeMethod
    private void setUp(){
        settings = new Settings();
    }

    @DataProvider
    public static Object[][] dataSettingRow(){
        return new Object[][] {
            {3,3},{4,4},{6,6},
            {22,22},{12,12},{22,22},
            {16,16},{30,30},{13,13},
            {12,12},{29,29},{30,30}
        };
    }
    @Test(dataProvider = "dataSettingRow")
    public void testSetRowSize(int rowSize, int result) throws InvalidSettingException {
        settings.setRowSize(rowSize);
        Assert.assertEquals(settings.getRowSize(), result);
    }

    @DataProvider
    public static Object[][] dataSettingColumn(){
        return new Object[][] {
                {3,3},{4,4},{6,6},
                {22,22},{12,12},{22,22},
                {16,16},{30,30},{13,13},
                {12,12},{29,29},{30,30}
        };
    }

    @Test(dataProvider = "dataSettingColumn")
    public void testSetColumnSize(int columnSize, int result) throws InvalidSettingException {
        settings.setColumnSize(columnSize);
        Assert.assertEquals(settings.getColumnSize(), result);
    }


    @DataProvider
    public static Object[][] dataInvalidSettingRow(){
        return new Object[][] {
                {2},{1},{0},
                {-2},{-1},{-0},
                {-52},{-11},{-10}
        };
    }
    @Test(dataProvider = "dataInvalidSettingRow", expectedExceptions = InvalidSettingException.class)
    public void testInvalidSetRowSize(int rowSize) throws InvalidSettingException {
        settings.setRowSize(rowSize);
    }

    @DataProvider
    public static Object[][] dataInvalidSettingColumn(){
        return new Object[][] {
                {2},{1},{0},
                {-2},{-1},{-0},
                {-52},{-11},{-10}
        };
    }

    @Test(dataProvider = "dataInvalidSettingColumn", expectedExceptions = InvalidSettingException.class)
    public void testInvalidSetColumnSize(int columnSize) throws InvalidSettingException {
        settings.setColumnSize(columnSize);
    }

    @DataProvider
    public static Object[][] dataValidWinningLimit(){
        return new Object[][] {
            {6,7,7},
            {3,8,5},
            {3,30,30},
            {5,5,3},
            {3,3,3},
        };
    }

    @Test(dataProvider = "dataValidWinningLimit")
    public void testSetWinningLimit(int rowSize, int columnSize, int winningLimit) throws InvalidSettingException {
        settings.setRowSize(rowSize);
        settings.setColumnSize(columnSize);
        settings.setWinningLimit(winningLimit);
        Assert.assertEquals(settings.getWinningLimit(), winningLimit);
    }

    @DataProvider
    public static Object[][] dataInvalidWinningLimit(){
        return new Object[][] {
                {6,7,8},
                {3,8,2},
                {3,30,32},
                {5,5,10},
                {3,3,0},
        };
    }

    @Test(dataProvider = "dataInvalidWinningLimit", expectedExceptions = InvalidSettingException.class)
    public void testInvalidSetWinningLimit(int rowSize, int columnSize, int winningLimit) throws InvalidSettingException {
        settings.setRowSize(rowSize);
        settings.setColumnSize(columnSize);
        settings.setWinningLimit(winningLimit);
        Assert.assertEquals(settings.getWinningLimit(), winningLimit);
    }

    @DataProvider
    public static Object[][] dataSettingRounds(){
        return new Object[][] {
                {3,3},{4,4},{6,6},
                {5,5},{6,6},{7,7},
                {8,8},{9,9},{10,10}
        };
    }

    @Test(dataProvider = "dataSettingRounds")
    public void testSetNumberOfRounds(int numberOfRounds, int result) throws InvalidSettingException {
        settings.setNumberOfRounds(numberOfRounds);
        Assert.assertEquals(settings.getNumberOfRounds(), result);
    }
}
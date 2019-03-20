package kamil.rojek.ox.Game;

import kamil.rojek.ox.CustomExceptions.BoardCreatorException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Kamil Rojek
 */
public class BoardTest {

    @Test
    public void testBoardAfterInitializationIsNotNull(){
        Board board = new Board(3, 3);
        Assert.assertNotNull(board);
    }

    @DataProvider
    public static Object[][] dataBoardValidParameters(){
        return new Object[][] {
            {3,3}, {5,5}, {10,10}, {100,100}, {985,985},
            {3,12}, {23,4}, {5,200}, {232,323}, {121,11},
            {999,899}, {223,423}, {7,4}, {3,1231}, {23,3},
        };
    }

    @Test(dataProvider = "dataBoardValidParameters")
    public void testInitializeBoardWithValidParameters(int rowsNumber, int columnsNumber){
        new Board(rowsNumber, columnsNumber);
    }

    @DataProvider
    public static Object[][] dataBoardInvalidParameters(){
        return new Object[][] {
                {0,0}, {1,1}, {2,2}, {0,1}, {0,2},
                {1,0}, {2,0}, {-1,4}, {3,-3}, {-123,-11},
                {Integer.MIN_VALUE, 3}, {3,Integer.MIN_VALUE}, {-12,12}, {-3,1231}, {-233,0},
        };
    }

    @Test(dataProvider = "dataBoardInvalidParameters", expectedExceptions = IllegalArgumentException.class)
    public void testInitializeBoardWithInvalidParameters(int rowsNumber, int columnsNumber){
        new Board(rowsNumber, columnsNumber);
    }

    @Test(dataProvider = "dataBoardValidParameters")
    public void testValidEqualsOfBoards(int columnsNumber, int rowsNumber){
        Board board = new Board(rowsNumber,columnsNumber);
        Board board1 = new Board(rowsNumber,columnsNumber);
        Assert.assertTrue(board.equals(board1));
    }

    @DataProvider
    public static Object[][] dataBoardsIncorrectParametersForBoardsEquality(){
        return new Object[][]{
                {3,3,3,4}, {3,3,4,3}, {4,4,4,3}, {4,4,3,4},
                {3,3,3,4}, {3,3,4,3}, {4,4,4,3}, {4,4,3,4},
                {3,3,33,33}, {33,33,3,3}, {10,10,100,100}, {3,4,4,3},
                {23,32,32,23}, {12,3,45,3}, {42,41,42,33}, {34,44,34,43},
                {55,35,32,43}, {33,33,24,13}, {24,4,34,3}, {34,45,36,64}
        };
    }

    @Test(dataProvider = "dataBoardsIncorrectParametersForBoardsEquality")
    public void testInvalidEqualityOfBoards(int rows1, int columns1, int rows2, int columns2){
        Board board = new Board(rows1,columns1);
        Board board1 = new Board(rows2, columns2);
        Assert.assertFalse(board.equals(board1));
    }

    @DataProvider
    public static Object[][] dataMarkFeelds(){
        return new Object[][]{
            {2,2, SeedType.Cross, SeedType.Cross, true},
            {2,2, SeedType.Cross, SeedType.Nought, false},
            {2,2, SeedType.Nought, SeedType.Cross, false},
            {1,3, SeedType.Cross, SeedType.Cross, true},
            {4,4, SeedType.Nought, SeedType.Nought, true},
            {2,1, SeedType.Cross, SeedType.Nought, false}
        };
    }

    @Test(dataProvider = "dataMarkFeelds")
    public void testMarkFeeld(int rowNumbers, int columnNumbers, SeedType fill, SeedType expected, boolean result) throws BoardCreatorException {
        Board board = new BoardCreator().createNewBoard(10,10);
        board.markField(rowNumbers,columnNumbers, fill);

        Assert.assertEquals(board.fields[rowNumbers][columnNumbers].type.equals(expected), result);
    }
}
